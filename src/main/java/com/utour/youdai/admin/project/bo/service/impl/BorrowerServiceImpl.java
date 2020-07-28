package com.utour.youdai.admin.project.bo.service.impl;


import com.utour.youdai.admin.project.bo.domain.Borrower;
import com.utour.youdai.admin.project.bo.mapper.BorrowerMapper;
import com.utour.youdai.admin.project.bo.service.IBorrowerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 借款人-基本信息(主)Service业务层处理
 *
 * @author zh
 * @date 2020-07-28
 */
@Service
public class BorrowerServiceImpl implements IBorrowerService {
    private final BorrowerMapper borrowerMapper;

    public BorrowerServiceImpl(BorrowerMapper borrowerMapper) {
        this.borrowerMapper = borrowerMapper;
    }

    /**
     * 查询借款人-基本信息(主)
     *
     * @param id 借款人-基本信息(主)ID
     * @return 借款人-基本信息(主)
     */
    @Override
    public Borrower selectBorrowerById(Long id) {
        return borrowerMapper.selectBorrowerById(id);
    }

    /**
     * 查询借款人-基本信息(主)列表
     *
     * @param Borrower 借款人-基本信息(主)
     * @return 借款人-基本信息(主)
     */
    @Override
    public List<Borrower> selectBorrowerList(Borrower Borrower) {
        return borrowerMapper.selectBorrowerList(Borrower);
    }

    /**
     * 新增借款人-基本信息(主)
     *
     * @param Borrower 借款人-基本信息(主)
     * @return 结果
     */
    @Override
    public int insertBorrower(Borrower Borrower) {
        return borrowerMapper.insertBorrower(Borrower);
    }

    /**
     * 修改借款人-基本信息(主)
     *
     * @param Borrower 借款人-基本信息(主)
     * @return 结果
     */
    @Override
    public int updateBorrower(Borrower Borrower) {
        return borrowerMapper.updateBorrower(Borrower);
    }

    /**
     * 批量删除借款人-基本信息(主)
     *
     * @param ids 需要删除的借款人-基本信息(主)ID
     * @return 结果
     */
    @Override
    public int deleteBorrowerByIds(Long[] ids) {
        return borrowerMapper.deleteBorrowerByIds(ids);
    }

    /**
     * 删除借款人-基本信息(主)信息
     *
     * @param id 借款人-基本信息(主)ID
     * @return 结果
     */
    @Override
    public int deleteBorrowerById(Long id) {
        return borrowerMapper.deleteBorrowerById(id);
    }
}
