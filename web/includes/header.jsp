<%-- 
    Document   : header
    Created on : Mar 2, 2024, 6:54:38 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PTN SHOP</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/boostrap/css/bootstrap.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/boostrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/icon/themify-icons/themify-icons.css"/>      
        <script src="${pageContext.request.contextPath}/js/myCode.js"></script>
    </head>
    <body>
        <header id="header">
            <!-- Phần header 1 -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <!-- logo -->
                <a class="navbar-brand" href="#">PTN SHOP</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <!-- tìm kiếm-->
                <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
                <!-- nav-->
                <ul class="navbar-nav">
                    <li class="nav-item nav_component">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item nav_component">
                        <a class="nav-link" href="#">About</a>
                    </li>
                    <li class="nav-item nav_component">
                        <a class="nav-link" href="#">Product</a>
                    </li>
                    <li class="nav-item nav_component">
                        <a class="nav-link" href="#">Cart</a>
                    </li>
                    <li class="nav-item nav_component">
                        <a class="nav-link" href="#">Buy</a>
                    </li>
                    <c:set var="user" value="${sessionScope.user}"/>
                    <c:if test="${user eq null}">
                        <li class="nav-item">
                            <p class="nav-link cursor_pointer" onclick="openLoginAndRegister()">Login</p>
                        </li>
                    </c:if>
                    <c:if test="${user ne null}">
                        <!--người dùng-->
                        <li class="nav-item" id="user_header">
                            <p class="nav-link user_header">${user.getFirst_name()}</p>
                            <form action="${pageContext.request.contextPath}/HomeController">
                                <input type="submit" class="cursor_pointer" name="action" value="Logout" id="logout_header">
                            </form>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </header>  
        <!--Phần chọn đăng nhập hay đăng kí-->
        <div id="modal_access">

            <div id="login_and_regist" class="border log_and_reg_js">
                <button type="button" class="btn-close ti-close close_button cursor_pointer" aria-label="Close" onclick="closeLoginAndRegister()"></button>
                <form action="${pageContext.request.contextPath}/HomeController">
                    <button type="submit" name="action" value="login" class="btn btn-primary btn-lg login_button">Login</button>
                </form>

                <form action="${pageContext.request.contextPath}/HomeController">
                    <button type="submit" name="action" value="register" class="btn btn-secondary btn-lg">Register</button>
                </form>
            </div>
        </div>



