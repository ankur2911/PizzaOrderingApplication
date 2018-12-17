package DataManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import DAO.DBConnection;

public class DataDAO {
	private Connection conn;
    private PreparedStatement ps;
    
    public DataDAO() {
        conn = DBConnection.getDbConnection();
        ps = null;
    }
    
    public HashMap<String, Integer> getData(){
    	
    		HashMap<String, Integer> parameterMap = new HashMap<String, Integer>();
    		
    		try {
                ps = conn.prepareStatement("select * from toppings");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                
                		parameterMap.put(rs.getString("topping"), rs.getInt("quantity"));
                	
                	
                }
         return parameterMap;
    		}catch (Exception e) {
    			
                System.out.println(e);
        }
        return null;
    }
}
