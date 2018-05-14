/*
 * 文件名称: CityServiceImpl.java
 * 版权信息: Copyright 2001-2018  . All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017-12-6
 * 修改内容: 
 */
package com.abc.service;

import com.abc.dao.CityDao;
import com.abc.entity.City;
import com.abc.service.CityService;
import ViewProperty;
import WriteFieldBase;
import ViewIndex;
import com.mfh.comn.logic.SeqInit.SeqArea;
import java.util.List;
import java.util.Map;
import IServiceFilter;
import IdServiceFilter;
import org.springframework.stereotype.Component;
import AbstractService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 城市表服务实现类
 * @author Kevin created on 2017-12-6
 * @since 
 */
@Component
public class CityService extends AbstractService<City, String, CityDao>  {
	@Autowired
	private CityDao dao;
    public final static String VIEW_CITY = "city";
	
	/**
     * 构造函数
     */
	public CityService() {
        super();
        this.pojoClass = City.class;
        this.tableName = "player_snapshot";
        this.description = "城市表";
        ViewIndex.putService(VIEW_CITY, this);        
    }  
    
    @Override
    public CityDao getDao() {
        return dao;
    }
    
    @Override
    protected void initServiceFilters(List<IServiceFilter> filters) {    
        filters.add(new IdServiceFilter<City, String>(tableName, SeqArea.thousand));
    }
    
	// -------------------------------- 以下为表单配置 -------------------------------- //
		
    /*@Override
    protected void initQueryProps(Map<String, ViewProperty<?>> queryPropMap, String viewId) {
        super.initQueryProps(queryPropMap, viewId); 
        ViewProperty prop;
        prop = new ViewProperty(new QueryQfiled(com.shk.glp.resource.common.Constants.VIEW_CHAPTER + ".bookId", "教材编号", "string"), null); 
        queryPropMap.put(prop.getField().getName(), prop);
        prop.getQueryField().setHidden("true");
    }*/
        
    @Override
    protected String[] collectQueryProps() {
        return new String[] {"id"};
    }
    
    /*@Override
    public List<String> collectSearchPropNames(String viewId) {
        List<String> propNames = new ArrayList<String>();     
        return propNames;
    }*/
    
    @Override
    protected void initPropMapInner(List<ViewProperty<?>> props) {
    	//DomainDirectRef.getRef().addOption("name","code"); DomainCodeRef.getRef(Constants.CODE_TYPE, Constants.LEVEL_CODE);
        ViewProperty<?> prop = null;        
        
		prop = new ViewProperty<Object>(new WriteFieldBase("id", "编号", "String"), null);    
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new WriteFieldBase("playerId", "球员，外键", "String", false), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new WriteFieldBase("snapshotKey", "快照键", "String", false), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new WriteFieldBase("snapshotContent", "快照数据", "String", false), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new WriteFieldBase("snapBeginTime", "快照的开始时间", "Date", false), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new WriteFieldBase("snapEndTime", "快照的结束时间", "Date", false), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new WriteFieldBase("source", "记录数据来源，字典形式", "String", false), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new WriteFieldBase("signature", "记录签名编号，满足特殊需求", "String", false), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new WriteFieldBase("enableState", "记录行启用状态，通过此可实现软删除等操作，字典形式", "String", false), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new WriteFieldBase("operateState", "记录行维护状态，当通过人工维护时修改，字典形式", "String", false), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new WriteFieldBase("operateTime", "记录行操作时间，当通过人工维护时修改", "Date", false), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new WriteFieldBase("updateTime", "记录行更新时间，当行中任意一列修改时修改", "Date", false), null);
    	props.add(prop);
        
		prop = new ViewProperty<Object>(new WriteFieldBase("createTime", "记录行创建时间，只在行数据第一次创建时修改", "Date", false), null);
    	props.add(prop);
    }
}
