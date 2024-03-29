package com.utour.youdai.admin.project.lm.mapper;

import com.alibaba.fastjson.JSONArray;
import com.utour.youdai.admin.project.lm.domain.LoanApplication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 贷款管理-贷款申请Mapper接口
 *
 * @author zh
 * @date 2020-08-02
 */
@Mapper
@Repository
public interface LoanApplicationMapper {
    /**
     * 查询贷款管理-贷款申请
     *
     * @param id 贷款管理-贷款申请ID
     * @return 贷款管理-贷款申请
     */
    public LoanApplication selectLoanApplicationById(Long id);

    /**
     * 查询贷款管理-贷款申请列表
     *
     * @param loanApplication 贷款管理-贷款申请
     * @return 贷款管理-贷款申请集合
     */
    public List<LoanApplication> selectLoanApplicationList(LoanApplication loanApplication);

    /**
     * 新增贷款管理-贷款申请
     *
     * @param loanApplication 贷款管理-贷款申请
     * @return 结果
     */
    public int insertLoanApplication(LoanApplication loanApplication);

    /**
     * 修改贷款管理-贷款申请
     *
     * @param loanApplication 贷款管理-贷款申请
     * @return 结果
     */
    public int updateLoanApplication(LoanApplication loanApplication);

    /**
     * 删除贷款管理-贷款申请
     *
     * @param id 贷款管理-贷款申请ID
     * @return 结果
     */
    public int deleteLoanApplicationById(Long id);

    /**
     * 批量删除贷款管理-贷款申请
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLoanApplicationByIds(Long[] ids);

    int updateApplyStatus(@Param("status")int status,@Param("ids") JSONArray ids);

    /**
     * 查询贷款申请推送列表  只查询状态 >=8的 申请，  签订合同和历史数据补录的
     * @param loanApplication
     * @return
     */
    List<LoanApplication> getLoanApplicationPushList(LoanApplication loanApplication);

    /**
     * 查询贷款申请  status 》= 8，
     * @param loanApplication
     * @return
     */
    List<LoanApplication> selectLoanApplicationExceptLoanRecords(LoanApplication loanApplication);

    /**
     * 延期贷款申请列表
     * @param loanApplication
     * @return
     */
    List<LoanApplication> selectExtensionLoanApplicationList(LoanApplication loanApplication);

    /**
     * 通过code 获取 id
     * @param code
     * @return
     */
    Long getIdByCode(String code);

    /**
     * 查询还款 申请列表
     * @param loanApplication
     * @return
     */
    List<LoanApplication> getRepayApplyList(LoanApplication loanApplication);

    /**
     *Id查询编码
     * @param laId
     * @return
     */
    String selectApplyCodeById(Long laId);
}
