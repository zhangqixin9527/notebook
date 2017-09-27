//package com.hengba.sql;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @author Kevin created on 2017/9/25
// */
//public class SQLStringHelper <T> {
//
//    private EntityHelper entityHelper = new EntityHelper();
//
//    /**
//     * 根据传入的实体生成Insert SQL語句
//     *
//     * @param entity
//     * @return 拼接好的sql语句
//     */
//    @SuppressWarnings("unchecked")
//    public String createInsert(T entity) {
//        String sql = "Insert into ";
//        String column = ""; // 列
//        String c_values = ""; // 列值
//        List<Map<String, Object>> list = entityHelper.getFiledsInfo(entity);
//        sql += list.get(0).get("obj_name").toString() + " ";
//        for (int i = 0; i < list.size(); i++) {
//
//            // 約定id在數據庫自動生成-20130807
//
//            if (String.valueOf(list.get(i).get("f_name")).equals("id")) {
//                i++;
//            } else if (list.get(i).get("f_value") != null) {
//                column += list.get(i).get("f_name") + ",";
//                c_values += "'" + list.get(i).get("f_value") + "',";
//            }
//
//        }
//        sql += "(" + column.substring(0, column.length() - 1) + ") values ("
//                + c_values.substring(0, c_values.length() - 1) + ");";
//
//        return sql;
//
//    }
//
//    /**
//     * 拼裝Delete SQL語句
//     *
//     * @param entity
//     * @param id
//     *            实体id
//     * @return
//     */
//    @SuppressWarnings("unchecked")
//    public String createDelete(T entity, int id) {
//        String sql = "delete from ";
//        List<Map<String, Object>> list = entityHelper.getFiledsInfo(entity);
//        sql += list.get(0).get("obj_name").toString() + " where id=" + id + ";";
//        return sql;
//    }
//
//    /**
//     * 查找
//     *
//     * @param entity
//     * @return
//     */
//    @SuppressWarnings("unchecked")
//    public String createSelect(T entity) {
//        String sql = "select * from ";
//        String column = ""; // 列
//        List<Map<String, Object>> list = entityHelper.getFiledsInfo(entity);
//        sql += list.get(0).get("obj_name").toString() + " where ";
//        for (int i = 0; i < list.size(); i++) {
//
//            // 約定id在數據庫自動生成-20130807
//
//            // id計數不能從0開始
//            // 如果知道id直接根据id生成sql语句就可以了
//            if (String.valueOf(list.get(i).get("f_name")).equals("id")
//                    && !String.valueOf(list.get(i).get("f_value")).equals("0")) {
//                sql += "id=" + list.get(i).get("f_value");
//                return sql;
//            } else if (list.get(i).get("f_value") != null) {
//
//                column += list.get(i).get("f_name") + " like %"
//                        + list.get(i).get("f_value") + "% or ";
//            }
//        }
//        return sql += column.substring(0, column.length() - 4) + ";";
//
//    }
//
//    /**
//     * 根据id更新实体数据
//     *
//     * @param entity
//     * @param id
//     *            实体id
//     * @return 拼装好的 Update SQL语句
//     */
//    @SuppressWarnings("unchecked")
//    public String createUpdate(T entity, int id) {
//        String sql = "update ";
//        String column = ""; // 列
//        List<Map<String, Object>> list = entityHelper.getFiledsInfo(entity);
//        sql += list.get(0).get("obj_name").toString() + " set ";
//        for (int i = 0; i < list.size(); i++) {
//
//            // id不能修改
//            if (String.valueOf(list.get(i).get("f_name")).equals("id")) {
//                i++;
//            } else if (list.get(i).get("f_value") != null) {
//                column += list.get(i).get("f_name") + "='"
//                        + list.get(i).get("f_value")+"',";
//            }
//
//        }
//        return sql +=column.substring(0, column.length()-1) + " where id='" + id+"'";
//
//    }
//}
