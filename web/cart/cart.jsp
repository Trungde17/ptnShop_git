<%-- 
    Document   : cart
    Created on : Mar 15, 2024, 4:19:29 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/boostrap/css/bootstrap.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/boostrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/icon/themify-icons/themify-icons.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cart.css"/>
        <script src="${pageContext.request.contextPath}/js/myCode.js"></script>
        <title>Cart</title>
    </head>
    <body>

        <c:set var="cart" value="${sessionScope.cart}"/>
        <section class="h-100 h-custom" style="background-color: #eee;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col">                        
                        <div class="card" id="cart-form">
                            <a href="${pageContext.request.contextPath}/index.jsp" class="text-body card-back"><i
                                    class="fas ti-arrow-left me-2"></i></a>
                            <div class="card-body p-4">
                                <div class="cart-title">                                                         
                                    <h2 style="color: #28a745;">SHOPPING CART</h2>                                     
                                </div>
                                <hr>
                                <div class="d-flex justify-content-between align-items-center mb-4">
                                    <c:set var="numberItem" value="${0}"/>
                                    <c:if test="${cart!=null}">
                                        <c:set var="numberItem" value="${cart.getMap().size()}"/>
                                    </c:if>
                                    <div>
                                        <p class="mb-0">You have ${numberItem} items in your cart</p>
                                    </div>                                            
                                </div>
                                <c:forEach var="entry" items="${cart.getMap()}">
                                    <c:set var="laptop" value="${entry.key}"/>

                                    <div class="card mb-3 mb-lg-0">
                                        <div class="card-body">
                                            <div class="d-flex justify-content-between">
                                                <div class="d-flex flex-row align-items-center">
                                                    <div>
                                                        <img
                                                            src="${pageContext.request.contextPath}/img/${laptop.getLaptop_img()}/1.jpg"
                                                            class="img-fluid rounded-3" alt="Shopping item" style="width: 65px;">
                                                    </div>
                                                    <div class="ms-3 ml-3">
                                                        <h5>${laptop.getLaptop_name()}</h5>
                                                        <p class="small mb-0">${laptop.getSpecification().getHard_drive()}, ${laptop.getSpecification().getRam()}</p>
                                                    </div>
                                                </div>
                                                <div class="d-flex flex-row align-items-center">                                
                                                    <div style="width: 80px;">
                                                        <h5 class="mb-0">$${laptop.getSelling_price()}</h5>
                                                    </div>
                                                    <form method="POST" action="${pageContext.request.contextPath}/removelaptopincart">

                                                        <button class="delete-laptop" name="laptop_id" value="${laptop.getLaptop_id()}" type="submit" style="color: #000;"><i class="ti-trash"></i></button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <c:if test="${cart!=null}">
                                <button class="btn btn-warning shadow-0 buy-cart" onclick="redirectToJSPPage('${pageContext.request.contextPath}/createlaptopfororder?action=cart')">BUY NOW</button>
                            </c:if>
                        </div>


                    </div>

                </div>

            </div>                
        </section>
    </body>
</html>
