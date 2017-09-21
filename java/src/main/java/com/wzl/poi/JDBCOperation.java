package com.wzl.poi;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Description :
 * Author: zhenglong
 * since 29 八月 2017
 */
public class JDBCOperation {

    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/opc_wbs_init?useUnicode=true&amp;characterEncoding=UTF-8&allowMultiQueries=true";
        String username = "root";
        String pd = "root";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, username, pd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        getAll();
    }

    private static Map<String,Integer> getAll() {
        Map<String,Integer> map=new HashMap();
        Connection conn = getConn();
        String sql = "select type_code,text,value from dictionary_item";
        PreparedStatement pstmt=null;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                map.put(rs.getString(1)+"-"+rs.getString(2),rs.getInt(3));
            }
            for(Map.Entry e:map.entrySet()){
                System.out.println(e.getKey()+":"+e.getValue());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pstmt.close();
            }catch (Exception e){
                System.out.println("cccccc");
            }
        }
        return map;
    }
    public static int insert(int formId,int detailId,int sort) {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert into inspection_form_item (form_id,detail_id,sort) values(?,?,?)";
        PreparedStatement pstmt=null;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, formId);
            pstmt.setInt(2, detailId);
            pstmt.setInt(3,sort);

            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pstmt.close();
            }catch (Exception e){
                System.out.println("cccccc");
            }
        }
        return i;
    }


}
