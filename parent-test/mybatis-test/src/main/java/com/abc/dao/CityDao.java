/*
 * 文件名称: CityDao.java
 * 版权信息: Copyright 2001-2018  . All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017-12-6
 * 修改内容: 
 */
package com.abc.dao;
import IParentDAO;
import MyBatisRepository;
import com.abc.entity.City;

/**
 * 城市表Dao接口类
 * 
 * @author Kevin created on 2017-12-6
 * @since 
 */
 @MyBatisRepository
public interface CityDao extends IParentDAO<City, String> {
	
}
