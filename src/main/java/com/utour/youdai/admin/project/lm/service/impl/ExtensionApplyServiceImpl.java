package com.utour.youdai.admin.project.lm.service.impl;

import com.utour.youdai.admin.project.lm.domain.ExtensionApply;
import com.utour.youdai.admin.project.lm.mapper.ExtensionApplyMapper;
import com.utour.youdai.admin.project.lm.service.IExtensionApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ExtensionApply> selectExtensionsByLaId(Long laId) {
        return extensionApplyMapper.selectExtensionsByLaId(laId);
    }
}
