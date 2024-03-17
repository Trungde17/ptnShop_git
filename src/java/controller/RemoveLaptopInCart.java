
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
import model.Cart;

import model.Laptop;
import model.User;


@WebServlet(name="RemoveLaptopInCart", urlPatterns={"/removelaptopincart"})
public class RemoveLaptopInCart extends HttpServlet {
   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        String laptop_id=request.getParameter("laptop_id");
        CartDAO.delete(user.getUser_id(), laptop_id);
        Laptop laptop=new Laptop();
        laptop.setLaptop_id(laptop_id);
        Cart cart=(Cart)session.getAttribute("cart");
        cart.getMap().remove(laptop);
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/cart/cart.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
