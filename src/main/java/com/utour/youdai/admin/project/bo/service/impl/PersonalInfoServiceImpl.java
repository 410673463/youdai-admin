package com.utour.youdai.admin.project.bo.service.impl;

import com.utour.youdai.admin.project.bo.domain.PersonalInfo;
import com.utour.youdai.admin.project.bo.mapper.PersonalInfoMapper;
import com.utour.youdai.admin.project.bo.service.IPersonalInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 借款人-个人信息Service业务层处理
 *
 * @author zh
 * @date 2020-07-31
 */
@Service
public class PersonalInfoServiceImpl implements IPersonalInfoService {
    private final PersonalInfoMapper personalInfoMapper;

    public PersonalInfoServiceImpl(PersonalInfoMapper personalInfoMapper) {
        this.personalInfoMapper = personalInfoMapper;
    }

    /**
     * 查询借款人-个人信息
     *
     * @param id 借款人-个人信息ID
     * @return 借款人-个人信息
     */
    @Override
    public PersonalInfo selectPersonalInfoById(Long id) {
        return personalInfoMapper.selectPersonalInfoById(id);
    }

    /**
     * 查询借款人-个人信息列表
     *
     * @param personalInfo 借款人-个人信息
     * @return 借款人-个人信息
     */
    @Override
    public List<PersonalInfo> selectPersonalInfoList(PersonalInfo personalInfo) {
        return personalInfoMapper.selectPersonalInfoList(personalInfo);
    }

    /**
     * 新增借款人-个人信息
     *
     * @param personalInfo 借款人-个人信息
     * @return 结果
     */
    @Override
    public int insertPersonalInfo(PersonalInfo personalInfo) {
        return personalInfoMapper.insertPersonalInfo(personalInfo);
    }

    /**
     * 修改借款人-个人信息
     *
     * @param personalInfo 借款人-个人信息
     * @return 结果
     */
    @Override
    public int updatePersonalInfo(PersonalInfo personalInfo) {
        return personalInfoMapper.updatePersonalInfo(personalInfo);
    }

    /**
     * 批量删除借款人-个人信息
     *
     * @param ids 需要删除的借款人-个人信息ID
     * @return 结果
     */
    @Override
    public int deletePersonalInfoByIds(Long[] ids) {
        return personalInfoMapper.deletePersonalInfoByIds(ids);
    }

    /**
     * 删除借款人-个人信息信息
     *
     * @param id 借款人-个人信息ID
     * @return 结果
     */
    @Override
    public int deletePersonalInfoById(Long id) {
        return personalInfoMapper.deletePersonalInfoById(id);
    }

    @Override
    public PersonalInfo getInfoByBoId(Long boId) {
        PersonalInfo info = personalInfoMapper.getInfoByBoId(boId);
        if(info != null){
            return info;
        }else{
            return new PersonalInfo();
        }

    }
}
