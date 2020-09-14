package com.utour.youdai.admin.project.lm.service;

public interface IExtensionApplyService {
    String getApplyCodeByExtensionId(Long id);

    /**
     * 查询展期次数
     * @return
     */
    int extensionCountsByExtensionId(Long extensionId);
}
