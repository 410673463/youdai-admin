package com.utour.youdai.admin.project.bo.service;

import com.utour.youdai.admin.project.bo.domain.CorporateInfo;

import java.util.List;

/**
 * 借款人-公司详细信息Service接口
 *
 * @author zh
 * @date 2020-08-01
 */
public interface ICorporateInfoService {
    /**
     * 查询借款人-公司详细信息
     *
     * @param id 借款人-公司详细信息ID
     * @return 借款人-公司详细信息
     */
    public CorporateInfo selectCorporateInfoById(Long id);

    /**
     * 查询借款人-公司详细信息列表
     *
     * @param corporateInfo 借款人-公司详细信息
     * @return 借款人-公司详细信息集合
     */
    public List<CorporateInfo> selectCorporateInfoList(CorporateInfo corporateInfo);

    /**
     * 新增借款人-公司详细信息
     *
     * @param corporateInfo 借款人-公司详细信息
     * @return 结果
     */
    public int insertCorporateInfo(CorporateInfo corporateInfo);

    /**
     * 修改借款人-公司详细信息
     *
     * @param corporateInfo 借款人-公司详细信息
     * @return 结果
     */
    public int updateCorporateInfo(CorporateInfo corporateInfo);

    /**
     * 批量删除借款人-公司详细信息
     *
     * @param ids 需要删除的借款人-公司详细信息ID
     * @return 结果
     */
    public int deleteCorporateInfoByIds(Long[] ids);

    /**
     * 删除借款人-公司详细信息信息
     *
     * @param id 借款人-公司详细信息ID
     * @return 结果
     */
    public int deleteCorporateInfoById(Long id);

    CorporateInfo getInfoByBoId(Long boId);
}
