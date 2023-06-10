package com.monkey.flow.core.service;

import com.monkey.flow.core.domain.entity.FlowInstance;
import com.monkey.mybatis.core.service.IFlowBaseService;

import java.util.List;

/**
 * 流程实例Service接口
 *
 * @author hh
 * @date 2023-03-29
 */
public interface IFlowInstanceService extends IFlowBaseService<FlowInstance> {

    /**
     * 根据id集合进行查询 行锁
     *
     * @param definitionIds
     * @return
     */
    List<FlowInstance> queryByidWithUpdateLock(List<Long> definitionIds);

}