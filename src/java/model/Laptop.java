/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author tinyl
 */
public class Laptop {
    private String laptop_id;
    private String laptop_name;
    private String laptop_img;
    private String color;
    private double purchase_price;
    private double selling_price;
    private String brand_name;
    private String category_name;
    private String describe;
    private int tax;
    private int deposit;
    private boolean status;

    public Laptop(String laptop_id, String laptop_name, String laptop_img, String color, double purchase_price, double selling_price, String brand_name, String category_name, String describe, int tax, int deposit, boolean status) {
        this.laptop_id = laptop_id;
        this.laptop_name = laptop_name;
        this.laptop_img = laptop_img;
        this.color = color;
        this.purchase_price = purchase_price;
        this.selling_price = selling_price;
        this.brand_name = brand_name;
        this.category_name = category_name;
        this.describe = describe;
        this.tax = tax;
        this.deposit = deposit;
        this.status = status;
    }

    public String getLaptop_id() {
        return laptop_id;
    }

    public void setLaptop_id(String laptop_id) {
        this.laptop_id = laptop_id;
    }

    public String getLaptop_name() {
        return laptop_name;
    }

    public void setLaptop_name(String laptop_name) {
        this.laptop_name = laptop_name;
    }

    public String getLaptop_img() {
        return laptop_img;
    }

    public void setLaptop_img(String laptop_img) {
        this.laptop_img = laptop_img;
    }

    public double getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(double purchase_price) {
        this.purchase_price = purchase_price;
    }

    public double getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(double selling_price) {
        this.selling_price = selling_price;
    }

  

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Laptop other = (Laptop) obj;
        if (Double.doubleToLongBits(this.purchase_price) != Double.doubleToLongBits(other.purchase_price)) {
            return false;
        }
        if (Double.doubleToLongBits(this.selling_price) != Double.doubleToLongBits(other.selling_price)) {
            return false;
        }
        if (this.tax != other.tax) {
            return false;
        }
        if (this.deposit != other.deposit) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.laptop_id, other.laptop_id)) {
            return false;
        }
        if (!Objects.equals(this.laptop_name, other.laptop_name)) {
            return false;
        }
        if (!Objects.equals(this.laptop_img, other.laptop_img)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.brand_name, other.brand_name)) {
            return false;
        }
        if (!Objects.equals(this.category_name, other.category_name)) {
            return false;
        }
        return Objects.equals(this.describe, other.describe);
    }

    @Override
    public String toString() {
        return "Laptop{" + "laptop_id=" + laptop_id + ", laptop_name=" + laptop_name + ", laptop_img=" + laptop_img + ", color=" + color + ", purchase_price=" + purchase_price + ", selling_price=" + selling_price + ", brand_name=" + brand_name + ", category_name=" + category_name + ", describe=" + describe + ", tax=" + tax + ", deposit=" + deposit + ", status=" + status + '}';
    }
    
}
