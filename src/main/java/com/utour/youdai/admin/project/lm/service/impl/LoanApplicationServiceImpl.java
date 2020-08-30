package com.utour.youdai.admin.project.lm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.utour.youdai.admin.common.utils.CodeGeneratorFactory;
import com.utour.youdai.admin.common.utils.DateUtils;
import com.utour.youdai.admin.project.lm.domain.LoanApplication;
import com.utour.youdai.admin.project.lm.mapper.LoanApplicationMapper;
import com.utour.youdai.admin.project.lm.service.ILoanApplicationService;
import com.utour.youdai.admin.project.fi.service.ILoanRepaymentPlanService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 贷款管理-贷款申请Service业务层处理
 *
 * @author zh
 * @date 2020-08-02
 */
@Service
public class LoanApplicationServiceImpl implements ILoanApplicationService {
    private final LoanApplicationMapper loanApplicationMapper;
    private final ILoanRepaymentPlanService loanRepaymentPlanService;

    public LoanApplicationServiceImpl(LoanApplicationMapper loanApplicationMapper, ILoanRepaymentPlanService loanRepaymentPlanService) {
        this.loanApplicationMapper = loanApplicationMapper;
        this.loanRepaymentPlanService = loanRepaymentPlanService;
    }

    /**
     * 查询贷款管理-贷款申请
     *
     * @param id 贷款管理-贷款申请ID
     * @return 贷款管理-贷款申请
     */
    @Override
    public LoanApplication selectLoanApplicationById(Long id) {
        return loanApplicationMapper.selectLoanApplicationById(id);
    }

    /**
     * 查询贷款管理-贷款申请列表
     *
     * @param loanApplication 贷款管理-贷款申请
     * @return 贷款管理-贷款申请
     */
    @Override
    public List<LoanApplication> selectLoanApplicationList(LoanApplication loanApplication) {
        return loanApplicationMapper.selectLoanApplicationList(loanApplication);
    }

    /**
     * 新增贷款管理-贷款申请
     *
     * @param loanApplication 贷款管理-贷款申请
     * @return 结果
     */
    @Override
    public int insertLoanApplication(LoanApplication loanApplication) {
        String code = CodeGeneratorFactory.getCode("LM-", 4);
        loanApplication.setCode(code);
        loanApplication.setCreateTime(DateUtils.getNowDate());
        int n = loanApplicationMapper.insertLoanApplication(loanApplication);

        //生成还款计划
        loanRepaymentPlanService.createRepayPlan(loanApplication);
        return n;
    }

    /**
     * 修改贷款管理-贷款申请
     *
     * @param loanApplication 贷款管理-贷款申请
     * @return 结果
     */
    @Override
    public int updateLoanApplication(LoanApplication loanApplication) {
        loanApplication.setUpdateTime(DateUtils.getNowDate());
        int n = loanApplicationMapper.updateLoanApplication(loanApplication);
        //重新生成还款计划
        loanRepaymentPlanService.deletePlanByLaId(loanApplication.getId());
        loanRepaymentPlanService.createRepayPlan(loanApplication);
        return n;
    }

    /**
     * 批量删除贷款管理-贷款申请
     *
     * @param ids 需要删除的贷款管理-贷款申请ID
     * @return 结果
     */
    @Override
    public int deleteLoanApplicationByIds(Long[] ids) {
        return loanApplicationMapper.deleteLoanApplicationByIds(ids);
    }

    /**
     * 删除贷款管理-贷款申请信息
     *
     * @param id 贷款管理-贷款申请ID
     * @return 结果
     */
    @Override
    public int deleteLoanApplicationById(Long id) {
        return loanApplicationMapper.deleteLoanApplicationById(id);
    }

    @Override
    public int updateApplyStatus(int status, JSONArray ids) {
        int n = loanApplicationMapper.updateApplyStatus(status, ids);
        return n;
    }

    @Override
    public List<LoanApplication> getLoanApplicationPushList(LoanApplication loanApplication) {
        return loanApplicationMapper.getLoanApplicationPushList(loanApplication);
    }

    @Override
    public List<LoanApplication> getRepayApplyList(LoanApplication loanApplication) {
        return loanApplicationMapper.getLoanApplicationPushList(loanApplication);
    }
}
