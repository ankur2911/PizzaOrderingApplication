package ToppingManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;

import DAO.DBConnection;

public class ToppingDAO {
	private Connection conn;
    private PreparedStatement ps;

    public ToppingDAO() {
        conn = DBConnection.getDbConnection();
        ps = null;
    }
    
    public boolean addTopping(ToppingEntity toppingEntity) {
        try {
            ps = conn.prepareStatement("insert into toppings(topping, quantity) values(?,?)");
            ps.setString(1, toppingEntity.getTopping());
            ps.setInt(2, toppingEntity.getQuantity());
           
           
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
