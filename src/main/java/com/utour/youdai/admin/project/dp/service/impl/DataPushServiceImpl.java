package com.utour.youdai.admin.project.dp.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.utour.youdai.admin.common.enums.HttpMethod;
import com.utour.youdai.admin.common.utils.SecurityUtils;
import com.utour.youdai.admin.common.utils.dataPush.ReqIdUtil;
import com.utour.youdai.admin.common.utils.dataPush.TokenUtil;
import com.utour.youdai.admin.common.utils.dataPush.ValidateSignUtil;
import com.utour.youdai.admin.common.utils.loan.RateUnit;
import com.utour.youdai.admin.project.bo.domain.Borrower;
import com.utour.youdai.admin.project.bo.domain.CorporateInfo;
import com.utour.youdai.admin.project.bo.domain.PersonalInfo;
import com.utour.youdai.admin.project.bo.service.IBorrowerService;
import com.utour.youdai.admin.project.bo.service.ICorporateInfoService;
import com.utour.youdai.admin.project.bo.service.IPersonalInfoService;
import com.utour.youdai.admin.project.dp.domain.DataPushRecords;
import com.utour.youdai.admin.project.dp.service.IDataPushRecordsService;
import com.utour.youdai.admin.project.dp.service.IDataPushService;
import com.utour.youdai.admin.project.fi.domain.LoanRecords;
import com.utour.youdai.admin.project.fi.domain.LoanRepaymentActual;
import com.utour.youdai.admin.project.fi.service.ILoanRecordsService;
import com.utour.youdai.admin.project.fi.service.ILoanRepaymentActualService;
import com.utour.youdai.admin.project.lm.domain.LoanApplication;
import com.utour.youdai.admin.project.fi.domain.LoanRepaymentPlan;
import com.utour.youdai.admin.project.lm.service.IExtensionApplyService;
import com.utour.youdai.admin.project.lm.service.ILoanApplicationService;
import com.utour.youdai.admin.project.fi.service.ILoanRepaymentPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;


@Service
public class DataPushServiceImpl implements IDataPushService {
    private static Log log = LogFactory.get();
    @Autowired
    private ILoanApplicationService loanApplicationService;
    @Autowired
    private IBorrowerService borrowerService;
    @Autowired
    private IPersonalInfoService personalInfoService;
    @Autowired
    private ICorporateInfoService corporateInfoService;
    @Autowired
    private ILoanRepaymentPlanService loanRepaymentPlanService;
    @Autowired
    private IDataPushRecordsService dataPushRecordsService;
    @Autowired
    private ILoanRepaymentActualService loanRepaymentActualService;
    @Autowired
    private ILoanRecordsService loanRecordsService;
    @Autowired
    private IExtensionApplyService extensionApplyService;
    @Value("${dataPush.CUSCC}")
    private String CUSCC;
    @Value("${dataPush.appKey}")
    private String appKey;
    @Value("${dataPush.clientId}")
    private String clientId;
    @Value("${dataPush.apiUrl}")
    private String apiUrl;


