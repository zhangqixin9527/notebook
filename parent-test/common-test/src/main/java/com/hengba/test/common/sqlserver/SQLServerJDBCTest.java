/*
 * 文件名称: SQLServerJDBCTest.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/5/3
 * 修改内容: 
 */
package com.hengba.test.common.sqlserver;


import java.sql.*;

/**
 * @author Kevin created on 2017/5/3.
 * @since framework 1.0
 */
public class SQLServerJDBCTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try(Connection connection = DriverManager.getConnection("", "", "");
            Statement statement = connection.createStatement();){
            ResultSet rs = statement.executeQuery("select top 5 m.ss_match_id as mid from DataCenter_Trade.dbo.jz_MATCH AS m");
            while(rs.next()) {
                System.out.println("match id: " + rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
