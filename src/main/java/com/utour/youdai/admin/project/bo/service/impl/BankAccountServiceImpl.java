package com.utour.youdai.admin.project.bo.service.impl;

import com.utour.youdai.admin.project.bo.domain.BankAccount;
import com.utour.youdai.admin.project.bo.mapper.BankAccountMapper;
import com.utour.youdai.admin.project.bo.service.IBankAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 借款人-银行账户信息Service业务层处理
 *
 * @author zh
 * @date 2020-08-01
 */
@Service
public class BankAccountServiceImpl implements IBankAccountService {
    private final BankAccountMapper bankAccountMapper;

    public BankAccountServiceImpl(BankAccountMapper bankAccountMapper) {
        this.bankAccountMapper = bankAccountMapper;
    }

    /**
     * 查询借款人-银行账户信息
     *
     * @param id 借款人-银行账户信息ID
     * @return 借款人-银行账户信息
     */
    @Override
    public BankAccount selectBankAccountById(Long id) {
        return bankAccountMapper.selectBankAccountById(id);
    }

    /**
     * 查询借款人-银行账户信息列表
     *
     * @param bankAccount 借款人-银行账户信息
     * @return 借款人-银行账户信息
     */
    @Override
    public List<BankAccount> selectBankAccountList(BankAccount bankAccount) {
        return bankAccountMapper.selectBankAccountList(bankAccount);
    }

    /**
     * 新增借款人-银行账户信息
     *
     * @param bankAccount 借款人-银行账户信息
     * @return 结果
     */
    @Override
    public int insertBankAccount(BankAccount bankAccount) {
        return bankAccountMapper.insertBankAccount(bankAccount);
    }

    /**
     * 修改借款人-银行账户信息
     *
     * @param bankAccount 借款人-银行账户信息
     * @return 结果
     */
    @Override
    public int updateBankAccount(BankAccount bankAccount) {
        return bankAccountMapper.updateBankAccount(bankAccount);
    }

    /**
     * 批量删除借款人-银行账户信息
     *
     * @param ids 需要删除的借款人-银行账户信息ID
     * @return 结果
     */
    @Override
    public int deleteBankAccountByIds(Long[] ids) {
        return bankAccountMapper.deleteBankAccountByIds(ids);
    }

    /**
     * 删除借款人-银行账户信息信息
     *
     * @param id 借款人-银行账户信息ID
     * @return 结果
     */
    @Override
    public int deleteBankAccountById(Long id) {
        return bankAccountMapper.deleteBankAccountById(id);
    }
}
