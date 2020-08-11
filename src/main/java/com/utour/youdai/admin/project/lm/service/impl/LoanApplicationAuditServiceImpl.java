package com.utour.youdai.admin.project.lm.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.utour.youdai.admin.common.utils.SecurityUtils;
import com.utour.youdai.admin.project.lm.domain.LoanApplicationAudit;
import com.utour.youdai.admin.project.lm.mapper.LoanApplicationAuditMapper;
import com.utour.youdai.admin.project.lm.service.ILoanApplicationAuditService;
import com.utour.youdai.admin.project.lm.service.ILoanApplicationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)Service业务层处理
 *
 * @author zh
 * @date 2020-08-08
 */
@Service
public class LoanApplicationAuditServiceImpl implements ILoanApplicationAuditService {
    private final LoanApplicationAuditMapper loanApplicationAuditMapper;
    private final ILoanApplicationService loanApplicationService;
    public LoanApplicationAuditServiceImpl(LoanApplicationAuditMapper loanApplicationAuditMapper, ILoanApplicationService loanApplicationService) {
        this.loanApplicationAuditMapper = loanApplicationAuditMapper;
        this.loanApplicationService = loanApplicationService;
    }

    /**
     * 查询贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     *
     * @param id 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)ID
     * @return 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     */
    @Override
    public LoanApplicationAudit selectLoanApplicationAuditById(Long id) {
        return loanApplicationAuditMapper.selectLoanApplicationAuditById(id);
    }

    /**
     * 查询贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)列表
     *
     * @param loanApplicationAudit 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     * @return 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     */
    @Override
    public List<LoanApplicationAudit> selectLoanApplicationAuditList(LoanApplicationAudit loanApplicationAudit) {
        return loanApplicationAuditMapper.selectLoanApplicationAuditList(loanApplicationAudit);
    }

    /**
     * 新增贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     *
     * @param jsonObject 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     * @return 结果
     */
    @Override
    public int insertLoanApplicationAudit(JSONObject jsonObject) {
        JSONArray laIds = jsonObject.getJSONArray("laIds");//申请主表IDs

        UserData user1 = JSON.parseObject(JSON.toJSONString(jsonObject.get("user1")), UserData.class);
        UserData user2 = JSON.parseObject(JSON.toJSONString(jsonObject.get("user2")), UserData.class);

        UserData user3 = JSON.parseObject(JSON.toJSONString(jsonObject.get("user3")), UserData.class);

        UserData user5 = JSON.parseObject(JSON.toJSONString(jsonObject.get("user5")), UserData.class);

        UserData user6 = JSON.parseObject(JSON.toJSONString(jsonObject.get("user6")), UserData.class);
        JSONArray user4Arr = jsonObject.getJSONArray("user4");
        List<UserData> udList = new ArrayList<UserData>();
        for (Object jo : user4Arr) {
            UserData u = JSON.parseObject(JSON.toJSONString(jo), UserData.class);
            udList.add(u);
        }
        String creatUserName = SecurityUtils.getUsername();
        List<LoanApplicationAudit> auditList = new ArrayList<LoanApplicationAudit>();
        for (int i = 0; i < laIds.size(); i++) {
            Long laId = laIds.getLongValue(i);
            LoanApplicationAudit audit1 = new LoanApplicationAudit();
            audit1.setAuditStatus(1);
            audit1.setAuditTime(new Date());
            audit1.setAuditUserId(user1.getId());
            audit1.setAuditUserName(user1.getName());
            audit1.setLaId(laId);
            audit1.setCreateTime(new Date());
            audit1.setCreateBy(creatUserName);
            audit1.setAuditOpinion("自动通过");
            audit1.setAuditTime(new Date());
            audit1.setAuditSort(1);
            auditList.add(audit1);
            LoanApplicationAudit audit2 = fillAuditUserData(user1, user2, creatUserName, laId, 2);
            auditList.add(audit2);
            LoanApplicationAudit audit3 = fillAuditUserData(user2, user3, creatUserName, laId, 3);
            auditList.add(audit3);
            for (UserData ud : udList) {
                LoanApplicationAudit a = fillAuditUserData(user3, ud, creatUserName, laId, 4);
                auditList.add(a);
            }
            LoanApplicationAudit audit5 = fillAuditUserData(new UserData(0, "上会审核"), user5, creatUserName, laId, 5);
            auditList.add(audit5);
            LoanApplicationAudit audit6 = fillAuditUserData(user5, user6, creatUserName, laId, 6);
            auditList.add(audit6);
        }
        int n = 0;
        if (auditList.size() > 0) {
            n = loanApplicationAuditMapper.batchInsert(auditList);
        }
        if (n > 0) {//更新申请主表 状态 -->  生成审核流程
            loanApplicationService.updateApplyStatus(1,laIds);
        }
        return n;

    }

    private LoanApplicationAudit fillAuditUserData(UserData user1, UserData user2, String creatUserName, Long laId, int sort) {
        LoanApplicationAudit audit = new LoanApplicationAudit();
        audit.setCreateBy(creatUserName);
        audit.setCreateTime(new Date());
        audit.setLaId(laId);
        audit.setSuperUserId(user1.getId());
        audit.setSuperUserName(user1.getName());
        audit.setAuditUserName(user2.getName());
        audit.setAuditUserId(user2.getId());
        audit.setAuditStatus(0);
        audit.setAuditSort(sort);
        return audit;
    }

    /**
     * 修改贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     *
     * @param loanApplicationAudit 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     * @return 结果
     */
    @Override
    public int updateLoanApplicationAudit(LoanApplicationAudit loanApplicationAudit) {
        return loanApplicationAuditMapper.updateLoanApplicationAudit(loanApplicationAudit);
    }

    /**
     * 批量删除贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     *
     * @param ids 需要删除的贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)ID
     * @return 结果
     */
    @Override
    public int deleteLoanApplicationAuditByIds(Long[] ids) {
        return loanApplicationAuditMapper.deleteLoanApplicationAuditByIds(ids);
    }

    /**
     * 删除贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)信息
     *
     * @param id 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)ID
     * @return 结果
     */
    @Override
    public int deleteLoanApplicationAuditById(Long id) {
        return loanApplicationAuditMapper.deleteLoanApplicationAuditById(id);
    }

    @Override
    public List<LoanApplicationAudit> selectAuditByLaId(Long id) {
        return loanApplicationAuditMapper.selectAuditByLaId(id);
    }

    public static class UserData {
        private long id;
        private String name;

        public UserData(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
