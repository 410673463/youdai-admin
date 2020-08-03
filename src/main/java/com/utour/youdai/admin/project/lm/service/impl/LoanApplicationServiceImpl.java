package com.utour.youdai.admin.project.lm.service.impl;

import java.util.List;

import com.utour.youdai.admin.common.utils.DateUtils;
import com.utour.youdai.admin.project.lm.domain.LoanApplication;
import com.utour.youdai.admin.project.lm.mapper.LoanApplicationMapper;
import com.utour.youdai.admin.project.lm.service.ILoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 贷款管理-贷款申请Service业务层处理
 *
 * @author zh
 * @date 2020-08-02
 */
@Service
public class LoanApplicationServiceImpl implements ILoanApplicationService {
    private final LoanApplicationMapper loanApplicationMapper;

    public LoanApplicationServiceImpl(LoanApplicationMapper loanApplicationMapper) {
        this.loanApplicationMapper = loanApplicationMapper;
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
        loanApplication.setCreateTime(DateUtils.getNowDate());
        return loanApplicationMapper.insertLoanApplication(loanApplication);
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
        return loanApplicationMapper.updateLoanApplication(loanApplication);
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
}
