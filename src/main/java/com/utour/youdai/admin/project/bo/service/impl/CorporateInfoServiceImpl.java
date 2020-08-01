package com.utour.youdai.admin.project.bo.service.impl;

import com.utour.youdai.admin.project.bo.domain.CorporateInfo;
import com.utour.youdai.admin.project.bo.mapper.CorporateInfoMapper;
import com.utour.youdai.admin.project.bo.service.ICorporateInfoService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 借款人-公司详细信息Service业务层处理
 *
 * @author zh
 * @date 2020-08-01
 */
@Service
public class CorporateInfoServiceImpl implements ICorporateInfoService {
    private final CorporateInfoMapper corporateInfoMapper;

    public CorporateInfoServiceImpl(CorporateInfoMapper corporateInfoMapper) {
        this.corporateInfoMapper = corporateInfoMapper;
    }

    /**
     * 查询借款人-公司详细信息
     *
     * @param id 借款人-公司详细信息ID
     * @return 借款人-公司详细信息
     */
    @Override
    public CorporateInfo selectCorporateInfoById(Long id) {
        return corporateInfoMapper.selectCorporateInfoById(id);
    }

    /**
     * 查询借款人-公司详细信息列表
     *
     * @param corporateInfo 借款人-公司详细信息
     * @return 借款人-公司详细信息
     */
    @Override
    public List<CorporateInfo> selectCorporateInfoList(CorporateInfo corporateInfo) {
        return corporateInfoMapper.selectCorporateInfoList(corporateInfo);
    }

    /**
     * 新增借款人-公司详细信息
     *
     * @param corporateInfo 借款人-公司详细信息
     * @return 结果
     */
    @Override
    public int insertCorporateInfo(CorporateInfo corporateInfo) {
        return corporateInfoMapper.insertCorporateInfo(corporateInfo);
    }

    /**
     * 修改借款人-公司详细信息
     *
     * @param corporateInfo 借款人-公司详细信息
     * @return 结果
     */
    @Override
    public int updateCorporateInfo(CorporateInfo corporateInfo) {
        return corporateInfoMapper.updateCorporateInfo(corporateInfo);
    }

    /**
     * 批量删除借款人-公司详细信息
     *
     * @param ids 需要删除的借款人-公司详细信息ID
     * @return 结果
     */
    @Override
    public int deleteCorporateInfoByIds(Long[] ids) {
        return corporateInfoMapper.deleteCorporateInfoByIds(ids);
    }

    /**
     * 删除借款人-公司详细信息信息
     *
     * @param id 借款人-公司详细信息ID
     * @return 结果
     */
    @Override
    public int deleteCorporateInfoById(Long id) {
        return corporateInfoMapper.deleteCorporateInfoById(id);
    }

    @Override
    public CorporateInfo getInfoByBoId(Long boId) {
        CorporateInfo info = corporateInfoMapper.getInfoByBoId(boId);
        if (info != null) {
            return info;
        } else {
            return new CorporateInfo();
        }
    }
}
