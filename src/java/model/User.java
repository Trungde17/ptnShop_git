
package model;

import java.util.Date;
import java.util.Objects;


public class User {
    private String user_id;
    private Boolean user_type;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String address;
    private String phone;
    private Date registration_date;

    public User() {
    }

    public User(String user_id, Boolean user_type, String first_name, String last_name, String email, String password,String address, String phone, Date registration_date) {
        this.user_id = user_id;
        this.user_type = user_type;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.address=address;
        this.phone = phone;
        this.registration_date = registration_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Boolean getUser_type() {
        return user_type;
    }

    public void setUser_type(Boolean user_type) {
        this.user_type = user_type;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        final User other = (User) obj;
        return Objects.equals(this.user_id, other.user_id);
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", user_type=" + user_type + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", password=" + password + ", address=" + address + ", phone=" + phone + ", registration_date=" + registration_date + '}';
    }

    

    
    
}
