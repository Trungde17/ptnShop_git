<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/boostrap/css/bootstrap.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/boostrap/css/bootstrap.min.css"/>
        <script src="${pageContext.request.contextPath}/js/myCode.js"></script>
    </head>
    <body>       
        <!-- content -->
        <c:set var="url" value="${pageContext.request.contextPath}/order/order_confirm.jsp"/>
        <c:set var="list" value="${sessionScope.laptop_list}" scope="page"/>      
        
        <c:set var="index" value="${param.index}"/>
        <c:set var="laptop" value="${list.get(index)}" scope="page" />     
        <section class="py-5">
            <div class="container">
                <div class="row gx-5">
                    <aside class="col-lg-6">
                        <div class="border rounded-4 mb-3 d-flex justify-content-center">
                            <a data-fslightbox="mygalley" class="rounded-4" target="_blank" data-type="image" href="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big.webp">
                                <img style="max-width: 100%; max-height: 100vh; margin: auto;" class="rounded-4 fit" src="${pageContext.request.contextPath}/img/${laptop.getLaptop_img()}/1.jpg" />                            
                            </a>
                        </div>
                        <div class="d-flex justify-content-center mb-3">
                            <a data-fslightbox="mygalley" class="border mx-1 rounded-2" target="_blank" data-type="image" href="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big1.webp" class="item-thumb">
                                <img width="60" height="60" class="rounded-2" src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big1.webp" />
                            </a>
                            <a data-fslightbox="mygalley" class="border mx-1 rounded-2" target="_blank" data-type="image" href="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big2.webp" class="item-thumb">
                                <img width="60" height="60" class="rounded-2" src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big2.webp" />
                            </a>
                            <a data-fslightbox="mygalley" class="border mx-1 rounded-2" target="_blank" data-type="image" href="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big3.webp" class="item-thumb">
                                <img width="60" height="60" class="rounded-2" src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big3.webp" />
                            </a>
                            <a data-fslightbox="mygalley" class="border mx-1 rounded-2" target="_blank" data-type="image" href="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big4.webp" class="item-thumb">
                                <img width="60" height="60" class="rounded-2" src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big4.webp" />
                            </a>
                            <a data-fslightbox="mygalley" class="border mx-1 rounded-2" target="_blank" data-type="image" href="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big.webp" class="item-thumb">
                                <img width="60" height="60" class="rounded-2" src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big.webp" />
                            </a>
                        </div>
                        <!-- thumbs-wrap.// -->
                        <!-- gallery-wrap .end// -->
                    </aside>
                    <main class="col-lg-6">
                        <div class="ps-lg-3">
                            <h4 class="title text-dark">
                                ${laptop.getLaptop_name()}${index}
                            </h4>
                            <div class="d-flex flex-row my-3">
                                <div class="text-warning mb-1 me-2">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fas fa-star-half-alt"></i>
                                    
                                </div>
                                
                            </div>

                            <div class="mb-3">
                                <span class="h5">${laptop.getSelling_price()}$</span>
                            </div>

                            <p>
                                ${laptop.getDescribe()} 
                            </p>

                            <div class="row">                               
                                <dt class="col-3">Color</dt>
                                <dd class="col-9">${laptop.getColor()}</dd>

                                <dt class="col-3">Material</dt>
                                <dd class="col-9">${laptop.getSpecification().getMaterial()}</dd>

                                <dt class="col-3">Brand</dt>
                                <dd class="col-9">${laptop.getBrand()}</dd>
                                
                                <dt class="col-3">Origin</dt>
                                <dd class="col-9">${laptop.getSpecification().getOrigin()}</dd>
                            </div>

                            <hr />

                            
                            <button href="" class="btn btn-warning shadow-0" onclick="redirectToJSPPageWithPara('${url}', 'index', '${index}')"> Buy now </button>
                            <button href="" class="btn btn-primary shadow-0"> <i class="me-1 fa fa-shopping-basket"></i> Add to cart </button>                            
                        </div>
                    </main>
                </div>
            </div>
        </section>
        <!-- content -->

        <section class="bg-light border-top py-4">
            <div class="container">
                <div class="row gx-4">
                    <div class="col-lg-8 mb-4">
                        <div class="border rounded-2 px-3 py-2 bg-white">
                            <!-- Pills navs -->
                            <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                                <li class="nav-item d-flex" role="presentation">
                                    <p class="nav-link d-flex align-items-center justify-content-center w-100 active" id="ex1-tab-1" data-mdb-toggle="pill" href="#ex1-pills-1" role="tab" aria-controls="ex1-pills-1" aria-selected="true">SPECIFICATION</p>
                                </li>              
                            </ul>
                            <!-- Pills navs -->

                            <!-- Pills content -->
                            <div class="tab-content" id="ex1-content">
                                <div class="tab-pane fade show active" id="ex1-pills-1" role="tabpanel" aria-labelledby="ex1-tab-1">
                                   
                                    <table class="table border mt-3 mb-2">
                                        <tr>
                                            <th class="py-2">Screen:</th>
                                            <td class="py-2">${laptop.getSpecification().getScreen()}</td>
                                        </tr>
                                        <tr>
                                            <th class="py-2">CPU:</th>
                                            <td class="py-2">${laptop.getSpecification().getCpu()}</td>
                                        </tr>
                                        <tr>
                                            <th class="py-2">Ram:</th>
                                            <td class="py-2">${laptop.getSpecification().getRam()}</td>
                                        </tr>
                                        <tr>
                                            <th class="py-2">Hard Drive:</th>
                                            <td class="py-2">${laptop.getSpecification().getHard_drive()}</td>
                                        </tr>
                                        <tr>
                                            <th class="py-2">Graphics:</th>
                                            <td class="py-2">${laptop.getSpecification().getGraphics()}</td>
                                        </tr>
                                        <tr>
                                            <th class="py-2">Operating System:</th>
                                            <td class="py-2">${laptop.getSpecification().getOs()}</td>
                                        </tr>
                                        <tr>
                                            <th class="py-2">Weight:</th>
                                            <td class="py-2">${laptop.getSpecification().getWeight()}</td>
                                        </tr>
                                        <tr>
                                            <th class="py-2">Size:</th>
                                            <td class="py-2">${laptop.getSpecification().getSize()}</td>
                                        </tr>
                                        <tr>
                                            <th class="py-2">Origin:</th>
                                            <td class="py-2">${laptop.getSpecification().getOrigin()}</td>
                                        </tr>
                                        <tr>
                                            <th class="py-2">Launch Year:</th>
                                            <td class="py-2">${laptop.getSpecification().getLaunch_year()}</td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="tab-pane fade mb-2" id="ex1-pills-2" role="tabpanel" aria-labelledby="ex1-tab-2">
                                    
                                </div>
                                <div class="tab-pane fade mb-2" id="ex1-pills-3" role="tabpanel" aria-labelledby="ex1-tab-3">
                                    
                                </div>
                                <div class="tab-pane fade mb-2" id="ex1-pills-4" role="tabpanel" aria-labelledby="ex1-tab-4">
                                    
                                </div>
                            </div>
                            <!-- Pills content -->
                        </div>
                    </div>                    
                </div>
            </div>
        </section>       
    </body>
</html>
