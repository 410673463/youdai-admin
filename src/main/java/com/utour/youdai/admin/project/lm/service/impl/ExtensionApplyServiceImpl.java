package com.utour.youdai.admin.project.lm.service.impl;

import com.utour.youdai.admin.project.lm.mapper.ExtensionApplyMapper;
import com.utour.youdai.admin.project.lm.service.IExtensionApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtensionApplyServiceImpl implements IExtensionApplyService {
    @Autowired
    private ExtensionApplyMapper extensionApplyMapper;
    @Override
    public String getApplyCodeByExtensionId(Long id) {
        return extensionApplyMapper.getApplyCodeByExtensionId(id);
    }

    @Override
    public int extensionCountsByExtensionId(Long extensionId) {
        return extensionApplyMapper.extensionCountsByExtensionId(extensionId);
    }
}
