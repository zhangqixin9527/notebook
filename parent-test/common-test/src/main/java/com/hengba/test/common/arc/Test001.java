/*
 * 文件名称: Test001.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/4/25
 * 修改内容: 
 */
package com.hengba.test.common.arc;

import java.sql.*;

/**
 * @author Kevin created on 2017/4/25.
 * @since framework 1.0
 */
public class Test001 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection1=null;
//        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest001","root","root");
//        Statement statement = connection.createStatement();) {
//            ResultSet rs = statement.executeQuery("select t.uid as a,t.name as b,t.phone as c from testuser t");
//            while (rs.next()) {
//                System.out.println("uid: " + rs.getInt("A"));
//                System.out.println("name: " + rs.getString("B"));
//                System.out.println("phone: " + rs.getString("C") + "\r\n");
//            }
//            connection1 = connection;
//            if (!connection1.isClosed()) {
//                System.out.println("=====in======connection1 did't close");
//            }
//        }
//        if (!connection1.isClosed()) {
//            System.out.println("=====out======connection1 did't close");
//        }

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest001","root","root");
        System.out.println("No1. connection is close? "+connection.isClosed());
        try(Connection connection1 = connection){
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery("select t.uid as a,t.name as b,t.phone as c from testuser t");
            while (rs.next()) {
                System.out.println("uid: " + rs.getInt("A"));
                System.out.println("name: " + rs.getString("B"));
                System.out.println("phone: " + rs.getString("C") + "\r\n");
            }
        }
        System.out.println("No2. connection is close? "+connection.isClosed());
    }
}
