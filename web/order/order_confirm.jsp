<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@include file="../includes/header.jsp" %>      
<!-- content -->

<div class="container mt-5">
    <c:set var="laptopListOrder" value="${sessionScope.laptopListOrder}"/>
    <c:set var="user" value="${sessionScope.user}" />
    <c:set var="totalAmount" value="${0}"/>
    <c:set var="action" value="${requestScope.action}"/>
    <div class="card">
        <div class="card-header">
            <h5 class="card-title">Order</h5>
        </div>
        <div class="card-body">
            <div class="row">
                <div class="col-md-6">
                    <h6>Name: <span class="text-muted">${user.getFullName()}</span></h6>
                    <h6>Phone: <span class="text-muted">${user.getPhone()}</span></h6>
                    <h6>Address: <span class="text-muted">${user.getAddress()}</span></h6>
                        <%
                            SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
                            String currentDate=sdf.format(new Date());
                        %>                        
                    <h6>Order date: <span class="text-muted"><%=currentDate%></span></h6>
                        <%
                            Date deliveryDate=new Date();
                            deliveryDate.setDate(deliveryDate.getDate()+5);
                            String formattedDeliveryDate=new SimpleDateFormat("yyyy/MM/dd").format(deliveryDate);
                        %>
                    <h6>Delivery date: <span class="text-muted"><%=formattedDeliveryDate%></span></h6>
                </div>                           
            </div>

            <hr>

            <h5 class="card-title">${laptopListOrder.size()} items</h5>
            <c:set var="i" value="${1}"/>
            
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Product</th> 
                            <th scope="col">ID</th>
                            <th scope="col">Price</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="laptopBuy" items="${laptopListOrder}">
                        <tr>
                            <th scope="row">${i}</th>
                            <td>${laptopBuy.getLaptop_name()}</td>
                            <td>${laptopBuy.getLaptop_id()}</td>
                            <td>${laptopBuy.getSelling_price()}$</td>
                        </tr>
                        <c:set var="i" value="${i+1}"/>
                        <c:set var="totalAmount" value="${totalAmount+laptopBuy.getSelling_price()}"/>
                    </c:forEach>
                    <!-- Add more rows as needed -->
                </tbody>
            </table>
            <p>Delivery charge: 5$</p>

            <hr>

            <div class="text-md-right">
                <h5>Total: <span class="text-success">${totalAmount+5}$</span></h5>
            </div>
        </div>
        <div class="mt-3 mb-3 d-flex justify-content-center">
            <button class="btn btn-info btn-lg" onclick="redirectToJSPPageWithPara('${pageContext.request.contextPath}/order_controll', 'action', '${action}')">Confirm</button>
        </div>
    </div>             

</div>
<%@include file="../includes/footer.jsp" %>
</body>

</html>



