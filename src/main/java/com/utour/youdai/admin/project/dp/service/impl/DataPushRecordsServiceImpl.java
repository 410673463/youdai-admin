package com.utour.youdai.admin.project.dp.service.impl;

import com.utour.youdai.admin.project.dp.domain.DataPushRecords;
import com.utour.youdai.admin.project.dp.mapper.DataPushRecordsMapper;
import com.utour.youdai.admin.project.dp.service.IDataPushRecordsService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 数据推送记录Service业务层处理
 *
 * @author zh
 * @date 2020-08-25
 */
@Service
public class DataPushRecordsServiceImpl implements IDataPushRecordsService {
    private final DataPushRecordsMapper dataPushRecordsMapper;

    public DataPushRecordsServiceImpl(DataPushRecordsMapper dataPushRecordsMapper) {
        this.dataPushRecordsMapper = dataPushRecordsMapper;
    }

    /**
     * 查询数据推送记录
     *
     * @param id 数据推送记录ID
     * @return 数据推送记录
     */
    @Override
    public DataPushRecords selectDataPushRecordsById(Long id) {
        return dataPushRecordsMapper.selectDataPushRecordsById(id);
    }

    /**
     * 查询数据推送记录列表
     *
     * @param dataPushRecords 数据推送记录
     * @return 数据推送记录
     */
    @Override
    public List<DataPushRecords> selectDataPushRecordsList(DataPushRecords dataPushRecords) {
        return dataPushRecordsMapper.selectDataPushRecordsList(dataPushRecords);
    }

    /**
     * 新增数据推送记录
     *
     * @param dataPushRecords 数据推送记录
     * @return 结果
     */
    @Override
    public int insertDataPushRecords(DataPushRecords dataPushRecords) {
        return dataPushRecordsMapper.insertDataPushRecords(dataPushRecords);
    }

    /**
     * 修改数据推送记录
     *
     * @param dataPushRecords 数据推送记录
     * @return 结果
     */
    @Override
    public int updateDataPushRecords(DataPushRecords dataPushRecords) {
        return dataPushRecordsMapper.updateDataPushRecords(dataPushRecords);
    }

    /**
     * 批量删除数据推送记录
     *
     * @param ids 需要删除的数据推送记录ID
     * @return 结果
     */
    @Override
    public int deleteDataPushRecordsByIds(Long[] ids) {
        return dataPushRecordsMapper.deleteDataPushRecordsByIds(ids);
    }

    /**
     * 删除数据推送记录信息
     *
     * @param id 数据推送记录ID
     * @return 结果
     */
    @Override
    public int deleteDataPushRecordsById(Long id) {
        return dataPushRecordsMapper.deleteDataPushRecordsById(id);
    }

    @Override
    public int createPushDataRecord(Long primaryId, String dataTable, String path, String reqId, String sign, String token, String roundStr, String param) {
        return 0;
    }

    @Override
    public int updatePushDataStatus(String dataTable, Long primaryId, int pushStatus) {
        return dataPushRecordsMapper.updatePushDataStatus(dataTable, primaryId, pushStatus);
    }
}
