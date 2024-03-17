
package model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


public class Cart {
    private User customer;
    private Map<Laptop, Date>map;

    public Cart() {
    }

    public Cart(User customer, Map<Laptop, Date> map) {
        this.customer = customer;
        this.map = map;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Map<Laptop, Date> getMap() {
        return map;
    }

    public void setMap(Map<Laptop, Date> map) {
        this.map = map;
    }
   
    public static void main(String[] args) {
        
    }
}
