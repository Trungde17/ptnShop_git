<%-- 
    Document   : list_product
    Created on : Mar 8, 2024, 8:28:18 PM
    Author     : tinyl
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib  prefix ="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="jakarta.servlet.http.HttpSession"%>

<!DOCTYPE html>
<html>
    </script
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <sql:setDataSource driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;databaseName=ptn_shop;encrypt=false;trustServerCertificate=false;loginTimeout=30;"
                           user="sa" password="nam123" var="con"/>
        <sql:query dataSource="${con}" var="rs">Select * from Laptop</sql:query>
        
        <section style="background-color: #eee;">
            <div class="container py-5">
                
            <!-- initialize variable index for assigning bootstrap on proper tag-->
            <c:set var="index" value="${0}" scope="page"/>  
            
            <!-- initialize a String[] for store 3 bootstrap class -->
            <c:set var="bootstrap" value="${['col-md-12 col-lg-4 mb-4 mb-lg-0', 'col-md-6 col-lg-4 mb-4 mb-md-0', 'col-md-6 col-lg-4 mb-4 mb-md-0']}"/>
            
            <!-- store the product list into session -->
            <c:set var="product_list" value="${rs.rows}" scope="session"/>
            <div class="row">
            <!-- loop for writing all product in product list -->
            <c:forEach items="${product_list}" var="laptop" >
                <!-- if there have been 3 cards on the line, then re-assigning index and getting downn the line -->
                    <c:if test="${index==3}">
                    <c:set var="index" value="${0}" scope="page"></c:set>
                    </c:if>
                
                <!-- assigning proper bootstrap for this tag -->
                    <div class="${bootstrap[index]}">
                        
                        <!-- index plus -->
                        <c:set var="index" value="${index+1}" scope="page"></c:set>   
                            
                            <!-- go to laptopDetail.jsp -->
                            <a class="card" style="text-decoration: none" href="includes/test.jsp?laptop_id=${laptop.laptop_id}">
                            
                            
                            <div class="d-flex justify-content-between p-3">
                                <p class="lead mb-0">Today's Combo Offer</p>
                                <div
                                    class="bg-info rounded-circle d-flex align-items-center justify-content-center shadow-1-strong"
                                    style="width: 35px; height: 35px;">
                                    <p class="text-white mb-0 small">x4</p>
                                </div>
                            </div>
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/Horizontal/E-commerce/Products/4.webp"
                                 class="card-img-top" alt="Laptop" />
                            <div class="card-body">
                             
                                <div class="d-flex justify-content-between mb-3">
                                    <h5 class="mb-0"><c:out value="${laptop.laptop_name}"/></h5>
                                <h5 class="text-dark mb-0"><c:out value="${laptop.selling_price}"/></h5>
                                </div>

                                <div class="d-flex justify-content-between mb-2">
                                            <p class="text-muted mb-0">Available: <span class="fw-bold">
                                        <sql:query dataSource="${con}" var="rs">select dbo.getAmountOfLaptopName('${laptop.laptop_name}') as count</sql:query>
                                        <c:out value="${rs.rows[0].count}"></c:out>
                                        </span></p>
                                    <div class="ms-auto text-warning">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>  
            </div>
        </section>
    </body>
</html>
