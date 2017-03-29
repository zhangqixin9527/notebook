/*
 * 文件名称: HiveMapHBaseService.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/3/23
 * 修改内容: 
 */
package com.hengba.test.common;

import commons.configure.Configuration;
import commons.configure.SourceLoader;
import commons.configure.xml.XmlConf;
import commons.sql.jdbc.JdbcUtils;
import commons.utils.AssertUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static commons.utils.ReflectUtils.*;

/**
 * 单次调用Hive映射Hbase表, 操作频繁的话 TODO 设计连接池执行映射操作
 * @author Kevin created on 2017/3/23.
 * @since framework 1.0
 */
public class HiveMapHBaseService {
    // jdbc hive conf key
    public static final String JDBC_HIVE_DRIVER = "jdbc.hive.driver";
    public static final String JDBC_HIVE_URL = "jdbc.hive.url";
    public static final String JDBC_HIVE_USERNAME = "jdbc.hive.username";
    public static final String JDBC_HIVE_PASSWORD = "jdbc.hive.password";
    public static final String HBASE_FAMILY_DEFAULT = "default";
    public static final Configuration CONF = new XmlConf();
    public static final String CONF_FILE = "hive-conf.xml";
    private static volatile HiveMapHBaseService singleton;
    private final String driver = CONF.get(JDBC_HIVE_DRIVER);
    private final String url = CONF.get(JDBC_HIVE_URL);
    private final String username = CONF.get(JDBC_HIVE_USERNAME);
    private final String password = CONF.get(JDBC_HIVE_PASSWORD);
    private HiveMapHBaseService(){}

    public static HiveMapHBaseService instance(){
        if(null == singleton){
            synchronized (HiveMapHBaseService.class){
                if(null == singleton){
                    singleton = new HiveMapHBaseService();
                }
            }
        }
        return singleton;
    }

    static {
        SourceLoader.loadFile(CONF, CONF_FILE);
    }

    private void executeSQL(String sql) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        try(Connection connection = DriverManager.getConnection(url, username, password)){
            JdbcUtils.execute(connection, sql, false);
        }
    }

    public void execute(String table, Map<String, Class> schema) throws Exception {
        String hql = mapHiveSQL(table, schema);
        executeSQL(hql);
    }

    /**
     * Map hive sql.
     *
     * @param table
     * @param schema
     * @return
     */
    private String mapHiveSQL(String table, Map<String, Class> schema) {
        AssertUtils.check(schema.size() > 0, "Scheme cannot be empty.");
        StringBuilder builder = new StringBuilder("CREATE EXTERNAL TABLE IF NOT EXISTS " + table + "(");
        for (Map.Entry<String, Class> entry : schema.entrySet()) {
            builder.append(hiveField(entry.getKey(), entry.getValue())).append(",");
        }
        builder.deleteCharAt(builder.length() - 1).append(")\n");
        builder.append("STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler'\n");
        builder.append("WITH SERDEPROPERTIES\n");
        builder.append("(\"hbase.columns.mapping\" = \":key");
        for (Map.Entry<String, Class> entry : schema.entrySet()) {
            builder.append(",").append(hbaseField(HBASE_FAMILY_DEFAULT, entry.getKey(), entry.getValue()));
        }
        builder.append("\")\n");
        builder.append("TBLPROPERTIES(\"hbase.table.name\" = \"").append(table).append("\")").toString();
        return builder.toString();
    }

    private static String hiveField(String key, Class type) {
        String field = key + " ";
        if (isString(type)) {
            field += "string";
        } else if (isByte(type)) {
            field += "tinyint";
        } else if (isShort(type)) {
            field += "smallint";
        } else if (isInteger(type)) {
            field += "int";
        } else if (isLong(type)) {
            field += "bigint";
        } else if (isBoolean(type)) {
            field += "boolean";
        } else if (isFloat(type)) {
            field += "float";
        } else if (isDouble(type)) {
            field += "double";
        } else if (isCharacter(type)) {
            field += "char";
        }
        return field;
    }

    private static String hbaseField(String family, String key, Class type) {
        String field = family + ":" + key;
        if (isByte(type) || isShort(type) || isInteger(type) || isFloat(type) || isDouble(type) || isBoolean(type)) {
            field += "#b";
        }
        return field;
    }

    public static void main(String[] args) throws Exception {
        String table = "test002";
        Map<String, Class> schema = new HashMap<>();
        schema.put("col_001", String.class);
        schema.put("col_002", Integer.class);
        schema.put("col_003", Boolean.class);
        schema.put("col_004", double.class);
        HiveMapHBaseService.instance().execute(table, schema);
    }
}
