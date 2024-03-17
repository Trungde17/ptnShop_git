/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAO.CartDAO;
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
import java.util.LinkedHashMap;
import model.Cart;
import model.Laptop;
import model.User;

/**
 *
 * @author PC
 */
@WebServlet(name="AddCart", urlPatterns={"/addcart"})
public class AddCart extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session=request.getSession();
        Laptop laptop=(Laptop)session.getAttribute("laptopToAddCart");
        if(laptop!=null){
            User user=(User)session.getAttribute("user");
            Cart cart=(Cart)session.getAttribute("cart");
            if(cart==null){
                cart=new Cart(user, new LinkedHashMap<>());
            }
            CartDAO.insert(user.getUser_id(), laptop.getLaptop_id());
            cart.getMap().put(laptop, new Date());
        }
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/cart/cart.jsp");
        rd.forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
