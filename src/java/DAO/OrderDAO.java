
package DAO;

import context.DatabaseInfo;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;
import model.User;
import java.util.Date;

public class OrderDAO implements DatabaseInfo{
    public static Connection getConnect(){
        try {
            Class.forName(DRIVERNAME);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            
        }
        try {
            Connection con = DriverManager.getConnection(DBURL, USERDB, PASSDB);
            
            return con;
        } catch (SQLException e ) {
            System.out.println(e);
        }
        return null;
    }
    
    public static int insert(Order order){
        try (Connection con=getConnect()){
            PreparedStatement stmt=con.prepareStatement("insert into tblorder values(?, ?, ?, ?, ?, ?)");
            stmt.setString(1, order.getOrder_id());
            stmt.setString(2, order.getCustomer().getUser_id());
            stmt.setBoolean(3, order.getOrder_status());
            stmt.setDate(4, new java.sql.Date(order.getOrder_date().getTime()));
            stmt.setString(5, order.getEmployee().getUser_id());
            stmt.setDate(6, new java.sql.Date(order.getDelivery_date().getTime()));
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, e);
            return 0;
        }
        return 1;
    }
    
    public static int countOrder(){
        int number=0;
        try (Connection con=getConnect()){
            PreparedStatement stmt=con.prepareStatement("select count(*) as numberOrder from tblorder");
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                number=rs.getInt("numberOrder");
            }
            con.close();
            return number;
        } catch (Exception e) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return number;
    }
    public Order getOrderByID(String Order_id){
        Order Order = null;
        String sql = "select * from tblorder where order_id=?";       
        try(Connection con=getConnect()){
            UserDAO userDB = new UserDAO();
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, Order_id);
            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                Order = new Order(
                        rs.getString(1),
                        userDB.getUserByID(rs.getString(2)),
                        rs.getBoolean(3),
                        rs.getDate(4),
                        rs.getDate(5),
                        userDB.getUserByID(rs.getString(6)));
                        
                con.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return Order;
    }
    public static void main(String[] args) {
        User cus=UserDAO.getUser("user_id", "user1");
        User em=UserDAO.getUser("user_id", "user2");
   
    }
}
