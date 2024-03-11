package DAO;

import context.DatabaseInfo;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
public class UserDAO implements DatabaseInfo{
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
    public static int insert(User user){
        try(Connection con=getConnect()) {
            PreparedStatement stmt=con.prepareStatement("insert into tbluser values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, user.getUser_id());
            stmt.setBoolean(2, user.getUser_type());
            stmt.setString(3, user.getFirst_name());
            stmt.setString(4, user.getLast_name());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getPassword());
            stmt.setString(7, user.getAddress());
            stmt.setString(8, user.getPhone());
            stmt.setDate(9, new java.sql.Date(user.getRegistration_date().getTime()));
            stmt.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            return 0;
        }
        
        return 1;
    }
    // get user bằng email, pass và user_type
    public static User getUser(String email, String password, boolean user_type){
        User user = null;
        try(Connection con=getConnect()) {
            PreparedStatement stmt=con.prepareStatement("select * from tbluser where email=? and password=? and user_type=?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setBoolean(3, user_type);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                user=new User();
                user.setUser_id(rs.getString("user_id"));
                user.setUser_type(rs.getBoolean("user_type"));
                user.setFirst_name(rs.getString("first_name"));
                user.setFirst_name(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setRegistration_date(rs.getDate("registration_date"));
            }
            con.close();
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }
    
    public static int countUser(){
        int number=0;
        try (Connection con = getConnect()){
            PreparedStatement stmt=con.prepareStatement("select count(user_id) as count from tbluser");
            ResultSet rs=stmt.executeQuery();
            if(rs.next())number=rs.getInt("count");
            con.close();
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return number;
    }
  
    public static User getUser(String attribute, String value){
        User user=null;
        
        try (Connection con = getConnect()){
            PreparedStatement stmt=con.prepareStatement("select * from tbluser where " + attribute + "=?");
            
            stmt.setString(1, value);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                user=new User(
                        rs.getString("user_id"),
                        rs.getBoolean("user_type"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getDate("registration_date")               
                );

            }           
            con.close();
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }
    
    public static ArrayList<User> getAll(){
        ArrayList<User>list=null;
        try(Connection con=getConnect()) {
            PreparedStatement stmt=con.prepareStatement("Select * From tbluser");
            ResultSet rs=stmt.executeQuery();
            list=new ArrayList<>();
            while(rs.next()){
                User u=new User();
                u.setUser_id(rs.getString("user_id"));
                u.setUser_type(rs.getBoolean("user_type"));
                u.setFirst_name(rs.getString("first_name"));
                u.setFirst_name(rs.getString("last_name"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setAddress(rs.getString("address"));
                u.setPhone(rs.getString("phone"));
                u.setRegistration_date(rs.getDate("registration_date"));
                list.add(u);
                
            }
            con.close();
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println(getUser("email","tanChun2003@gmail.com"));
        User u=new User("user3", false, "trung", "thanh", "thanhTrung03@gmail.com", "12345", "Quang Nam", "039813243", new java.util.Date());
        System.out.println(insert(u));
    }
    
}
