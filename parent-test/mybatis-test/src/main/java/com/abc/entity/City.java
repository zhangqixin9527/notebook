/*
 * 文件名称: City.java
 * 版权信息: Copyright 2001-2018  . All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017-12-6
 * 修改内容: 
 */
package com.abc.entity;

import MfhEntity;

/**
 * 城市表对象类
 * @author Kevin created on 2017-12-6
 * @since
 */ 
@SuppressWarnings("serial")
public class City extends MfhEntity<String>   {
	private String playerId; //球员，外键
	private String snapshotKey; //快照键
	private String snapshotContent; //快照数据
	private Date snapBeginTime; //快照的开始时间
	private Date snapEndTime; //快照的结束时间
	private String source; //记录数据来源，字典形式
	private String signature; //记录签名编号，满足特殊需求
	private String enableState; //记录行启用状态，通过此可实现软删除等操作，字典形式
	private String operateState; //记录行维护状态，当通过人工维护时修改，字典形式
	private Date operateTime; //记录行操作时间，当通过人工维护时修改
	private Date updateTime; //记录行更新时间，当行中任意一列修改时修改
	private Date createTime; //记录行创建时间，只在行数据第一次创建时修改
	
	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	
	public String getSnapshotKey() {
		return snapshotKey;
	}

	public void setSnapshotKey(String snapshotKey) {
		this.snapshotKey = snapshotKey;
	}
	
	public String getSnapshotContent() {
		return snapshotContent;
	}

	public void setSnapshotContent(String snapshotContent) {
		this.snapshotContent = snapshotContent;
	}
	
	public Date getSnapBeginTime() {
		return snapBeginTime;
	}

	public void setSnapBeginTime(Date snapBeginTime) {
		this.snapBeginTime = snapBeginTime;
	}
	
	public Date getSnapEndTime() {
		return snapEndTime;
	}

	public void setSnapEndTime(Date snapEndTime) {
		this.snapEndTime = snapEndTime;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public String getEnableState() {
		return enableState;
	}

	public void setEnableState(String enableState) {
		this.enableState = enableState;
	}
	
	public String getOperateState() {
		return operateState;
	}

	public void setOperateState(String operateState) {
		this.operateState = operateState;
	}
	
	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
