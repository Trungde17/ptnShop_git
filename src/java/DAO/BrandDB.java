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
import model.Brand;


/**
 *
 * @author tinyl
 */
public class BrandDB implements DatabaseInfo{
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
    public static List<Brand> getAll(){
        List<Brand> listBrand = new ArrayList<>();
        String sql = "select * from brand";
        try (Connection con=getConnect()){
            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
             while(rs.next()){
                listBrand.add(new Brand(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));    
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listBrand;
    }
    
    public static Brand getBrandByID(int brand_id){
        Brand brand = null;
        String sql = "select * from brand where brand_id=?";       
        try(Connection con=getConnect()){
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, brand_id);
            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                brand = new Brand(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));  
                con.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return brand;
    }
    
    public static boolean insert(Brand brand){
        try(Connection con=getConnect()) {
            PreparedStatement pt=con.prepareStatement("insert into brand values(?, ?, ?)");
            pt.setInt(1, brand.getBrand_id());
            pt.setString(2, brand.getBrand_name());   
            pt.setString(2, brand.getCountry());    
            pt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public static int countBrand(){
        int number=0;
        try (Connection con = getConnect()){
            PreparedStatement pt=con.prepareStatement("select count(brand_id) as count from brand");
            ResultSet rs=pt.executeQuery();
            if(rs.next())number=rs.getInt("count");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return number;
    }
    public static void main(String[] args){
        BrandDB bdb = new BrandDB();       
        
        System.out.println(bdb.getBrandByID(1).toString());
        System.out.println(bdb.countBrand());
      
//        
    }
}
