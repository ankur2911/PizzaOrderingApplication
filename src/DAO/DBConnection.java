package DAO;

import java.sql.*;


public class DBConnection {
	
	public final static String user = "root";
    public final static String password = "password";
    public final static String connectionUrl = "jdbc:mysql://localhost:3306/pizza";
    
	 public static Connection getDbConnection(){
	        try{
	            Class.forName("com.mysql.jdbc.Driver");
	            return DriverManager.getConnection(connectionUrl,user,password);
	        }catch(Exception e){
	           e.printStackTrace();
	        }
	        return null;
	    }
}
