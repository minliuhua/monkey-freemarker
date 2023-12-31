package com.monkey.flow.core.service.impl;

import com.monkey.flow.core.constant.FlowConstant;
import com.monkey.flow.core.domain.entity.FlowTask;
import com.monkey.flow.core.mapper.FlowTaskMapper;
import com.monkey.flow.core.service.IFlowTaskService;
import com.monkey.flow.core.utils.AssertUtil;
import com.monkey.mybatis.core.page.Page;
import com.monkey.mybatis.core.service.impl.FlowServiceImpl;
import com.monkey.mybatis.core.utils.SqlHelper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 待办任务Service业务层处理
 *
 * @author hh
 * @date 2023-03-29
 */
public class FlowTaskServiceImpl extends FlowServiceImpl<FlowTask> implements IFlowTaskService {
    @Resource
    private FlowTaskMapper taskMapper;

    @Override
    public FlowTaskMapper getBaseMapper() {
        return taskMapper;
    }

    @Override
    public List<FlowTask> getByInsIds(List<Long> instanceIds) {
        AssertUtil.isFalse(instanceIds == null || instanceIds.size() == 0, FlowConstant.NOT_FOUNT_INSTANCE_ID);
        for (int i = 0; i < instanceIds.size(); i++) {
            AssertUtil.isNull(instanceIds.get(i), "流程定义id不能为空!");
        }
        return taskMapper.getByInsIds(instanceIds);
    }

    @Override
    public Page<FlowTask> toDoPage(FlowTask flowTask, Page<FlowTask> page) {
        long count = taskMapper.countTodo(flowTask, page);
        if (count > 0) {
            List<FlowTask> list = taskMapper.toDoPage(flowTask, page);
            return new Page<>(list, count);
        }
        return Page.empty();
    }

    @Override
    public boolean deleteByInsIds(List<Long> instanceIds) {
        return SqlHelper.retBool(taskMapper.deleteByInsIds(instanceIds));
    }
}
