package com.utour.youdai.admin.project.lm.service;

import com.utour.youdai.admin.project.lm.domain.ExtensionApply;

import java.util.List;

public interface IExtensionApplyService {
    String getApplyCodeByExtensionId(Long id);

    /**
     * 查询展期次数
     * @return
     */
    int extensionCountsByExtensionId(Long extensionId);

    /**
     * 查询申请下所有展期记录
     * @param laId
     * @return
     */
    List<ExtensionApply> selectExtensionsByLaId(Long laId);
}
