package com.utour.youdai.admin.project.lm.mapper;

import com.utour.youdai.admin.project.lm.domain.ExtensionApply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 展期申请中间Mapper接口
 *
 * @author zh
 * @date 2020-09-08
 */
@Mapper
@Repository
public interface ExtensionApplyMapper {
    /**
     * 查询展期申请中间
     *
     * @param id 展期申请中间ID
     * @return 展期申请中间
     */
    public ExtensionApply selectExtensionApplyById(Long id);

    /**
     * 查询展期申请中间列表
     *
     * @param extensionApply 展期申请中间
     * @return 展期申请中间集合
     */
    public List<ExtensionApply> selectExtensionApplyList(ExtensionApply extensionApply);

    /**
     * 新增展期申请中间
     *
     * @param extensionApply 展期申请中间
     * @return 结果
     */
    public int insertExtensionApply(ExtensionApply extensionApply);

    /**
     * 修改展期申请中间
     *
     * @param extensionApply 展期申请中间
     * @return 结果
     */
    public int updateExtensionApply(ExtensionApply extensionApply);

    /**
     * 删除展期申请中间
     *
     * @param id 展期申请中间ID
     * @return 结果
     */
    public int deleteExtensionApplyById(Long id);

    /**
     * 批量删除展期申请中间
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteExtensionApplyByIds(Long[] ids);

    /**
     * 通过展期申请Id查询 原申请code
     * @param id
     * @return
     */
    String getApplyCodeByExtensionId(Long id);

    /**
     * 查询展期次数
     * @return
     */
    int extensionCounts(String code);

    int extensionCountsByExtensionId(Long extensionId);

    /**
     * 查询申请下所有展期记录
     * @param laId
     * @return
     */
    List<ExtensionApply> selectExtensionsByLaId(Long laId);
}
