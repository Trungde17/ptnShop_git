/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tinyl
 */
public class Brand {
    private int brand_id;
    private String brand_name;
    private String country;

    public Brand(int brand_id, String brand_name, String country) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.country = country;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    @Override
    public String toString() {
        return brand_name;
    } 
}
