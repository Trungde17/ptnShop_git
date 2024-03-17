/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Cart;
import model.Laptop;

/**
 *
 * @author PC
 */
@WebServlet(name = "CreateLaptopForOrder", urlPatterns = {"/createlaptopfororder"})
public class CreateLaptopForOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        ArrayList<Laptop> laptopListForOrder = new ArrayList<>();
        if (action.equalsIgnoreCase("cart")) {
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart != null) {                
                for (Laptop laptop : cart.getMap().keySet()) {
                    laptopListForOrder.add(laptop);
                }
                
            }
        }
        else if(action.equalsIgnoreCase("buyOne")){
            Laptop laptopBuyOne=(Laptop)session.getAttribute("laptopBuyOne");
            if(laptopBuyOne!=null)laptopListForOrder.add(laptopBuyOne);
        }
        request.setAttribute("action", action);
        session.setAttribute("laptopListOrder", laptopListForOrder);
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/order/order_confirm.jsp");
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
