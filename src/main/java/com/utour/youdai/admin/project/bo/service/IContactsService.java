package com.utour.youdai.admin.project.bo.service;


import com.utour.youdai.admin.project.bo.domain.Contacts;

import java.util.List;

/**
 * 借款人-联系人信息Service接口
 *
 * @author zh
 * @date 2020-07-29
 */
public interface IContactsService {
    /**
     * 查询借款人-联系人信息
     *
     * @param id 借款人-联系人信息ID
     * @return 借款人-联系人信息
     */
    public Contacts selectContactsById(Long id);

    /**
     * 查询借款人-联系人信息列表
     *
     * @param contacts 借款人-联系人信息
     * @return 借款人-联系人信息集合
     */
    public List<Contacts> selectContactsList(Contacts contacts);

    /**
     * 新增借款人-联系人信息
     *
     * @param contacts 借款人-联系人信息
     * @return 结果
     */
    public int insertContacts(Contacts contacts);

    /**
     * 修改借款人-联系人信息
     *
     * @param contacts 借款人-联系人信息
     * @return 结果
     */
    public int updateContacts(Contacts contacts);

    /**
     * 批量删除借款人-联系人信息
     *
     * @param ids 需要删除的借款人-联系人信息ID
     * @return 结果
     */
    public int deleteContactsByIds(Long[] ids);

    /**
     * 删除借款人-联系人信息信息
     *
     * @param id 借款人-联系人信息ID
     * @return 结果
     */
    public int deleteContactsById(Long id);
}
