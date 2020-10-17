package com.utour.youdai.admin.project.fi.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.utour.youdai.admin.common.utils.SecurityUtils;
import com.utour.youdai.admin.project.fi.domain.LoanRepaymentActual;
import com.utour.youdai.admin.project.fi.domain.LoanRepaymentPlan;
import com.utour.youdai.admin.project.fi.mapper.LoanRepaymentActualMapper;
import com.utour.youdai.admin.project.fi.service.ILoanRepaymentActualService;
import com.utour.youdai.admin.project.lm.domain.ExtensionApply;
import com.utour.youdai.admin.project.lm.service.IExtensionApplyService;
import com.utour.youdai.admin.project.lm.service.ILoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 实际还款Service业务层处理
 *
 * @author zh
 * @date 2020-08-29
 */
@Service
public class LoanRepaymentActualServiceImpl implements ILoanRepaymentActualService {
    @Autowired
    private LoanRepaymentActualMapper loanRepaymentActualMapper;
    @Autowired
    private ILoanApplicationService loanApplicationService;
    @Autowired
    private IExtensionApplyService extensionApplyService;
    /**
     * 查询实际还款
     *
     * @param id 实际还款ID
     * @return 实际还款
     */
    @Override
    public LoanRepaymentActual selectLoanRepaymentActualById(Long id) {
        return loanRepaymentActualMapper.selectLoanRepaymentActualById(id);
    }

    @Override
    public LoanRepaymentActual selectRepayActualWithApplyInfoById(Long id) {
        return loanRepaymentActualMapper.selectRepayActualWithApplyInfoById(id);
    }

    /**
     * 查询实际还款列表
     *
     * @param loanRepaymentActual 实际还款
     * @return 实际还款
     */
    @Override
    public List<LoanRepaymentActual> selectLoanRepaymentActualList(LoanRepaymentActual loanRepaymentActual) {
        return loanRepaymentActualMapper.selectRepayActualListWithApplyInfo(loanRepaymentActual);
    }

    /**
     * 新增实际还款
     *
     * @param loanRepaymentActual 实际还款
     * @return 结果
     */
    @Override
    public int insertLoanRepaymentActual(LoanRepaymentActual loanRepaymentActual) {
        return loanRepaymentActualMapper.insertLoanRepaymentActual(loanRepaymentActual);
    }

    /**
     * 修改实际还款
     *
     * @param loanRepaymentActual 实际还款
     * @return 结果
     */
    @Override
    public int updateLoanRepaymentActual(LoanRepaymentActual loanRepaymentActual) {
        return loanRepaymentActualMapper.updateLoanRepaymentActual(loanRepaymentActual);
    }

    /**
     * 批量删除实际还款
     *
     * @param ids 需要删除的实际还款ID
     * @return 结果
     */
    @Override
    public int deleteLoanRepaymentActualByIds(Long[] ids) {
        return loanRepaymentActualMapper.deleteLoanRepaymentActualByIds(ids);
    }

    /**
     * 删除实际还款信息
     *
     * @param id 实际还款ID
     * @return 结果
     */
    @Override
    public int deleteLoanRepaymentActualById(Long id) {
        return loanRepaymentActualMapper.deleteLoanRepaymentActualById(id);
    }

    @Override
    public Long save(JSONObject jsonObject) {
        Boolean pushFlag = jsonObject.getBoolean("push");
        jsonObject.remove("push");
        LoanRepaymentActual repay = JSONObject.toJavaObject(jsonObject, LoanRepaymentActual.class);
        repay.setCreateUser(SecurityUtils.getUsername());
        repay.setCreateUserId(SecurityUtils.getLoginUser().getUser().getUserId());
        repay.setCreateTime(new Date());
        repay.setPushStatus(1);//待推送
        int i = loanRepaymentActualMapper.insertLoanRepaymentActual(repay);
       /* if(pushFlag){//推送数据
            dataPushService.pushRepayActual(repay.getId());
        }*/
        return repay.getId();
    }

    @Override
    public List<LoanRepaymentActual> getActualListByPlanLrpId(Long lrpId) {
        return loanRepaymentActualMapper.getActualListByPlanLrpId(lrpId);
    }

    @Override
    public JSONArray selectActualListWithExtensionByPlanLaId(Long laId) {
        JSONArray data = new JSONArray();
        JSONObject object = new JSONObject();
        List actuals = loanRepaymentActualMapper.selectActualListByPlanLaId(laId);
        object.put("code",loanApplicationService.selectApplyCodeById(laId));
        object.put("list",actuals);
        data.add(object);
        List<ExtensionApply> extensions = extensionApplyService.selectExtensionsByLaId(laId);
        if (extensions != null && !extensions.isEmpty()) {
            for (ExtensionApply e : extensions) {
                JSONObject ex = new JSONObject();
                List<LoanRepaymentActual> extensionActuals = loanRepaymentActualMapper.selectActualListByPlanLaId(e.getExtensionId());
                if(extensionActuals != null && !extensionActuals.isEmpty()){
                    ex.put("list",extensionActuals);
                    ex.put("code", e.getExtensionCode());
                    data.add(ex);
                }
            }
        }
        return data;
    }
}
