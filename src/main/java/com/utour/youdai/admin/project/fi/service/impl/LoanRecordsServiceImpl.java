package com.utour.youdai.admin.project.fi.service.impl;

import com.utour.youdai.admin.common.utils.DateUtils;
import com.utour.youdai.admin.common.utils.SecurityUtils;
import com.utour.youdai.admin.project.fi.domain.LoanRecords;
import com.utour.youdai.admin.project.fi.mapper.LoanRecordsMapper;
import com.utour.youdai.admin.project.fi.service.ILoanRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


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
    public Long insertLoanRecords(LoanRecords loanRecords) {
        Integer audit = 0;
        if (loanRecords.getRemark() != null && loanRecords.getRemark().equals("makeUp")) {
            audit = 2;//补录
            loanRecords.setFiAuditTime(new Date());
            loanRecords.setFiAuditUser("系统");
            loanRecords.setCaAuditTime(new Date());
            loanRecords.setCaAuditUser("系统");
        }
        loanRecords.setPushStatus(1);
        loanRecords.setCaAuditStatus(audit);
        loanRecords.setFiAuditStatus(audit);
        loanRecords.setCreateUser(SecurityUtils.getUsername());
        loanRecords.setCreateUserId(SecurityUtils.getLoginUser().getUser().getUserId());
        loanRecords.setCreateTime(DateUtils.getNowDate());
        loanRecordsMapper.insertLoanRecords(loanRecords);
        return loanRecords.getId();
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
