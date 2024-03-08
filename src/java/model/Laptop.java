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
    private double purchase_price;
    private double selling_price;
    private int brand_id;
    private int category_id;
    private String describe;
    private int tax;
    private int deposit;
    private boolean status;

    public Laptop(String laptop_id, String laptop_name, String laptop_img, double purchase_price, double selling_price, int brand_id, int category_id, String describe, int tax, int deposit, boolean status) {
        this.laptop_id = laptop_id;
        this.laptop_name = laptop_name;
        this.laptop_img = laptop_img;
        this.purchase_price = purchase_price;
        this.selling_price = selling_price;
        this.brand_id = brand_id;
        this.category_id = category_id;
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

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
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

    @Override
    public int hashCode() {
        int hash = 7;
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
        if (this.brand_id != other.brand_id) {
            return false;
        }
        if (this.category_id != other.category_id) {
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
        return Objects.equals(this.describe, other.describe);
    }

    @Override
    public String toString() {
        return "Laptop{" + "laptop_id=" + laptop_id + ", laptop_name=" + laptop_name + ", laptop_img=" + laptop_img + ", purchase_price=" + purchase_price + ", selling_price=" + selling_price + ", brand_id=" + brand_id + ", category_id=" + category_id + ", describe=" + describe + ", tax=" + tax + ", deposit=" + deposit + ", status=" + status + '}';
    }
}
