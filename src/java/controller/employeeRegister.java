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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import model.User;

/**
 *
 * @author tinyl
 */
public class employeeRegister extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet employeeRegister</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet employeeRegister at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Boolean error = false;
        String email_error = "";
        String phone_error = "";
        String passConfi_error = "";
        String url="/admin/insertEmployee.jsp";
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
        
        UserDAO userDB = new UserDAO();
        if(email_error.equals("")){
            
            User u = userDB.getUser("email", email);
            if(u!=null){
                email_error="Email has been registered";
                error=true;
            }
        }
        if(phone_error.equals("")){
            User u = userDB.getUser("phone", phone);
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
            String user_id="user"+userDB.countUser()+1;
            User user=new User(user_id, true, firstName, lastName, email, password, address, phone, new Date());
            if(userDB.insert(user)==0){
                error=true;               
                request.setAttribute("register_fail", "Registration failed!");
            }
            else{
                request.setAttribute("success", "dang_ky_thanh_cong");
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
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
