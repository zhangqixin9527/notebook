/*
 * 文件名称: HiveJdbc.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/4/5
 * 修改内容: 
 */
package com.hengba.hive;

import java.sql.*;

/**
 * @author Kevin created on 2017/4/5.
 * @since framework 1.0
 */
public class HiveJdbc {
    public static void main(String[] args) {
        String driver = "org.apache.hive.jdbc.HiveDriver";
        String url = "jdbc:hive2://192.168.137.87:10000/default";
        String username = "root";
        String password = "123456";
        String sql = "select * from person15";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("--"+resultSet.getString(1));
                System.out.println("--"+resultSet.getInt(2));
                System.out.println("--"+resultSet.getString(3));
                System.out.println("--"+resultSet.getInt(4));
            }
            System.out.println("===>");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
