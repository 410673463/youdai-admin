package com.utour.youdai.admin.project.dp.mapper;

import com.utour.youdai.admin.project.dp.domain.DataPushRecords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据推送记录Mapper接口
 *
 * @author zh
 * @date 2020-08-25
 */
@Repository
@Mapper
public interface DataPushRecordsMapper {
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
     * 删除数据推送记录
     *
     * @param id 数据推送记录ID
     * @return 结果
     */
    public int deleteDataPushRecordsById(Long id);

    /**
     * 批量删除数据推送记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDataPushRecordsByIds(Long[] ids);

    /**
     * 推送返回结果后，根据结果更新 推送数据 状态
     *
     * @param dataTable
     * @param primaryId
     * @param pushStatus
     * @return
     */
    int updatePushDataStatus(@Param("dataTable") String dataTable, @Param("primaryId") Long primaryId, @Param("pushStatus") int pushStatus);
}
