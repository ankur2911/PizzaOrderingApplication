package OrderManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DBConnection;


public class OrderDao {

	private Connection conn;
    private PreparedStatement ps;

    public OrderDao() {
        conn = DBConnection.getDbConnection();
        ps = null;
    }
    
    public boolean orderPizza(OrderEntity orderEntity) {
        try {
            ps = conn.prepareStatement("insert into orderDetails(email,name,size,crust,topping,info, cost) values(?,?,?,?,?,?,?)");
            ps.setString(1, orderEntity.getEmail());
            ps.setString(2, orderEntity.getName());
            ps.setString(3, orderEntity.getSize());
            ps.setString(4, orderEntity.getCrust());
            ps.setString(5, orderEntity.getToppings());
            ps.setString(6, orderEntity.getInfo());
            ps.setInt(7, orderEntity.getCost());
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public void decTopping(String topping) {
    	try {
			ps = conn.prepareStatement("UPDATE toppings SET quantity = quantity - 1 WHERE topping='"+topping+"'");
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}

    }
    
}
