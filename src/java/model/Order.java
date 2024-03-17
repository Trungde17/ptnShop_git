/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Order {
    private String order_id;
    private User customer;
    private Boolean order_status;
    private Date order_date;
    private Date delivery_date;
    private User employee;
    public Order() {
    }

    public Order(String order_id, User customer, Boolean order_status, Date order_date, Date delivery_date  ,User employee) {
        this.order_id = order_id;
        this.customer = customer;
        this.order_status = order_status;
        this.order_date = order_date;
        this.delivery_date=delivery_date;
        this.employee = employee;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Boolean getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Boolean order_status) {
        this.order_status = order_status;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }
    
}