    @Override
    public String pushApplicationData(Long laId) {
        String roundStr = RandomUtil.randomNumbers(10);
        String reqId = ReqIdUtil.reqId(CUSCC);
        String token = TokenUtil.getToken(roundStr, clientId, appKey);
        JSONObject dataMap = new JSONObject();
        dataMap.put("clientId", clientId);
        dataMap.put("roundStr", roundStr);
        dataMap.put("appKey", appKey);
        dataMap.put("token", token);
        dataMap.put("reqId", reqId);
        LoanApplication apply = loanApplicationService.selectLoanApplicationById(laId);
        Borrower borrower = borrowerService.selectBorrowerById(apply.getBoid());
        dataMap.put("contractNumber", apply.getCode());//合同编号
        if (StrUtil.isBlank(apply.getApplicationName())) {
            dataMap.put("contractName", apply.getCode());//合同名称
        } else {
            dataMap.put("contractName", apply.getApplicationName());//合同名称
        }
        Integer borrowerType = borrower.getType().equals("个人") ? 2 : 1;
        dataMap.put("borrowerType", borrowerType.toString());//借款人类型
        dataMap.put("money", apply.getApplyMoney().stripTrailingZeros().toString());//贷款金额
        //贷款期限类型
        Integer termType = changeUnitToInteger(apply.getApplyExpiresUnit());
        dataMap.put("termType", termType.toString());
        dataMap.put("term", apply.getApplyExpires().toString()); //贷款期限
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dataMap.put("startDate", sdf.format(apply.getApplyStartDate()));
        dataMap.put("endDate", sdf.format(apply.getApplyEndDate()));
        Integer rateType = changeUnitToInteger(apply.getApplyRateUnit());
        dataMap.put("rateType", rateType.toString());//利率类型
        dataMap.put("rate", apply.getApplyRate().stripTrailingZeros().toString());//利率
        BigDecimal annualRate = RateUnit.changeRateToYear(apply.getApplyRateUnit(), apply.getApplyRate());
        //年化利率
        dataMap.put("annualRate", annualRate.stripTrailingZeros().toString());
        String platformCost = "0";
        if (apply.getPlatformCost() != null) {
            platformCost = apply.getPlatformCost().stripTrailingZeros().toString();
        }
        dataMap.put("platformCost", platformCost);//平台费
        dataMap.put("isEntrust", apply.getWhetherEntrust().toString());//受托支付
        dataMap.put("purpose", apply.getPurpose().toString());
        dataMap.put("business", apply.getBusiness().toString());
        //贷款方式
        // 多选：1信用，2保证，3抵押，4质押，5其它）
        //用逗号分隔   抵押、质押、保证、信用、其他
        StringBuffer loanMethod = new StringBuffer("");
        if (apply.getGuaranteeApplyType().equals("信用")) {
            loanMethod.append("1,");
        } else if (apply.getGuaranteeApplyType().equals("保证")) {
            loanMethod.append("2,");
        } else if (apply.getGuaranteeApplyType().equals("抵押")) {
            loanMethod.append("3,");
        } else if (apply.getGuaranteeApplyType().equals("质押")) {
            loanMethod.append("4,");
        } else if (apply.getGuaranteeApplyType().equals("其它")) {
            loanMethod.append("5,");
        }
        dataMap.put("loanMethod", loanMethod.deleteCharAt(loanMethod.length() - 1).toString());
        //还款方式 （1：等额本息:，2：等额本金，3：先息后本，4：灵活还款）
        Integer repayMethod = 0;
        if (apply.getRepayType().intValue() == 4) {
            repayMethod = 3;
        } else if (apply.getRepayType().intValue() == 5) {
            repayMethod = 4;
        } else if (apply.getRepayType().intValue() == 3) {
            repayMethod = 4;
        } else {
            repayMethod = apply.getRepayType();
        }
        dataMap.put("repayMethod", repayMethod.toString());
        //签订合同时间
        DateTime signTime = new DateTime();
        signTime.offset(DateField.MINUTE, -30);
        dataMap.put("signTime", signTime.toString());
        //还款来源
        dataMap.put("repaySource", apply.getRepaySource());
        //区域代码
        String districtCode = "";
        if (borrowerType == 1) {//企业
            CorporateInfo corporateInfo = corporateInfoService.getInfoByBoId(borrower.getId());
            districtCode = corporateInfo.getUniformSocialCreditCode().substring(2, 8);
            //企业借款人
            JSONObject enterpriseBorrower = new JSONObject();
            enterpriseBorrower.put("name", borrower.getName());
            enterpriseBorrower.put("scale", corporateInfo.getScale());
            enterpriseBorrower.put("industryType", borrower.getIndustryType());
            enterpriseBorrower.put("industryInvolved", borrower.getIndustrys());
            enterpriseBorrower.put("licenseCode", corporateInfo.getBusinessLicenseCode());
            enterpriseBorrower.put("licenseEndDate", sdf.format(corporateInfo.getBusinessLicenseEndDate()));
            dataMap.put("enterpriseBorrower", enterpriseBorrower);
        } else {
            //个人
            PersonalInfo personalInfo = personalInfoService.getInfoByBoId(borrower.getId());
            districtCode = personalInfo.getIdentityNo().substring(0, 6);
            //个人借款人
            JSONObject personBorrower = new JSONObject();
            personBorrower.put("name", borrower.getName());
            personBorrower.put("sex", personalInfo.getGender().equals("男") ? 1 : 2);
            Integer cardType = 0;
            if (personalInfo.getIdentityType().equals("二代身份证")) {
                cardType = 1;
            } else if (personalInfo.getIdentityType().equals("港澳通行证")) {
                cardType = 2;
            } else if (personalInfo.getIdentityType().equals("台湾通行证")) {
                cardType = 3;
            } else if (personalInfo.getIdentityType().equals("护照")) {
                cardType = 4;
            }
            personBorrower.put("cardType", cardType);
            personBorrower.put("cardNumber", personalInfo.getIdentityNo());
            personBorrower.put("phone", personalInfo.getPhoneno1());
            personBorrower.put("isFarmer", 0);
            dataMap.put("personBorrower", personBorrower);
        }
        dataMap.put("districtCode", districtCode);
        //还款计划
        JSONArray repayArr = new JSONArray();
        List<LoanRepaymentPlan> repayList = loanRepaymentPlanService.getPlanList(apply.getId());
        for (LoanRepaymentPlan plan : repayList) {
            JSONObject p = new JSONObject();
            p.put("endDate", sdf.format(plan.getPlanDate()));
            p.put("money", plan.getPlanPrincipalMoney().stripTrailingZeros());
            p.put("interest", plan.getPlanInterestMoney().stripTrailingZeros());
            repayArr.add(p);
        }
        dataMap.put("repayPlans", repayArr);
        //签名
        LinkedList<String> fieldArr = new LinkedList<String>() {{
            add("borrowerType");
            add("business");
            add("clientId");
            add("contractName");
            add("contractNumber");
            add("endDate");
            add("loanMethod");
            add("money");
            add("purpose");
            add("rate");
            add("rateType");
            add("repayMethod");
            add("repaySource");
            add("reqId");
            add("roundStr");
            add("signTime");
            add("startDate");
            add("term");
            add("termType");
            add("token");
            //add("appKey");
        }};
        JSONObject signMap = getSignMap(fieldArr, dataMap);
        //生成签名串
        String sign = ValidateSignUtil.validateSign(signMap, appKey);
        dataMap.put("sign", sign);
        String resultCode = pushData(dataMap, "/loan-contract", HttpMethod.POST, "lm_loan_application", laId);
        return resultCode;
    }

