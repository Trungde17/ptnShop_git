
package DAO;

import context.DatabaseInfo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Laptop;
import model.Order;
import model.OrderDetail;
import model.User;
public class OrderDetailDAO implements DatabaseInfo{
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
    
    public static int insert(OrderDetail orderDetail){
        int number=0;
        try (Connection con=getConnect()){
            PreparedStatement stmt=con.prepareStatement("insert into orderdetail values(?, ?)");
            stmt.setString(1, orderDetail.getOrder().getOrder_id());
            for(Laptop laptop:orderDetail.getListLaptopOrder()){
                stmt.setString(2, laptop.getLaptop_id());
                stmt.executeUpdate();
                number++;
            }
            con.close();
        } catch (Exception e) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, e);
            return number;
        }
        return number;
    }
    public OrderDetail getAll(){
        
    }
    public static void main(String[] args) {
       
    }
}
