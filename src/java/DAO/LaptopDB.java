/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Laptop;
import model.Specification;
import context.DatabaseInfo;
import model.Brand;
/**
 *
 * @author tinyl
 */
public class LaptopDB implements  DatabaseInfo{
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
    
    public ArrayList<Laptop> getAll(){
        ArrayList<Laptop> listLaptop = new ArrayList<>();
        String sql = "select * from Laptop";
        try (Connection con=getConnect()){
            BrandDB brandDB = new BrandDB();
            CategoryDB categoryDB = new CategoryDB();
            SpecificationDB specificationDB = new SpecificationDB();
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
                        brandDB.getBrandByID(rs.getInt(7)),
                        categoryDB.getCategoryByID(rs.getInt(8)),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getBoolean(12),
                        specificationDB.getSpecificationByLaptopID(rs.getString(1))));    
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listLaptop;
    }
    
     public ArrayList<Laptop> getAllAvailableLaptop(){
        ArrayList<Laptop> listLaptop = new ArrayList<>();
        String sql = "select * from Laptop where status = 1";
        try (Connection con=getConnect()){
            BrandDB brandDB = new BrandDB();
            CategoryDB categoryDB = new CategoryDB();
            SpecificationDB specificationDB = new SpecificationDB();
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
                        brandDB.getBrandByID(rs.getInt(7)),
                        categoryDB.getCategoryByID(rs.getInt(8)),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getBoolean(12),
                        specificationDB.getSpecificationByLaptopID(rs.getString(1))));    
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listLaptop;
    }
    
public static Laptop getLaptop(String laptop_id){
        Laptop Laptop = null;
        String sql = "select * from laptop where laptop_id=?";       
        try(Connection con=getConnect()){
            BrandDB brandDB = new BrandDB();
            CategoryDB categoryDB = new CategoryDB();
            SpecificationDB specificationDB = new SpecificationDB();
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
                        brandDB.getBrandByID(rs.getInt(7)),
                        categoryDB.getCategoryByID(rs.getInt(8)),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getBoolean(12),
                        specificationDB.getSpecificationByLaptopID(rs.getString(1)));
                con.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return Laptop;
    }


    public boolean insert(Laptop Laptop , Specification specification){
        BrandDB brandDB = new BrandDB();
        CategoryDB categoryDB = new CategoryDB();
        if(brandDB.getBrandByID(Laptop.getBrand().getBrand_id())==null) {
            System.out.println("brand does not exist");
            return false;
        }
        if(categoryDB.getCategoryByID(Laptop.getCategory().getCategory_id())==null) {
            System.out.println("category does not exist");
            return false;
        }
        
        try(Connection con=getConnect()) {
            PreparedStatement pt=con.prepareStatement("insert into laptop laptop values  ('?', '?', '?','?', ?, ?, ?, ?, '?', ?, ?, ?),");
 //String laptop_id, String laptop_name, String laptop_img, double purchase_price, double selling_price, int brand_id, int category_id, String describe, int tax, int deposit, boolean status
            pt.setString(1, Laptop.getLaptop_id());
            pt.setString(2, Laptop.getLaptop_name());
            pt.setString(3, Laptop.getLaptop_img());
            pt.setString(4, Laptop.getColor());
            pt.setDouble(5, Laptop.getPurchase_price());
            pt.setDouble(6, Laptop.getSelling_price());
            pt.setInt(7, Laptop.getBrand().getBrand_id());
            pt.setInt(8, Laptop.getCategory().getCategory_id());
            pt.setString(9, Laptop.getDescribe());
            pt.setInt(10, Laptop.getTax());
            pt.setInt(11, Laptop.getDeposit());
            pt.setBoolean(12, Laptop.isStatus());
            pt.executeUpdate();
            
            pt=con.prepareStatement("insert into Specifications values  ('?', '?', '?','?', '?', '?', '?', '?', '?', '?', '?','?'),");
 //String laptop_id, String laptop_name, String laptop_img, double purchase_price, double selling_price, int brand_id, int category_id, String describe, int tax, int deposit, boolean status
            pt.setString(1, Laptop.getLaptop_id());
            pt.setString(2, specification.getMaterial());
            pt.setString(3, specification.getScreen());
            pt.setString(4, specification.getCpu());
            pt.setString(5, specification.getRam());
            pt.setString(6, specification.getHard_drive());
            pt.setString(7, specification.getGraphics());
            pt.setString(8, specification.getOs());
            pt.setString(9, specification.getWeight());
            pt.setString(10, specification.getSize());
            pt.setString(11, specification.getOrigin());
            pt.setInt(12, specification.getLaunch_year());
            pt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
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
   
    public static int changeStatusOfBuyLaptops(ArrayList<Laptop>list){
        int number=0;
        try (Connection con=getConnect()){
            PreparedStatement stmt=con.prepareStatement("update laptop set status=0 where laptop_id=?");
            for(Laptop laptop:list){
                stmt.setString(1, laptop.getLaptop_id());
                stmt.executeUpdate();
                number++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return number;
    }
    
    public static ArrayList<Laptop>searchBaseName(String name){
        
        try(Connection con=getConnect()) {
           ArrayList<Laptop>list=new ArrayList<>(); 
           PreparedStatement stmt=con.prepareStatement("select * from laptop where laptop_name like ?");
           stmt.setString(1, "%" + name + "%");
           ResultSet rs=stmt.executeQuery();
           while(rs.next()){
               Laptop laptop=new Laptop(rs.getString(1),
                       rs.getString(2),
                       rs.getString(3),
                       rs.getString(4),
                       rs.getDouble(5),
                       rs.getDouble(6),
                       BrandDB.getBrandByID(rs.getInt(7)), 
                       CategoryDB.getCategoryByID(rs.getInt(8)),
                       rs.getString(9),
                       rs.getInt(10),
                       rs.getInt(11),
                       rs.getBoolean(12),
                       SpecificationDB.getSpecificationByLaptopID(rs.getString(1)));
               list.add(laptop);           
           }
           con.close();
           return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public static void main(String[] args){
        System.out.println(searchBaseName("dell"));
    } 
        
  
}


