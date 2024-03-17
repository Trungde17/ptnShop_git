
package controller;

import DAO.LaptopDB;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Laptop;


@WebServlet(name="Search", urlPatterns={"/search"})
public class Search extends HttpServlet {     

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String searchContent=request.getParameter("searchContent");
        ArrayList<Laptop>list=LaptopDB.searchBaseName(searchContent);
        request.setAttribute("LaptopListSearch", list);
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/search/search.jsp");
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
