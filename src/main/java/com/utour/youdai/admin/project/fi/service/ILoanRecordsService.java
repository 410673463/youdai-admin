package com.utour.youdai.admin.project.fi.service;

import com.utour.youdai.admin.project.fi.domain.LoanRecords;

import java.util.List;

/**
 * 放款记录Service接口
 *
 * @author zh
 * @date 2020-09-02
 */
public interface ILoanRecordsService {
    /**
     * 查询放款记录
     *
     * @param id 放款记录ID
     * @return 放款记录
     */
    public LoanRecords selectLoanRecordsById(Long id);

    /**
     * 查询放款记录列表
     *
     * @param loanRecords 放款记录
     * @return 放款记录集合
     */
    public List<LoanRecords> selectLoanRecordsList(LoanRecords loanRecords);

    /**
     * 新增放款记录
     *
     * @param loanRecords 放款记录
     * @return 结果
     */
    public int insertLoanRecords(LoanRecords loanRecords);

    /**
     * 修改放款记录
     *
     * @param loanRecords 放款记录
     * @return 结果
     */
    public int updateLoanRecords(LoanRecords loanRecords);

    /**
     * 批量删除放款记录
     *
     * @param ids 需要删除的放款记录ID
     * @return 结果
     */
    public int deleteLoanRecordsByIds(Long[] ids);

    /**
     * 删除放款记录信息
     *
     * @param id 放款记录ID
     * @return 结果
     */
    public int deleteLoanRecordsById(Long id);
}
