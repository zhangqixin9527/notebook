/*
 * 文件名称: CityController.java
 * 版权信息: Copyright 2015-2018  . All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017-12-6
 * 修改内容: 
 */
package com.abc.controller;

import com.abc.entity.City;
import com.abc.service.CityService;
import com.abc.dao.CityDao;
import java.util.List;
import com.manfen.bizfdn.frm.web.MfhController;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 城市表控制器入口
 * http://localhost:9080/../city?needXml=true
 * @author Kevin created on 2017-12-6
 * @since 
 */
@Controller
@RequestMapping(value = "/city")
public final class CityController extends MfhController<String, City, CityDao, CityService>{
    
	@Autowired
    private CityService service;
    
    @Override
    protected CityService getService() {
        return service;
    }    

    @Override
    protected Class<City> getEntityClass() {
        return City.class;
    }

    @Override
    protected Type getEntityType() {
        return new TypeToken<City>(){}.getType();
    }

    @Override
    protected Type getEntityListType() {
        return new TypeToken<List<City>>(){}.getType();
    }
}
