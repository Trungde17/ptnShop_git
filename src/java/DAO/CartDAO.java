package DAO;

import context.DatabaseInfo;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;
import model.Laptop;
import model.User;
import java.util.Date;

public class CartDAO implements DatabaseInfo {

    public static Connection getConnect() {
        try {
            Class.forName(DRIVERNAME);
        } catch (ClassNotFoundException e) {
            System.out.println(e);

        }
        try {
            Connection con = DriverManager.getConnection(DBURL, USERDB, PASSDB);

            return con;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static Cart getCartByCustomerID(String customer_id) {
        User customer = UserDAO.getUser("user_id", customer_id);
        if (customer != null) {
            try (Connection con = getConnect()) {
                PreparedStatement stmt = con.prepareStatement("select * from cart where customer_id=?");
                stmt.setString(1, customer_id);
                ResultSet rs = stmt.executeQuery();
                Map<Laptop, Date> map = new LinkedHashMap<>();
                while (rs.next()) {
                    Date date = rs.getDate(3);                   
                    map.put(LaptopDB.getLaptop(rs.getString(2)), date);
                }
                
                if (map.size() > 0) {
                    Cart cart=new Cart();
                    cart.setCustomer(customer);
                    cart.setMap(map);
                    con.close();
                    return cart;
                }
            } catch (Exception e) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    public static int insert(String user_id, String laptop_id){
        try (Connection con=getConnect()){
            PreparedStatement stmt=con.prepareStatement("insert cart values(?, ?, ?)");
            stmt.setString(1, user_id);
            stmt.setString(2, laptop_id);
            stmt.setDate(3, new java.sql.Date(new Date().getTime()));
            stmt.executeUpdate();
            con.close();
            return 1;
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    public static int delete(String user_id, String laptop_id){
        try (Connection con=getConnect()){
            PreparedStatement stmt=con.prepareStatement("DELETE cart where customer_id=? and laptop_id=?");
            stmt.setString(1, user_id);
            stmt.setString(2, laptop_id);
            stmt.executeUpdate();
            con.close();
            return 1;
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(delete("user1", "LAP001"));
    }
    public static boolean deleteAll(){
        try (Connection con=getConnect()){
            PreparedStatement stmt=con.prepareStatement("delete cart");
            stmt.executeQuery();
            con.close();
            return true;
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
}
