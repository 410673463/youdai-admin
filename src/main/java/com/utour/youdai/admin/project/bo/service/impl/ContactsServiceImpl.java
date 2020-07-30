package com.utour.youdai.admin.project.bo.service.impl;

import java.util.Date;
import java.util.List;

import com.utour.youdai.admin.project.bo.domain.Contacts;
import com.utour.youdai.admin.project.bo.mapper.ContactsMapper;
import com.utour.youdai.admin.project.bo.service.IContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 借款人-联系人信息Service业务层处理
 *
 * @author zh
 * @date 2020-07-29
 */
@Service
public class ContactsServiceImpl implements IContactsService {
    private final ContactsMapper contactsMapper;

    public ContactsServiceImpl(ContactsMapper contactsMapper) {
        this.contactsMapper = contactsMapper;
    }

    /**
     * 查询借款人-联系人信息
     *
     * @param id 借款人-联系人信息ID
     * @return 借款人-联系人信息
     */
    @Override
    public Contacts selectContactsById(Long id) {
        return contactsMapper.selectContactsById(id);
    }

    /**
     * 查询借款人-联系人信息列表
     *
     * @param contacts 借款人-联系人信息
     * @return 借款人-联系人信息
     */
    @Override
    public List<Contacts> selectContactsList(Contacts contacts) {
        return contactsMapper.selectContactsList(contacts);
    }

    /**
     * 新增借款人-联系人信息
     *
     * @param contacts 借款人-联系人信息
     * @return 结果
     */
    @Override
    public int insertContacts(Contacts contacts) {

        return contactsMapper.insertContacts(contacts);
    }

    /**
     * 修改借款人-联系人信息
     *
     * @param contacts 借款人-联系人信息
     * @return 结果
     */
    @Override
    public int updateContacts(Contacts contacts) {
        return contactsMapper.updateContacts(contacts);
    }

    /**
     * 批量删除借款人-联系人信息
     *
     * @param ids 需要删除的借款人-联系人信息ID
     * @return 结果
     */
    @Override
    public int deleteContactsByIds(Long[] ids) {
        return contactsMapper.deleteContactsByIds(ids);
    }

    /**
     * 删除借款人-联系人信息信息
     *
     * @param id 借款人-联系人信息ID
     * @return 结果
     */
    @Override
    public int deleteContactsById(Long id) {
        return contactsMapper.deleteContactsById(id);
    }
}
