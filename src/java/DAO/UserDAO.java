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
                user.setPhone(rs.getString("phone"));
                user.setCccd(rs.getString("cccd"));
                user.setRegistration_date(rs.getDate("registration_date"));
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
                u.setPhone(rs.getString("phone"));
                u.setCccd(rs.getString("cccd"));
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
        getConnect();
        System.out.println(getUser("tanchun2003@gmail.com", "12345", false));
    }
}
