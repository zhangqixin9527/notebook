/*
 * 文件名称: AbsFactory.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/8/15
 * 修改内容: 
 */
package com.hengba.schema.factory.abs;

/**
 * @author Kevin created on 2017/8/15.
 * @since framework 1.0
 */
public class AbsFactory {
    public static void main(String[] args) {
        CityFactory shanghai = new ShanghaiFactory();
        CityFactory beijing = new BeijingFactory();
        System.out.println(shanghai.getCBD().name());
        System.out.println(shanghai.getSign().sign());
        System.out.println(beijing.getCBD().name());
        System.out.println(beijing.getSign().sign());
    }
}
