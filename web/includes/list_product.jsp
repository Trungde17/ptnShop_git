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
<%@page import="DAO.LaptopDB" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Laptop"%>

<!DOCTYPE html>
<html>
</script
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
    <script src="${pageContext.request.contextPath}/js/myCode.js"></script>

</head>
<body>
    <%  
        LaptopDB laptopDB = new LaptopDB();
        ArrayList<Laptop> laptop_list = laptopDB.getAllAvailableLaptop();
        session.setAttribute("laptop_list", laptop_list);        
    %>

    <section style="background-color: #eee;">
        <c:set var="url" value="${pageContext.request.contextPath}/product/product_detail.jsp"/>
        <div class="container py-5">
            <a class="laptop_title">
                <h1>Laptop</h1>
            </a>
            <!-- initialize variable index for assigning bootst rap on proper tag-->
            <c:set var="index" value="${0}" scope="page"/>  

            <!-- initialize a String[] for store 3 bootstrap class -->
            <c:set var="bootstrap" value="${['col-md-12 col-lg-4 mb-4 mb-lg-0', 'col-md-6 col-lg-4 mb-4 mb-md-0', 'col-md-6 col-lg-4 mb-4 mb-md-0']}"/>

            <!-- store the product list into session -->
            <c:set var="laptop_list" value="${laptop_list}" scope="session"/>
            <div class="row">
                <c:set var="i" value="${0}"/>
                <!-- loop for writing all product in product list -->
                <c:forEach items="${laptop_list}" var="laptop" >
                    <!-- if there have been 3 cards on the line, then re-assigning index and getting downn the line -->
                    <c:if test="${index==3}">
                        <c:set var="index" value="${0}" scope="page"></c:set>
                    </c:if>

                    <!-- assigning proper bootstrap for this tag -->
                    <div class="${bootstrap[index]}">

                        <!-- index plus -->
                        <c:set var="index" value="${index+1}" scope="page"></c:set>   

                            <div class="card laptop cursor_pointer" style="text-decoration: none" onclick="redirectToJSPPageWithPara('${url}','index','${i}')">
                            <c:set var="i" value="${i+1}"/>
                            <div class="d-flex justify-content-between p-3">
                                
                                
                            </div>

                            <img src="${pageContext.request.contextPath}/img/${laptop.getLaptop_img()}/1.jpg" 
                                 class="card-img-top" alt="Laptop" />
                            <div class="card-body">

                                <div class="d-flex justify-content-between mb-3">
                                    <h5 class="mb-0"><c:out value="${laptop.getLaptop_name()}"/></h5>
                                    <h5 class="text-dark mb-0"><c:out value="${laptop.selling_price}$"/></h5>
                                </div>

                                <div class="d-flex justify-content-between mb-2">


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
                        </div>
                    </div>
                </c:forEach>  
            </div>
        </div>
    </section>
</body>
</html>
