package com.utour.youdai.admin.project.bo.service;

import com.utour.youdai.admin.project.bo.domain.PersonalInfo;

import java.util.List;

/**
 * 借款人-个人信息Service接口
 *
 * @author zh
 * @date 2020-07-31
 */
public interface IPersonalInfoService {
    /**
     * 查询借款人-个人信息
     *
     * @param id 借款人-个人信息ID
     * @return 借款人-个人信息
     */
    public PersonalInfo selectPersonalInfoById(Long id);

    /**
     * 查询借款人-个人信息列表
     *
     * @param personalInfo 借款人-个人信息
     * @return 借款人-个人信息集合
     */
    public List<PersonalInfo> selectPersonalInfoList(PersonalInfo personalInfo);

    /**
     * 新增借款人-个人信息
     *
     * @param personalInfo 借款人-个人信息
     * @return 结果
     */
    public int insertPersonalInfo(PersonalInfo personalInfo);

    /**
     * 修改借款人-个人信息
     *
     * @param personalInfo 借款人-个人信息
     * @return 结果
     */
    public int updatePersonalInfo(PersonalInfo personalInfo);

    /**
     * 批量删除借款人-个人信息
     *
     * @param ids 需要删除的借款人-个人信息ID
     * @return 结果
     */
    public int deletePersonalInfoByIds(Long[] ids);

    /**
     * 删除借款人-个人信息信息
     *
     * @param id 借款人-个人信息ID
     * @return 结果
     */
    public int deletePersonalInfoById(Long id);

    /**
     * 根据客户Id查询相信信息表
     * @param boId
     * @return
     */
    PersonalInfo getInfoByBoId(Long boId);
}
