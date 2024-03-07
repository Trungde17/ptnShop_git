/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.UserDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import model.User;

@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Boolean error = false;
        String email_error = "";
        String phone_error = "";
        String passConfi_error = "";
        String url = "/access/register.jsp";
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address=request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String passConfi = request.getParameter("passConfirm");
        
        
        if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            email_error="Not email";
            error=true;
        }
        if(!phone.matches("\\d+")){
            phone_error="Not phone";
            error=true;
        }
        
        if(email_error.equals("")){
            User u = UserDAO.getUser("email", email);
            if(u!=null){
                email_error="Email has been registered";
                error=true;
            }
        }
        if(phone_error.equals("")){
            User u = UserDAO.getUser("phone", phone);
            if(u!=null){
                phone_error="Phone has been registered";
                error=true;
            }
        }
        
        if(!passConfi.equals(password)){
            passConfi_error="Password does not match";
            error=true;
        }
        if(!error){
            String user_id="user"+UserDAO.countUser()+1;
            User user=new User(user_id, false, firstName, lastName, email, password, address, phone, new Date());
            if(UserDAO.insert(user)==0){
                error=true;               
                request.setAttribute("register_fail", "Registration failed!");
            }
            else{
                url="/index.jsp";
                HttpSession session=request.getSession();
                session.setAttribute("user", user);
            }
        }
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("address", address);
        request.setAttribute("email", email);
        request.setAttribute("phone", phone);
        request.setAttribute("password", password);
        request.setAttribute("passConfirm", passConfi);
        
        request.setAttribute("email_error", email_error);
        request.setAttribute("phone_error", phone_error);
        request.setAttribute("passConfi_error", passConfi_error);
        RequestDispatcher rd=getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    public static void main(String[] args) {
        System.out.println("haiPhamKK2@d".matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"));
    }
}
