package com.utour.youdai.admin.project.dp.service;

import com.utour.youdai.admin.project.dp.domain.DataPushRecords;

import java.util.List;

/**
 * 数据推送记录Service接口
 *
 * @author zh
 * @date 2020-08-25
 */
public interface IDataPushRecordsService {
    /**
     * 查询数据推送记录
     *
     * @param id 数据推送记录ID
     * @return 数据推送记录
     */
    public DataPushRecords selectDataPushRecordsById(Long id);

    /**
     * 查询数据推送记录列表
     *
     * @param dataPushRecords 数据推送记录
     * @return 数据推送记录集合
     */
    public List<DataPushRecords> selectDataPushRecordsList(DataPushRecords dataPushRecords);

    /**
     * 新增数据推送记录
     *
     * @param dataPushRecords 数据推送记录
     * @return 结果
     */
    public int insertDataPushRecords(DataPushRecords dataPushRecords);

    /**
     * 修改数据推送记录
     *
     * @param dataPushRecords 数据推送记录
     * @return 结果
     */
    public int updateDataPushRecords(DataPushRecords dataPushRecords);

    /**
     * 批量删除数据推送记录
     *
     * @param ids 需要删除的数据推送记录ID
     * @return 结果
     */
    public int deleteDataPushRecordsByIds(Long[] ids);

    /**
     * 删除数据推送记录信息
     *
     * @param id 数据推送记录ID
     * @return 结果
     */
    public int deleteDataPushRecordsById(Long id);


    /**
     * 创建 推送记录
     * @param primaryId  推送表主键ID
     * @param dataTable  推送表名
     * @param path   推送api路径
     * @param reqId   业务主键ID (统一社会信用代码+uuId)
     * @param sign  生成的签名
     * @param token  生成的token
     * @param roundStr  随机字符串
     * @param param  请求入参
     * @return
     */
    public int createPushDataRecord(Long primaryId,String dataTable,String path,String reqId,String sign,String token,String roundStr,String param);

    /**
     * 推送返回结果后，根据结果更新 推送数据 状态
     * @param dataTable
     * @param primaryId
     * @param pushStatus
     */
    int updatePushDataStatus(String dataTable, Long primaryId, int pushStatus);
}
