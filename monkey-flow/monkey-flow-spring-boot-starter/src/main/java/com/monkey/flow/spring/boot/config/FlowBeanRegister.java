package com.monkey.flow.spring.boot.config;

import com.monkey.flow.core.handler.DataFillHandlerImpl;
import com.monkey.flow.core.service.*;
import com.monkey.flow.core.service.impl.*;
import com.monkey.flow.core.webService.*;
import com.monkey.mybatis.core.handler.DataFillHandlerFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @description:  工作流bean注册配置
 * @author minliuhua
 * @date: 2023/6/5 23:01
 */
@MapperScan({"com.monkey.flow.core.mapper"})
@Configuration
public class FlowBeanRegister
{
  @PostConstruct
  public void setFlexConfig()
  {
    DataFillHandlerFactory.set(new DataFillHandlerImpl());
  }

  @Bean
  public DefAppService defAppService()
  {
    return new DefAppService();
  }

  @Bean
  public NodeAppService nodeAppService()
  {
    return new NodeAppService();
  }

  @Bean
  public SkipAppService skipAppService()
  {
    return new SkipAppService();
  }

  @Bean
  public InsAppService insAppService()
  {
    return new InsAppService();
  }

  @Bean
  public TaskAppService taskAppService()
  {
    return new TaskAppService();
  }

  @Bean
  public HisTaskAppService hisTaskAppService()
  {
    return new HisTaskAppService();
  }

  @Bean
  public IFlowDefinitionService definitionService()
  {
    return new FlowDefinitionServiceImpl();
  }

  @Bean
  public IFlowNodeService nodeService()
  {
    return new FlowNodeServiceImpl();
  }

  @Bean
  public IFlowSkipService skipService()
  {
    return new FlowSkipServiceImpl();
  }

  @Bean
  public IFlowInstanceService instanceService()
  {
    return new FlowInstanceServiceImpl();
  }

  @Bean
  public IFlowTaskService taskService()
  {
    return new FlowTaskServiceImpl();
  }

  @Bean
  public IFlowHisTaskService hisTaskService()
  {
    return new FlowHisTaskServiceImpl();
  }
}
