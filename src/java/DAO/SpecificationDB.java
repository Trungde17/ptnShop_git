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
import context.DatabaseInfo;
import model.Specification;


/**
 *
 * @author tinyl
 */
public class SpecificationDB implements DatabaseInfo{
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
   
    public Specification getSpecificationByLaptopID(String laptop_id){
        Specification Specification = null;
        String sql = "select * from [specifications] where laptop_id=?";       
        try(Connection con=getConnect()){
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, laptop_id);
            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                Specification = new Specification(rs.getString(2),
                                                    rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getInt(12));
                con.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return Specification;
    }
    
    
    public static void main(String[] args){
        SpecificationDB bdb = new SpecificationDB();       
        
        System.out.println(bdb.getSpecificationByLaptopID("2").toString());

      
//        
    }
}

