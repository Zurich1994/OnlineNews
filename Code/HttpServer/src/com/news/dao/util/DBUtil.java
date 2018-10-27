package com.news.dao.util;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
 
public class DBUtil {  
    public static final String url = 
    "jdbc:mysql://localhost:3306/news?useUnicode=true&characterEncoding=UTF-8";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "0000";  
  
    public Connection conn = null;  
    public PreparedStatement ps = null;  
  
    public DBUtil(String sql) {  
        try {  
            Class.forName(name);//ָ����������  
            conn = DriverManager.getConnection(url, user, password);//��ȡ����  
            ps = conn.prepareStatement(sql);//׼��ִ�����  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public void close() {  
        try {  
            this.conn.close();  
            this.ps.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}  

