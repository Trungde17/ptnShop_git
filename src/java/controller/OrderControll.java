/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CartDAO;
import DAO.LaptopDB;
import DAO.OrderDAO;
import DAO.OrderDetailDAO;
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
import java.util.ArrayList;
import java.util.Date;
import model.Laptop;
import model.Order;
import model.OrderDetail;
import model.User;

/**
 *
 * @author PC
 */
@WebServlet(name = "OrderControll", urlPatterns = {"/order_controll"})
public class OrderControll extends HttpServlet {

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
        String url="/order/success_order.jsp";
        
        String action=request.getParameter("action");
        HttpSession session = request.getSession();
        User userBuy = (User) session.getAttribute("user");
        String order_id="order"+(OrderDAO.countOrder()+1);
        Date deliveryDate = new Date();
        deliveryDate.setDate(deliveryDate.getDate()+ 5);
        User employee=UserDAO.getUser("user_id", "user2");
        Order order=new Order(order_id, userBuy, false, new Date(), deliveryDate, employee);
        ArrayList<Laptop>listBuy=(ArrayList<Laptop>)session.getAttribute("laptopListOrder");
        try {            
                if(OrderDAO.insert(order)==0)throw new Exception();                
                OrderDetail od=new OrderDetail(order, listBuy);
                if(OrderDetailDAO.insert(od)==0)throw new Exception();
                if(action.equalsIgnoreCase("cart")){
                    session.setAttribute("cart", null);
                    CartDAO.deleteAll();
                    session.setAttribute("laptopListOrder", null);
                }
        } catch (Exception e) {
            url="/order/fail_order";
        }
        LaptopDB.changeStatusOfBuyLaptops(listBuy);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);

        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
