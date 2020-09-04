package com.utour.youdai.admin.project.bo.mapper;

import com.utour.youdai.admin.project.bo.domain.BankAccount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 借款人-银行账户信息Mapper接口
 *
 * @author zh
 * @date 2020-08-01
 */
@Mapper
@Repository
public interface BankAccountMapper {
    /**
     * 查询借款人-银行账户信息
     *
     * @param id 借款人-银行账户信息ID
     * @return 借款人-银行账户信息
     */
    public BankAccount selectBankAccountById(Long id);

    /**
     * 查询借款人-银行账户信息列表
     *
     * @param bankAccount 借款人-银行账户信息
     * @return 借款人-银行账户信息集合
     */
    public List<BankAccount> selectBankAccountList(BankAccount bankAccount);

    /**
     * 新增借款人-银行账户信息
     *
     * @param bankAccount 借款人-银行账户信息
     * @return 结果
     */
    public int insertBankAccount(BankAccount bankAccount);

    /**
     * 修改借款人-银行账户信息
     *
     * @param bankAccount 借款人-银行账户信息
     * @return 结果
     */
    public int updateBankAccount(BankAccount bankAccount);

    /**
     * 删除借款人-银行账户信息
     *
     * @param id 借款人-银行账户信息ID
     * @return 结果
     */
    public int deleteBankAccountById(Long id);

    /**
     * 批量删除借款人-银行账户信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBankAccountByIds(Long[] ids);

    List<BankAccount> getAccountsByBoId(Long boId);
}
