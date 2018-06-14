package twt.controller.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SQLDao {
	// JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://123.207.91.166:3306/CommunitySystem";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "cha";
    static final String PASS = "123456";
    
    public static Connection conn = null;
    public static Statement stmt = null;
    
    static boolean inited=false;
    
    public static int init() {
    	if(inited)return 1;
         try{
             // 注册 JDBC 驱动
             Class.forName("com.mysql.jdbc.Driver");
         
             // 打开链接
             System.out.println("连接数据库...");
             conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
         
             // 执行查询
             System.out.println(" 实例化Statement对象...");
             stmt = (Statement) conn.createStatement();
             inited=true;
         }catch (Exception e) {
        	 System.out.println(e);
        	 return 0;
			// TODO: handle exception
		}
		return 1;
    }
 
    public static void main(String[] args) {
        try{
        	init();

            String sql;
            sql = "SELECT * from Admin";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 名称: " + name);
                System.out.print(", phoneL: " + phone);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            close();
        }
    }
    static public int close() {
    	try{
            if(stmt!=null) stmt.close();
            conn.close();
        }catch(SQLException se2){
        	return 0;
        }// 什么都不做
        try{
            if(conn!=null) conn.close();
        }catch(SQLException se){
            se.printStackTrace();
            return 0;
        }
        return 1;
    }
}
