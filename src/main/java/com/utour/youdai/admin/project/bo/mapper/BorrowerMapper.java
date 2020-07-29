package com.utour.youdai.admin.project.bo.mapper;

import com.utour.youdai.admin.project.bo.domain.Borrower;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 借款人-基本信息(主)Mapper接口
 *
 * @author zh
 * @date 2020-07-28
 */
@Mapper
@Repository
public interface BorrowerMapper {
    /**
     * 查询借款人-基本信息(主)
     *
     * @param id 借款人-基本信息(主)ID
     * @return 借款人-基本信息(主)
     */
    public Borrower selectBorrowerById(Long id);

    /**
     * 查询借款人-基本信息(主)列表
     *
     * @param Borrower 借款人-基本信息(主)
     * @return 借款人-基本信息(主)集合
     */
    public List<Borrower> selectBorrowerList(Borrower Borrower);

    /**
     * 新增借款人-基本信息(主)
     *
     * @param Borrower 借款人-基本信息(主)
     * @return 结果
     */
    public int insertBorrower(Borrower Borrower);

    /**
     * 修改借款人-基本信息(主)
     *
     * @param Borrower 借款人-基本信息(主)
     * @return 结果
     */
    public int updateBorrower(Borrower Borrower);

    /**
     * 删除借款人-基本信息(主)
     *
     * @param id 借款人-基本信息(主)ID
     * @return 结果
     */
    public int deleteBorrowerById(Long id);

    /**
     * 批量删除借款人-基本信息(主)
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBorrowerByIds(Long[] ids);
}