    @Override
    public String deleteApplicationData(Long laId) {
        String roundStr = RandomUtil.randomNumbers(10);
        String token = TokenUtil.getToken(roundStr, clientId, appKey);
        JSONObject dataMap = new JSONObject();
        dataMap.put("clientId", clientId);
        dataMap.put("roundStr", roundStr);
        dataMap.put("appKey", appKey);
        dataMap.put("token", token);
        String reqId = dataPushRecordsService.getPushReqId(laId, "lm_loan_application", HttpMethod.POST.toString(), "/loan-contract");
        dataMap.put("reqId", reqId);
        //签名
        LinkedList<String> fieldArr = new LinkedList<String>() {{
            add("clientId");
            add("reqId");
            add("roundStr");
            add("token");
        }};
        JSONObject signMap = getSignMap(fieldArr, dataMap);
        String sign = ValidateSignUtil.validateSign(signMap, appKey);
        dataMap.put("sign", sign);
        String resultCode = pushData(dataMap, "/loan-contract", HttpMethod.DELETE, "lm_loan_application", laId);
        return resultCode;
    }

    @Override
    public String pushRepayActual(Long lraId) {
        String roundStr = RandomUtil.randomNumbers(10);
        String token = TokenUtil.getToken(roundStr, clientId, appKey);
        JSONObject dataMap = new JSONObject();
        dataMap.put("clientId", clientId);
        dataMap.put("roundStr", roundStr);
        dataMap.put("appKey", appKey);
        dataMap.put("token", token);
        String reqId = ReqIdUtil.reqId(CUSCC);
        dataMap.put("reqId", reqId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LoanRepaymentActual actual = loanRepaymentActualService.selectRepayActualWithApplyInfoById(lraId);
        //还款日期
        dataMap.put("repayTime", sdf.format(actual.getActualDate()));
        String path = "";
        String contractNumber = "";
        LoanApplication apply = loanApplicationService.selectLoanApplicationById(actual.getLaId());
        if (apply.getApplyNature().intValue() == 3) {
            path = "/extend-repay";
            contractNumber = extensionApplyService.getApplyCodeByExtensionId(apply.getId());
        } else {
            path = "/repay";
            contractNumber = actual.getApplicationCode();
        }
        //关联主合同编号
        dataMap.put("contractNumber", contractNumber);
        //还款本金
        dataMap.put("money", actual.getActualPrincipalMoney().stripTrailingZeros().toPlainString());
        //利息
        dataMap.put("interest", actual.getActualInterestMoney().stripTrailingZeros().toPlainString());
        //罚息
        dataMap.put("penaltyInterest", actual.getPenaltyInterest().stripTrailingZeros().toPlainString());
        //违约金
        dataMap.put("penalty", actual.getPenalty().stripTrailingZeros().toPlainString());
        //服务费
        dataMap.put("serviceCharge", actual.getServiceCharge().stripTrailingZeros().toPlainString());
        //其它费用
        dataMap.put("otherCharge", actual.getOtherCharge().stripTrailingZeros().toPlainString());
        LinkedList<String> fieldArr = new LinkedList<String>() {{
            add("clientId");
            add("contractNumber");
            add("interest");
            add("money");
            add("otherCharge");
            add("penalty");
            add("penaltyInterest");
            add("repayTime");
            add("reqId");
            add("roundStr");
            add("serviceCharge");
            add("token");
        }};
        JSONObject signMap = getSignMap(fieldArr, dataMap);
        //生成签名串
        String sign = ValidateSignUtil.validateSign(signMap, appKey);
        dataMap.put("sign", sign);


        String resultCode = pushData(dataMap, path, HttpMethod.POST, "fi_loan_repayment_actual", lraId);
        return resultCode;
    }

    @Override
    public String pushLoanRecords(Long id) {
        LoanRecords record = loanRecordsService.selectLoanRecordsById(id);
        String roundStr = RandomUtil.randomNumbers(10);
        String token = TokenUtil.getToken(roundStr, clientId, appKey);
        JSONObject dataMap = new JSONObject();
        dataMap.put("clientId", clientId);
        dataMap.put("roundStr", roundStr);
        dataMap.put("appKey", appKey);
        dataMap.put("token", token);
        String reqId = ReqIdUtil.reqId(CUSCC);
        dataMap.put("reqId", reqId);
        //合同号
        dataMap.put("contractNumber", record.getApplyCode());
        //放款金额
        dataMap.put("money", record.getMoney().stripTrailingZeros().toPlainString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dataMap.put("loanTime", sdf.format(record.getLoanTime()));
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        dataMap.put("startDate", sdf.format(record.getStartDate()));
        dataMap.put("endDate", sdf.format(record.getEndDate()));
        LinkedList<String> fieldArr = new LinkedList<String>() {{
            add("clientId");
            add("contractNumber");
            add("loanTime");
            add("money");
            add("reqId");
            add("roundStr");
            add("token");
        }};
        JSONObject signMap = getSignMap(fieldArr, dataMap);
        //生成签名串
        String sign = ValidateSignUtil.validateSign(signMap, appKey);
        dataMap.put("sign", sign);
        String resultCode = pushData(dataMap, "/loan-info", HttpMethod.POST, "fi_loan_records", id);
        return resultCode;
    }

    @Override
    public String pushExtensionApplicationData(Long laId) {
        String roundStr = RandomUtil.randomNumbers(10);
        String token = TokenUtil.getToken(roundStr, clientId, appKey);
        JSONObject dataMap = new JSONObject();
        dataMap.put("clientId", clientId);
        dataMap.put("roundStr", roundStr);
        dataMap.put("appKey", appKey);
        dataMap.put("token", token);
        String reqId = ReqIdUtil.reqId(CUSCC);
        dataMap.put("reqId", reqId);
        //合同号
        dataMap.put("contractNumber", extensionApplyService.getApplyCodeByExtensionId(laId));

        JSONArray repayArr = new JSONArray();
        List<LoanRepaymentPlan> repayList = loanRepaymentPlanService.getPlanList(laId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (LoanRepaymentPlan plan : repayList) {
            JSONObject p = new JSONObject();
            p.put("endDate", sdf.format(plan.getPlanDate()));
            p.put("principal", plan.getPlanPrincipalMoney().stripTrailingZeros());
            p.put("interest", plan.getPlanInterestMoney().stripTrailingZeros());
            repayArr.add(p);
        }
        dataMap.put("plans", repayArr);

        int count = extensionApplyService.extensionCountsByExtensionId(laId);
        dataMap.put("count", String.valueOf(count));
        LinkedList<String> fieldArr = new LinkedList<String>() {{
            add("clientId");
            add("contractNumber");
            add("count");
            add("reqId");
            add("roundStr");
            add("token");
        }};
        JSONObject signMap = getSignMap(fieldArr, dataMap);
        //生成签名串
        String sign = ValidateSignUtil.validateSign(signMap, appKey);
        dataMap.put("sign", sign);
        String re = pushData(dataMap, "/extend-repay-plan", HttpMethod.POST, "lm_loan_application", laId);
        return re;
    }

    private String pushData(JSONObject param, String path, HttpMethod method, String dataTable, Long primaryId) {
        DataPushRecords records = new DataPushRecords();
        records.setDataTable(dataTable);
        records.setParam(param.toJSONString());
        records.setPath(path);
        records.setPrimaryId(primaryId);
        records.setReqId(param.getString("reqId"));
        records.setRoundStr(param.getString("roundStr"));
        records.setSign(param.getString("sign"));
        records.setToken(param.getString("token"));
        records.setCreateUser(SecurityUtils.getUsername());
        records.setCreateUserId(SecurityUtils.getLoginUser().getUser().getUserId());
        records.setCreateTime(new Date());
        records.setRequestMethod(method.toString());
        String url = apiUrl + path;
        String result = "";
        records.setRequestTime(new Date());
        if (method == HttpMethod.POST) {
            result = HttpRequest.post(url).body(param.toJSONString()).execute().body();
        } else if (method == HttpMethod.GET) {
            result = HttpRequest.get(url).body(param.toJSONString()).execute().body();
        } else if (method == HttpMethod.PUT) {
            result = HttpRequest.put(url).body(param.toJSONString()).execute().body();
        } else if (method == HttpMethod.DELETE) {
            result = HttpRequest.delete(url).body(param.toJSONString()).execute().body();
        }
        log.info("Data-Push-Response:" + result);
        records.setResponseTime(new Date());
        records.setResponseResult(result);
        dataPushRecordsService.insertDataPushRecords(records);
        //解析返回结果，更新对应表记录 推送状态
        int pushStatus = 3;
        String resultCode = "";
        JSONObject resultJson = null;
        try {
            resultJson = JSON.parseObject(result);
            resultCode = resultJson.getString("resultCode");
            if (method == HttpMethod.DELETE && resultCode.equals("0")) {//删除方法并且返回成功，更新主表状态为2审核中
                pushStatus = 2;
            } else {//其他方法请求， 如果请求失败，更新主表状态为 推送失败
                if (!resultCode.equals("0")) {
                    pushStatus = 0;
                }
            }
        }catch (JSONException e){
            pushStatus = 0;
            resultCode = "-1";
        }
        dataPushRecordsService.updatePushDataStatus(dataTable, primaryId, pushStatus);
        return resultCode;
    }


    /**
     * 通过复制dataMap里的数据，获取有顺序的 signMap，供生成签名使用
     *
     * @return LinkedHashMap JSONObject
     */
    private JSONObject getSignMap(LinkedList<String> arr, JSONObject dataMap) {
        JSONObject signMap = new JSONObject(new LinkedHashMap<>());
        for (String s : arr) {
            signMap.put(s, dataMap.get(s));
        }
        return signMap;
    }

    /**
     * 单位转换为 integer
     *
     * @param unit
     * @return
     */
    private Integer changeUnitToInteger(String unit) {
        Integer i = 0;
        if (unit.equals("月")) {
            i = 3;
        } else if (unit.equals("年")) {
            i = 5;
        } else if (unit.equals("日")) {
            i = 1;
        }
        return i;
    }
}
