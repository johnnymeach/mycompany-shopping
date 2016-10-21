<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>AmazonShopping.com</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
    
    <script src="./resources/js/jquery-1.12.3.min.js"></script>
    
    <script src="./resources/js/bootstrap.js"></script>

</head>

<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="/amazonshopping" class="navbar-brand">AmazonShopping.com</a>
            </div>
            
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/amazonshopping/home">Home</a></li>
                    <li><a href="#">Contact Us</a></li>
                    <li><a href="login">User Login</a></li>
                    <li><a href="buyerRegister">Register</a></li>

                </ul>
            
        </div>
    </nav>

    <aside class="col-md-4">
        <div class="col-md-10 col-md-offset-1">
            <div class="list-group">
                <a href="product" class="list-group-item" style="padding:0; margin:0;">
                    <div class="col-md-3" style="padding:0; margin:0;"><img src="./resources/images/product_image/applewatch.png" style="width:70px;height:62px"></div>
                    <div class="col-md-9">
                        <div class="list-group-item-heading">
                            <h4 class="pull-right">$350</h4>
                            <h4 class="pull-left">Apple Watch</h4>
                            <div class="clearfix"></div>
                        </div>
                        <p class="list-group-item-text">
                            If you wanna try out the latest versions of the iPhone, and the Apple Watch; Grover can help you out!
                        </p>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>


            <div class="list-group">
                <a href="product" class="list-group-item" style="padding:0; margin:0;">
                    <div class="col-md-3" style="padding:0; margin:0;"><img src="./resources/images/product2.jpg" style="width:70px;height:62px"></div>
                    <div class="col-md-9">
                        <div class="list-group-item-heading">
                            <h4 class="pull-right">$350</h4>
                            <h4 class="pull-left">iPhone</h4>
                            <div class="clearfix"></div>
                        </div>
                        <p class="list-group-item-text">
                            If you wanna try out the latest versions of the iPhone, and the Apple Watch; Grover can help you out!
                        </p>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>

            <!-- <div class="list-group">
                <a href="product" class="list-group-item" style="padding:0; margin:0;">
                    <div class="col-md-3" style="padding:0; margin:0;"><img src="./resources/images/product2.jpg" style="width:70px;height:62px"></div>
                    <div class="col-md-9">
                        <div class="list-group-item-heading">
                            <h4 class="pull-right">$650</h4>
                            <h4 class="pull-left">iPhone</h4>
                            <div class="clearfix"></div>
                        </div>
                        <p class="list-group-item-text">
                            If you wanna try out the latest versions of the iPhone, and the Apple Watch; Grover can help you out!
                        </p>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div> -->

        </div>
    </aside>
    <header class="col-md-8" style="height:380px">
        <div class="carousel slide" data-ride="carousel" id="c1">
            <ol class="carousel-indicators">
                <li data-target="#c1" data-slide="0"></li>
                <li data-target="#c1" data-slide="1"></li>
                <li data-target="#c1" data-slide="2"></li>
                <li data-target="#c1" data-slide="3"></li>
            </ol>
            <div class="carousel-inner">
                <div class="item active">
                    <img src="./resources/images/nike_shoes.jpg" height="380px" width="400px">
                    <!-- <div class="carousel-caption">
                        <h4>Nike Shoes</h4>
                        <p>This is a good pair of the Nike shoes for men</p>
                    </div> -->
                </div>

                <div class="item">
                    <img src="./resources/images/iphone7.jpg" height="380px" width="400px">
                    <!-- <div class="carousel-caption">
                        <h4>iPhone 7</h4>
                        <p>A new release iPhone 7</p>
                    </div> -->
                </div>
                <div class="item">
                    <img src="./resources/images/laptop.jpeg" height="380px" width="400px">
                    <!-- <div class="carousel-caption">
                        <h4>Dell laptop</h4>
                        <p>This is a powerful laptop</p>
                    </div> -->
                </div>

                <div class="item">
                    <img src="./resources/images/speaker.jpg" height="380px" width="400px">                    
                </div>
            </div>

            <a href="#c1" class="left carousel-control" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <a href="#c1" class="right carousel-control" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
            </a>
        </div>
    </header>

    <div class="container">
        <div class="page-header">
            <h3 class="text-center">All Products</h3></div>
        <div class="col-md-4">
            <div class="thumbnail">
                <img src="./resources/images/product2.jpg" style="width:100%">
                <div class="caption">
                    <h4 class="pull-right">$650</h4>
                    <h4><a href="product.html">Apple Inc</a></h4>
                    <p>
                        There is nothing like a perfect smartphone. This is the largest product category in the world by volume and hence it is tough to nail what everyone wants and keep everyone happy, especially in these demanding times. So the iPhone 7 series is not perfect either, at least not at first sight. There are a lot of good things about these new phones which stand out, a good design, a great camera, and performance that will not leave you wanting. But there seem to be some areas for improvement too, given that this is still supposed to be the benchmark smartphone.</p>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="thumbnail">
                <img src="./resources/images/product2.jpg" style="width:100%">
                <div class="caption">
                    <h4 class="pull-right">$650</h4>
                    <h4><a href="product.html">Apple Inc</a></h4>
                    <p>
                        There is nothing like a perfect smartphone. This is the largest product category in the world by volume and hence it is tough to nail what everyone wants and keep everyone happy, especially in these demanding times. So the iPhone 7 series is not perfect either, at least not at first sight. There are a lot of good things about these new phones which stand out, a good design, a great camera, and performance that will not leave you wanting. But there seem to be some areas for improvement too, given that this is still supposed to be the benchmark smartphone.</p>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="thumbnail">
                <img src="./resources/images/product2.jpg" style="width:100%">
                <div class="caption">
                    <h4 class="pull-right">$650</h4>
                    <h4><a href="product.html">Apple Inc</a></h4>
                    <p>
                        There is nothing like a perfect smartphone. This is the largest product category in the world by volume and hence it is tough to nail what everyone wants and keep everyone happy, especially in these demanding times. So the iPhone 7 series is not perfect either, at least not at first sight. There are a lot of good things about these new phones which stand out, a good design, a great camera, and performance that will not leave you wanting. But there seem to be some areas for improvement too, given that this is still supposed to be the benchmark smartphone.</p>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="thumbnail">
                <img src="./resources/images/product2.jpg" style="width:100%">
                <div class="caption">
                    <h4 class="pull-right">$650</h4>
                    <h4><a href="product.html">Apple Inc</a></h4>
                    <p>
                        There is nothing like a perfect smartphone. This is the largest product category in the world by volume and hence it is tough to nail what everyone wants and keep everyone happy, especially in these demanding times. So the iPhone 7 series is not perfect either, at least not at first sight. There are a lot of good things about these new phones which stand out, a good design, a great camera, and performance that will not leave you wanting. But there seem to be some areas for improvement too, given that this is still supposed to be the benchmark smartphone.</p>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="thumbnail">
                <img src="./resources/images/product2.jpg" style="width:100%">
                <div class="caption">
                    <h4 class="pull-right">$650</h4>
                    <h4><a href="product.html">Apple Inc</a></h4>
                    <p>
                        There is nothing like a perfect smartphone. This is the largest product category in the world by volume and hence it is tough to nail what everyone wants and keep everyone happy, especially in these demanding times. So the iPhone 7 series is not perfect either, at least not at first sight. There are a lot of good things about these new phones which stand out, a good design, a great camera, and performance that will not leave you wanting. But there seem to be some areas for improvement too, given that this is still supposed to be the benchmark smartphone.</p>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="thumbnail">
                <img src="./resources/images/product2.jpg" style="width:100%">
                <div class="caption">
                    <h4 class="pull-right">$650</h4>
                    <h4><a href="product.html">Apple Inc</a></h4>
                    <p>
                        There is nothing like a perfect smartphone. This is the largest product category in the world by volume and hence it is tough to nail what everyone wants and keep everyone happy, especially in these demanding times. So the iPhone 7 series is not perfect either, at least not at first sight. There are a lot of good things about these new phones which stand out, a good design, a great camera, and performance that will not leave you wanting. But there seem to be some areas for improvement too, given that this is still supposed to be the benchmark smartphone.</p>
                </div>
            </div>
        </div>

    </div>

</body>

</html>