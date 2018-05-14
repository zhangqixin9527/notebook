package com.abc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import com.manfen.test.BaseSpringTestCase;
import com.abc.entity.City;
import com.abc.service.CityService;

public class CityServiceTest extends BaseSpringTestCase {
	@Autowired
    private CityService cityService;
    
    private static String pkObj;
			
	@Test
	@Rollback(false)
	public void testInsertCity() {
		City city = new City();
		cityService.create(city);
		pkObj = city.getId();
	}
	
	@Test
	@Rollback(false)
	public void testUpdateCity() {		
		City city = cityService.get(pkObj);
        cityService.update(city);
	}
	
	@Test
	@Rollback(false)
	public void testDeleteCityById() {
		cityService.delete(pkObj);
		//判断为null
		City city = cityService.get(pkObj);
		Assert.assertNull(city);
	}
}
