package InventoryManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.DBConnection;

public class InventoryDAO {
	private Connection conn;
    private PreparedStatement ps;

    public InventoryDAO() {
        conn = DBConnection.getDbConnection();
        ps = null;
    }
    
    public boolean updateTopping(InventoryEntity ie) {
    	try {
			ps = conn.prepareStatement("UPDATE toppings SET quantity = "+ie.getQuantity()+" WHERE topping='"+ie.getTopping()+"'");
			
			return ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			System.out.println(e);
		}
    	
    	return false;

    }
    
    public boolean deleteTopping(InventoryEntity ie) {
    	try {
			ps = conn.prepareStatement("Delete from toppings WHERE topping='"+ie.getTopping()+"'");
			
			return ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			System.out.println(e);
		}
    	
    	return false;

    }
    
}
