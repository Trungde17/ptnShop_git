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
    private final Brand brand;
    private final Category category;
    private String describe;
    private int tax;
    private int deposit;
    private boolean status;
    private Specification specification;

    public Laptop() {
        this.brand = null;
        this.category = null;
    }
    
    
    public Laptop(String laptop_id, String laptop_name, String laptop_img, String color, double purchase_price, double selling_price, Brand brand, Category category, String describe, int tax, int deposit, boolean status, Specification specificaion) {
        this.laptop_id = laptop_id;
        this.laptop_name = laptop_name;
        this.laptop_img = laptop_img;
        this.color = color;
        this.purchase_price = purchase_price;
        this.selling_price = selling_price;
        this.brand = brand;
        this.category = category;
        this.describe = describe;
        this.tax = tax;
        this.deposit = deposit;
        this.status = status;
        this.specification = specificaion;
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

    public Brand getBrand() {
        return brand;
    }

    public Category getCategory() {
        return category;
    }
    
    

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
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
        return Objects.equals(this.laptop_id, other.laptop_id);
    }

    

    @Override
    public String toString() {
        return "Laptop{" + "laptop_id=" + laptop_id + ", laptop_name=" + laptop_name + ", laptop_img=" + laptop_img + ", color=" + color + ", purchase_price=" + purchase_price + ", selling_price=" + selling_price + ", brand=" + brand.getBrand_name() + ", category=" + category.getCategory_name() + ", describe=" + describe + ", tax=" + tax + ", deposit=" + deposit + ", status=" + status + ", material=" + specification.getMaterial() + '}';
    } 
}
