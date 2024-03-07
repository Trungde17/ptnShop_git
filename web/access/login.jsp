<%-- 
    Document   : login
    Created on : Mar 3, 2024, 5:20:45 PM
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>       
        <title>LOGIN</title>
    </head>
    <body>
        <div id="login">
            <section class="vh-100">
                <div class="container-fluid">
                    <div class="login_content">
                        <div class="col-sm-6 text-black">

                            <div class="px-5 ms-xl-4">
                                <i class="fas fa-crow fa-2x me-3 pt-5 mt-xl-4" style="color: #709085;"></i>
                                <span class="h1 fw-bold mb-0">PTN SHOP</span>
                            </div>

                            <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">

                                <form style="width: 23rem;" action="${pageContext.request.contextPath}/LoginControll" method="post">

                                    <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Log in</h3>
                                    <c:set var="email" value="${requestScope.email}"/>
                                    <c:set var="errorEmail" value="${requestScope.errorEmail}"/>
                                    <div class="form-outline mb-4">
                                        <input type="email" id="form2Example18" name="email" class="form-control form-control-lg" value="${email}" required />
                                        <p class="color_of_error">${errorEmail}</p>
                                        <label class="form-label" for="form2Example18">Email address</label>
                                    </div>                                      

                                    <div class="form-outline mb-4">
                                        <input type="password" id="form2Example28" name="password" class="form-control form-control-lg" required/>
                                        <label class="form-label" for="form2Example28">Password</label>
                                    </div>
                                    <c:set var="errorAccount" value="${requestScope.errorAccount}"/>
                                    <p class="color_of_error">${errorAccount}</p>

                                    <c:set var="checked" value="${requestScope.user_type}"/>
                                    <c:set var="checkedCus" value="checked"/>
                                    <c:set var="checkedEm" value=""/>
                                    <c:if test="${checked eq 'em'}" >
                                        <c:set var="checkedCus" value=""/>
                                        <c:set var="checkedEm" value="checked"/>
                                    </c:if>
                                    <div class="form-check">
                                        <input class="form-check-input square-checkbox" type="radio" name="user_type" id="customerUser" value="cus" ${checkedCus}>
                                        <label class="form-check-label" for="customerUser">
                                            Customer
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input square-checkbox" type="radio" name="user_type" id="employeeUser" value="em" ${checkedEm}>
                                        <label class="form-check-label" for="employeeUser">
                                            Employee
                                        </label>
                                    </div>


                                    <div class="pt-1 mb-4">
                                        <button class="btn btn-info btn-lg btn-block" type="submit">Login</button>
                                    </div>

                                    <p class="small mb-5 pb-lg-2"><a class="text-muted" href="#!">Forgot password?</a></p>
                                    <form>
                                        <p>Don't have an account? <button type="submit" class="link-info">Register here</button></p>
                                    </form>

                                </form>

                            </div>

                        </div>
                    </div>
                </div>
            </section>
        </div>
    </body>
</html>
