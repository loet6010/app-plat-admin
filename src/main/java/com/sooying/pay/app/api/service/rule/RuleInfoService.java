package com.sooying.pay.app.api.service.rule;

import com.sooying.pay.app.api.controller.rule.dto.RuleInfoDto;

/**
 * 通道过滤规则
 * 
 * @Description RuleInfoService
 * @author liurh
 * @date 2018年6月11日
 */
public interface RuleInfoService {

    /**
     * 获取通道过滤规则列表
     *
     * @param ruleInfoDto
     * @return
     */
    String getRuleInfoList(RuleInfoDto ruleInfoDto);

    /**
     * 修改通道过滤规则
     *
     * @param ruleInfoDto
     * @return
     */
    String modifyRuleInfo(RuleInfoDto ruleInfoDto);

    /**
     * 删除通道过滤规则
     *
     * @param ruleInfoDto
     * @return
     */
    String removeRuleInfo(RuleInfoDto ruleInfoDto);

    /**
     * 修改通道过滤规则激活状态
     *
     * @param ruleInfoDto
     * @return
     */
    String modifyRuleInfoStatus(RuleInfoDto ruleInfoDto);

    /**
     * 新增通道过滤规则
     *
     * @param ruleInfoDto
     * @return
     */
    String addRuleInfo(RuleInfoDto ruleInfoDto);
}
