package com.sooying.pay.app.api.dao.platform.rule;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sooying.pay.app.api.model.platform.rule.RuleInfo;

/**
 * 通道过滤规则
 * 
 * @Description RuleInfoDao
 * @author liurh
 * @date 2018年6月5日
 */
public interface RuleInfoDao {

    /**
     * 获取通道过滤规则数量
     *
     * @param paramsMap
     * @return
     */
    int selectRuleInfoCount(Map<String, Object> paramsMap);

    /**
     * 获取通道过滤规则列表
     *
     * @param paramsMap
     * @return
     */
    List<RuleInfo> selectRuleInfoList(Map<String, Object> paramsMap);

    /**
     * 修改通道过滤规则
     *
     * @param ruleInfo
     */
    void updateRuleInfo(RuleInfo ruleInfo);

    /**
     * 删除通道过滤规则
     *
     * @param id
     */
    void deleteRuleInfo(@Param("id") Long id);

    /**
     * 修改通道过滤规则激活状态
     *
     * @param ruleInfo
     */
    void updateRuleInfoStatus(RuleInfo ruleInfo);

    /**
     * 新增通道过滤规则
     *
     * @param ruleInfo
     */
    void insertRuleInfo(RuleInfo ruleInfo);

    /**
     * 查询通道类型
     *
     * @param pluginId
     * @return
     */
    Integer selectPluginType(@Param("pluginId") int pluginId);

    /**
     * 查询多资费数量
     *
     * @param groupId
     * @return
     */
    int selectFeeGroupCount(@Param("groupId") String groupId);

    /**
     * 查询过滤规则存在数量
     *
     * @param ruleInfo
     * @return
     */
    int selectRuleValueExistCount(RuleInfo ruleInfo);

    /**
     * 获取通道即时生效过滤规则
     *
     * @param passagewayId
     * @return
     */
    RuleInfo selectImmediatelyRuleInfoByPassagewayId(@Param("passagewayId") String passagewayId);
    
    /**
     * 根据ID获取通道过滤规则
     *
     * @param id
     * @return
     */
    RuleInfo selectRuleInfoById(@Param("id") Long id);
}
