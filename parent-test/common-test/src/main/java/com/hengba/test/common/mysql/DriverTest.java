/*
 * 文件名称: DriverTest.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/4/1
 * 修改内容: 
 */
package com.hengba.test.common.mysql;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @author Kevin created on 2017/4/1.
 * @since framework 1.0
 */
public class DriverTest {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest001","root","root");
//            DatabaseMetaData databaseMetaData = connection.getMetaData();
//            ResultSet resultSet = databaseMetaData.getTables(null, null, null, null);
//            while (resultSet.next()){
//                System.out.println("=="+resultSet.getString(1));
//                System.out.println("=="+resultSet.getString(2));
//            }
//            ResultSet resultSet1 = databaseMetaData.getColumns(null, null, null, null);
//            while (resultSet1.next()){
//                System.out.println("=="+resultSet1.getString(1));
//                System.out.println("=="+resultSet1.getString(2));
//            }
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select t.uid as a,t.name as b,t.phone as c from testuser t");
            com.mysql.jdbc.ResultSetMetaData resultSetMetaData = (com.mysql.jdbc.ResultSetMetaData)rs.getMetaData();
            System.out.printf(""+resultSetMetaData);
            while(rs.next()){
//                System.out.println("uid: "+rs.getInt("uid"));
//                System.out.println("name: "+rs.getString("name"));x1
//                System.out.println("phone: "+rs.getString("phone")+"\r\n");
                System.out.println("uid: "+rs.getInt("A"));
                System.out.println("name: "+rs.getString("B"));
                System.out.println("phone: "+rs.getString("C")+"\r\n");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void mycatTest() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.136.78:33061/sportdata_transfermarkt", "root", "admin");
        ResultSet resultSet = connection.createStatement().executeQuery("select name, birth_date from p_coach_base_info limit 1");
        if (resultSet.next()){
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
        }
    }
}
