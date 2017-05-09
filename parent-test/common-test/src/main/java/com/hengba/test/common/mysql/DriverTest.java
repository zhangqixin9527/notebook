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
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select t.uid as a,t.name as b,t.phone as c from testuser t");
            while(rs.next()){
//                System.out.println("uid: "+rs.getInt("uid"));
//                System.out.println("name: "+rs.getString("name"));
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
}
