
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
import model.User;

@WebServlet(name = "LoginControll", urlPatterns = {"/LoginControll"})
public class LoginControll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean isError=false;
            
               
        String email=request.getParameter("email");
        String passowrd=request.getParameter("password");
        String user_type=request.getParameter("user_type");       
        if(!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")){
            request.setAttribute("errorEmail", "Not email");
            isError=true;
        }
        else{
            Boolean cont=false;
            if(user_type.equalsIgnoreCase("em"))cont=true;
            
            User user=UserDAO.getUser(email, passowrd, cont);
            if(user==null){
                request.setAttribute("errorAccount", "Email or password is incorrect");
                isError=true;
            }
            else{
                HttpSession session=request.getSession();
                session.setAttribute("user", user);
            }
            
        }  
        request.setAttribute("email", email);
        request.setAttribute("user_type", user_type);
        String url="/index.jsp";
        if(isError)url="/access/login.jsp";
        RequestDispatcher rd=getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    public static void main(String[] args) {
        System.out.println("tanchun2003@gmail.com".matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"));
    }
}
