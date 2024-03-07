<%-- 
    Document   : register
    Created on : Mar 7, 2024, 7:25:14 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/boostrap/css/bootstrap.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/boostrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
    </head>
    <body>
        <section class="vh-100 bg-image"
                 style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
            <div class="mask d-flex align-items-center h-100 gradient-custom-3">
                <div class="container h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                            <div class="card" style="border-radius: 15px;">
                                <div class="card-body p-5">
                                    <h2 class="text-uppercase text-center mb-5">Create an account</h2>

                                    <form action="${pageContext.request.contextPath}/Register" method="post">
                                        <div class="row">
                                            <div class="form-outline mb-4 col-md-6">
                                                <input type="text" id="firstName_reg" name="firstName" class="form-control form-control-lg" value="${requestScope.firstName}" required />  
                                                <label class="form-label cursor_pointer" for="firstName_reg">First Name</label>
                                            </div>
                                            <div class="form-outline mb-4 col-md-6">
                                                <input type="text" id="lastName_reg" name="lastName" class="form-control form-control-lg" value="${requestScope.lastName}" required/>
                                                <label class="form-label cursor_pointer" for="lastName_reg">Last Name</label>
                                            </div>
                                        </div>
                                        
                                        <div class="form-outline mb-4">
                                            <input type="text" id="address_reg" name="address" class="form-control form-control-lg" value="${requestScope.address}" required/>
                                            <label class="form-label cursor_pointer" for="address_reg">Address</label>
                                        </div>
                                        
                                        <div class="form-outline mb-4">
                                            <input type="email" id="email_reg" name="email" class="form-control form-control-lg" value="${requestScope.email}" required/>
                                            <p class="color_of_error">${requestScope.email_error}</p>
                                            <label class="form-label cursor_pointer" for="email_reg">Email</label>
                                        </div>

                                        <div class="form-outline mb-4">
                                            <input type="text" id="phone_reg" name="phone" class="form-control form-control-lg" value="${requestScope.phone}" required/>
                                            <p class="color_of_error">${requestScope.phone_error}</p>
                                            <label class="form-label cursor_pointer" for="email_reg">Phone</label>
                                        </div>


                                        <div class="form-outline mb-4">
                                            <input type="password" id="password_re"name="password" class="form-control form-control-lg" value="${requestScope.password}" required />
                                            <label class="form-label cursor_pointer" for="password_re">Password</label>
                                        </div>
                                        <div class="row"></div>
                                        <div class="form-outline mb-4">
                                            <input type="password" id="pass_cof_re" name="passConfirm" class="form-control form-control-lg" value="passConfirm" required/>
                                            <p class="color_of_error">${requestScope.passConfi_error}</p>
                                            <label class="form-label cursor_pointer" for="pass_cof_re">Confirm password</label>
                                        </div>

                                        <div class="mb-4 form_confirm">
                                            <input type="checkbox" value="" id="form2Example3cg" class="cursor_pointer" required/>
                                            <label for="form2Example3g" class="form_confirm_stmt">
                                                I agree all statements
                                            </label>
                                        </div>

                                        <div class="d-flex justify-content-center">
                                            <button type="submit"
                                                    class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
                                        </div>

                                        <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="#!"
                                                                                                                class="fw-bold text-body"><u>Login here</u></a></p>

                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
