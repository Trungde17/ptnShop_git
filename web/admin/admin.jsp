<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css"/>
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/vendor.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/boostrap/css/bootstrap.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/boostrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/icon/themify-icons/themify-icons.css"/>      
        
        <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="${pageContext.request.contextPath}/js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="${pageContext.request.contextPath}/vendor/chart.js/Chart.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="${pageContext.request.contextPath}/js/demo/chart-area-demo.js"></script>
        <script src="${pageContext.request.contextPath}/js/demo/chart-pie-demo.js"></script>
        <script src="${pageContext.request.contextPath}/js/demo/chart-bar-demo.js"></script>
        <title>Document</title>
    </head>
    <body>
        <div id="wrapper">
            <!-- Ph?n header 1 -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                   
                    <div class="sidebar-brand-text mx-3">PTN Admin</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/admin.jsp">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->


                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/insertEmployee.jsp">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>Add new Employee</span></a>
                </li>

                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/employeeList.jsp">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>List Of Employee</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/orderList.jsp">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>List Of Order</span></a>
                </li>

                <!-- Nav Item - Charts -->
                
            </ul>

            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Search -->


                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">



                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">

                            <c:set var="user" value="${sessionScope.user}"/>
                            <li class="nav-item" id="user_header">
                                <p class="nav-link user_header">${user.getFirst_name()}</p>
                                <form action="${pageContext.request.contextPath}/HomeController">
                                    <input type="submit" class="cursor_pointer" name="action" value="Logout" id="logout_header">
                                </form>
                            </li>          
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">


                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->


            </div>
            <!-- End of Content Wrapper -->
        </div>
    </body>
</html>