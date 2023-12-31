package com.monkey.flow.core.enums;

/**
 * @description:  流程状态
 * @author minliuhua
 * @date: 2023/3/31 12:16
 */
public enum FlowStatus {
	TOBESUBMIT(0,"待提交"),
	APPROVAL(1,"审批中"),
	FINISHED(2,"已完成"),
	REJECT(9,"已驳回");

	private Integer key;
	private String value;

	private FlowStatus(Integer key, String value)
	{
		this.key = key;
		this.value = value;
	}

	public Integer getKey()
	{
		return key;
	}

	public String getValue()
	{
		return value;
	}

	public static Integer getKeyByValue(String value)
	{
		for (FlowStatus item : FlowStatus.values())
		{
			if (item.getValue().equals(value))
			{
				return item.getKey();
			}
		}
		return null;
	}

	public static String getValueByKey(Integer key)
	{
		for (FlowStatus item : FlowStatus.values())
		{
			if (item.getKey().equals(key))
			{
				return item.getValue();
			}
		}
		return null;
	}
}
