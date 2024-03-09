/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DatabaseInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;


/**
 *
 * @author tinyl
 */
public class CategoryDB implements DatabaseInfo{
    public Connection getConnect(){
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
    public List<Category> getAll(){
        List<Category> listCategory = new ArrayList<>();
        String sql = "select * from Category";
        try (Connection con=getConnect()){
            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
             while(rs.next()){
                listCategory.add(new Category(
                        rs.getInt(1),
                        rs.getString(2)));    
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listCategory;
    }
    
    public Category getCategoryByID(int Category_id){
        Category Category = null;
        String sql = "select * from Category where Category_id=?";       
        try(Connection con=getConnect()){
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, Category_id);
            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                Category = new Category(
                        rs.getInt(1),
                        rs.getString(2));
                con.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return Category;
    }
    
    public boolean insert(Category Category){
        try(Connection con=getConnect()) {
            PreparedStatement pt=con.prepareStatement("insert into Category values(?, ?)");
            pt.setInt(1, Category.getCategory_id());
            pt.setString(2, Category.getCategory_name());    
            pt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public int countCategory(){
        int number=0;
        try (Connection con = getConnect()){
            PreparedStatement pt=con.prepareStatement("select count(Category_id) as count from Category");
            ResultSet rs=pt.executeQuery();
            if(rs.next())number=rs.getInt("count");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return number;
    }
    public static void main(String[] args){
        CategoryDB bdb = new CategoryDB();       
        
        System.out.println(bdb.getCategoryByID(1).toString());
        System.out.println(bdb.countCategory());
      
//        
    }
}
