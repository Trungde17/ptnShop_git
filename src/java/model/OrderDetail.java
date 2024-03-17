
package model;

import java.util.ArrayList;




public class OrderDetail {
    private Order order;
    private ArrayList<Laptop>listLaptopOrder;

    public OrderDetail() {
    }

    public OrderDetail(Order order, ArrayList<Laptop> listLaptopOrder) {
        this.order = order;
        this.listLaptopOrder = listLaptopOrder;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ArrayList<Laptop> getListLaptopOrder() {
        return listLaptopOrder;
    }

    public void setListLaptopOrder(ArrayList<Laptop> listLaptopOrder) {
        this.listLaptopOrder = listLaptopOrder;
    }
    
    
}
