package com.utour.youdai.admin.project.fi.service.impl;

import java.util.List;

import com.utour.youdai.admin.common.utils.DateUtils;
import com.utour.youdai.admin.project.fi.domain.LoanRecords;
import com.utour.youdai.admin.project.fi.mapper.LoanRecordsMapper;
import com.utour.youdai.admin.project.fi.service.ILoanRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 放款记录Service业务层处理
 *
 * @author zh
 * @date 2020-09-02
 */
@Service
public class LoanRecordsServiceImpl implements ILoanRecordsService {
    @Autowired
    private LoanRecordsMapper loanRecordsMapper;

    /**
     * 查询放款记录
     *
     * @param id 放款记录ID
     * @return 放款记录
     */
    @Override
    public LoanRecords selectLoanRecordsById(Long id) {
        return loanRecordsMapper.selectLoanRecordsById(id);
    }

    /**
     * 查询放款记录列表
     *
     * @param loanRecords 放款记录
     * @return 放款记录
     */
    @Override
    public List<LoanRecords> selectLoanRecordsList(LoanRecords loanRecords) {
        return loanRecordsMapper.selectLoanRecordsList(loanRecords);
    }

    /**
     * 新增放款记录
     *
     * @param loanRecords 放款记录
     * @return 结果
     */
    @Override
    public int insertLoanRecords(LoanRecords loanRecords) {
        loanRecords.setCreateTime(DateUtils.getNowDate());
        return loanRecordsMapper.insertLoanRecords(loanRecords);
    }

    /**
     * 修改放款记录
     *
     * @param loanRecords 放款记录
     * @return 结果
     */
    @Override
    public int updateLoanRecords(LoanRecords loanRecords) {
        return loanRecordsMapper.updateLoanRecords(loanRecords);
    }

    /**
     * 批量删除放款记录
     *
     * @param ids 需要删除的放款记录ID
     * @return 结果
     */
    @Override
    public int deleteLoanRecordsByIds(Long[] ids) {
        return loanRecordsMapper.deleteLoanRecordsByIds(ids);
    }

    /**
     * 删除放款记录信息
     *
     * @param id 放款记录ID
     * @return 结果
     */
    @Override
    public int deleteLoanRecordsById(Long id) {
        return loanRecordsMapper.deleteLoanRecordsById(id);
    }
}
