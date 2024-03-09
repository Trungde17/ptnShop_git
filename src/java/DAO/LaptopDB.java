/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import context.DatabaseInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Laptop;

/**
 *
 * @author tinyl
 */
public class LaptopDB implements DatabaseInfo{
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
    
    public List<Laptop> getAll(){
        List<Laptop> listLaptop = new ArrayList<>();
        String sql = "exec SelectLaptopDetails";
        try (Connection con=getConnect()){
            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
             while(rs.next()){
                listLaptop.add(new Laptop(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getBoolean(12)));    
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listLaptop;
    }
    
public Laptop getLaptop(String laptop_id){
        Laptop Laptop = null;
        String sql = "exec SelectLaptopDetailsByID @laptop_id =?";       
        try(Connection con=getConnect()){
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, laptop_id);
            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                Laptop = new Laptop(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getBoolean(12));
                con.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return Laptop;
    }
    public int insert(Laptop Laptop){
        try(Connection con=getConnect()) {
            PreparedStatement pt=con.prepareStatement("exec InsertIntoLaptop  @laptop_id ='?', @laptop_name = '?', @laptop_img = '?',\n" +
"@color = '?', @purchase_price = ?, @selling_price = ?, @brand_name = '?', @category_name = '?', @describe ='', @tax = ?, @deposit = ?, @status = ?");
 //String laptop_id, String laptop_name, String laptop_img, double purchase_price, double selling_price, int brand_id, int category_id, String describe, int tax, int deposit, boolean status
            pt.setString(1, Laptop.getLaptop_id());
            pt.setString(2, Laptop.getLaptop_name());
            pt.setString(3, Laptop.getLaptop_img());
            pt.setString(4, Laptop.getColor());
            pt.setDouble(5, Laptop.getPurchase_price());
            pt.setDouble(6, Laptop.getSelling_price());
            pt.setString(7, Laptop.getBrand_name());
            pt.setString(8, Laptop.getCategory_name());
            pt.setString(9, Laptop.getDescribe());
            pt.setInt(10, Laptop.getTax());
            pt.setInt(11, Laptop.getDeposit());
            pt.setBoolean(12, Laptop.isStatus());
            pt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
        return 1;
    }
    public int getAmountOfLaptopName(String laptop_name){
        int number=0;
        try (Connection con = getConnect()){
            PreparedStatement pt=con.prepareStatement("select dbo.getAmountOfLaptopName (?)");
            pt.setString(1, laptop_name);
            ResultSet rs=pt.executeQuery();
            if(rs.next())number=rs.getInt(1);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return number;
    }
    
    public Laptop getLaptop(String attribute, String value){
        Laptop laptop=null;
        
        try (Connection con = getConnect()){
            PreparedStatement pt=con.prepareStatement("select * from Laptop where " + attribute + "=?");
            
            pt.setString(1, value);
            ResultSet rs=pt.executeQuery();
            if(rs.next()){
                laptop = new Laptop(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getBoolean(12));       
            }           
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return laptop;
    }
    
    public static void main(String[] args){
        LaptopDB bdb = new LaptopDB();       
        for(Laptop u : bdb.getAll()){
            System.out.println(u.toString());
        }
        System.out.println(bdb.getLaptop("levleg021xx1").toString());
       System.out.println(bdb.getAmountOfLaptopName("Dell XPS 13"));
//        
    }
}


