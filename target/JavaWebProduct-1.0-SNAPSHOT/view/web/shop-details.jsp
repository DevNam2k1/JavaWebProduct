<%-- 
    Document   : shop-details
    Created on : Nov 17, 2021, 3:26:31 PM
    Author     : laptop88
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../header.jsp" %>
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>All departments</span>
                        </div>
                        <ul>
                            <li><a href="#">Fresh Meat</a></li>
                            <li><a href="#">Vegetables</a></li>
                            <li><a href="#">Fruit & Nut Gifts</a></li>
                            <li><a href="#">Fresh Berries</a></li>
                            <li><a href="#">Ocean Foods</a></li>
                            <li><a href="#">Butter & Eggs</a></li>
                            <li><a href="#">Fastfood</a></li>
                            <li><a href="#">Fresh Onion</a></li>
                            <li><a href="#">Papayaya & Crisps</a></li>
                            <li><a href="#">Oatmeal</a></li>
                            <li><a href="#">Fresh Bananas</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                                <%@ include file="../../search.jsp" %>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>support 24/7 time</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->
    <section class="breadcrumb-section set-bg" data-setbg="/../JavaWebProduct/assets/web/img/breadcrumb.jpg" style="background-image: url(&quot;img/breadcrumb.jpg&quot;);">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Sản Phẩm Chi Tiết</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <a href="./index.html">Product Details</a>
                            <span>Vegetable’s Package</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
 
<section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                            <img class="product__details__pic__item--large" src="../../JavaWebProduct/assets/web/img/product/${productDetails.image}" alt="">
                        </div>
                        <div class="product__details__pic__slider owl-carousel owl-loaded owl-drag">
                            
                            
                            
                            
                        <div class="owl-stage-outer"><div class="owl-stage" style="transform: translate3d(-1006px, 0px, 0px); transition: all 1.2s ease 0s; width: 1725px;"><div class="owl-item cloned" style="width: 123.75px; margin-right: 20px;"><img data-imgbigurl="/../JavaWebProduct/assets/web/img/product/details/product-details-2.jpg" src="/../JavaWebProduct/assets/web/img/product/details/thumb-1.jpg" alt=""></div><div class="owl-item cloned" style="width: 123.75px; margin-right: 20px;"><img data-imgbigurl="img/product/details/product-details-3.jpg" src="/../JavaWebProduct/assets/web/img/product/details/thumb-2.jpg" alt=""></div><div class="owl-item cloned" style="width: 123.75px; margin-right: 20px;"><img data-imgbigurl="img/product/details/product-details-5.jpg" src="/../JavaWebProduct/assets/web/img/product/details/thumb-3.jpg" alt=""></div><div class="owl-item cloned" style="width: 123.75px; margin-right: 20px;"><img data-imgbigurl="/../JavaWebProduct/assets/web/img/product/details/product-details-4.jpg" src="img/product/details/thumb-4.jpg" alt=""></div><div class="owl-item" style="width: 123.75px; margin-right: 20px;"><img data-imgbigurl="/../JavaWebProduct/assets/web/img/product/details/product-details-2.jpg" src="/../JavaWebProduct/assets/web/img/product/details/thumb-1.jpg" alt=""></div><div class="owl-item" style="width: 123.75px; margin-right: 20px;"><img data-imgbigurl="img/product/details/product-details-3.jpg" src="/../JavaWebProduct/assets/web/img/product/details/thumb-2.jpg" alt=""></div><div class="owl-item" style="width: 123.75px; margin-right: 20px;"><img data-imgbigurl="/../JavaWebProduct/assets/web/img/product/details/product-details-5.jpg" src="/../JavaWebProduct/assets/web/img/product/details/thumb-3.jpg" alt=""></div><div class="owl-item active" style="width: 123.75px; margin-right: 20px;"><img data-imgbigurl="/../JavaWebProduct/assets/web/img/product/details/product-details-4.jpg" src="/../JavaWebProduct/assets/web/img/product/details/thumb-4.jpg" alt=""></div><div class="owl-item cloned active" style="width: 123.75px; margin-right: 20px;"><img data-imgbigurl="/../JavaWebProduct/assets/web/img/product/details/product-details-2.jpg" src="/../JavaWebProduct/assets/web/img/product/details/thumb-1.jpg" alt=""></div><div class="owl-item cloned active" style="width: 123.75px; margin-right: 20px;"><img data-imgbigurl="/../JavaWebProduct/assets/web/img/product/details/product-details-3.jpg" src="/../JavaWebProduct/assets/web/img/product/details/thumb-2.jpg" alt=""></div><div class="owl-item cloned active" style="width: 123.75px; margin-right: 20px;"><img data-imgbigurl="/../JavaWebProduct/assets/web/img/product/details/product-details-5.jpg" src="/../JavaWebProduct/assets/web/img/product/details/thumb-3.jpg" alt=""></div><div class="owl-item cloned" style="width: 123.75px; margin-right: 20px;"><img data-imgbigurl="img/product/details/product-details-4.jpg" src="img/product/details/thumb-4.jpg" alt=""></div></div></div><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div><div class="owl-dots disabled"><button role="button" class="owl-dot active"><span></span></button></div></div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3>${productDetails.title}</h3>
                        <div class="product__details__rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star-half-o"></i>
                            <span>(18 reviews)</span>
                        </div>
                        <div class="product__details__price">$ ${productDetails.price}</div>
                        <p>Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a. Vestibulum ac diam sit amet quam
                            vehicula elementum sed sit amet dui. Sed porttitor lectus nibh. Vestibulum ac diam sit amet
                            quam vehicula elementum sed sit amet dui. Proin eget tortor risus.</p>
                        <div class="product__details__quantity">
                            <div class="quantity">
                                <div class="pro-qty"><span class="dec qtybtn">-</span>
                                    <input type="text" value="1">
                                <span class="inc qtybtn">+</span></div>
                            </div>
                        </div>
                        <a href="#" class="primary-btn">THÊM GIỎ HÀNG</a>
                        <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
                        <ul>
                            <li><b>Số lượng sản phẩm</b> <span>${productDetails.amount}</span></li>
                            <li><b>Shipping</b> <span>01 day shipping. <samp>Free pickup today</samp></span></li>
                            <li><b>Weight</b> <span>0.5 kg</span></li>
                            <li><b>Share on</b>
                                <div class="share">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-instagram"></i></a>
                                    <a href="#"><i class="fa fa-pinterest"></i></a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">Mô tả</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab" aria-selected="false">Thông Tin</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab" aria-selected="false">Bình Luận<span>(1)</span></a>
                            </li>
                        </ul>
                        
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h6>Thông tin sản phẩm</h6>
                                    <p>Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.
                                        Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus. Vivamus
                                        suscipit tortor eget felis porttitor volutpat. Vestibulum ac diam sit amet quam
                                        vehicula elementum sed sit amet dui. Donec rutrum congue leo eget malesuada.
                                        Vivamus suscipit tortor eget felis porttitor volutpat. Curabitur arcu erat,
                                        accumsan id imperdiet et, porttitor at sem. Praesent sapien massa, convallis a
                                        pellentesque nec, egestas non nisi. Vestibulum ac diam sit amet quam vehicula
                                        elementum sed sit amet dui. Vestibulum ante ipsum primis in faucibus orci luctus
                                        et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam
                                        vel, ullamcorper sit amet ligula. Proin eget tortor risus.</p>
                                        <p>Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Lorem
                                        ipsum dolor sit amet, consectetur adipiscing elit. Mauris blandit aliquet
                                        elit, eget tincidunt nibh pulvinar a. Cras ultricies ligula sed magna dictum
                                        porta. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus
                                        nibh. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a.
                                        Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui. Sed
                                        porttitor lectus nibh. Vestibulum ac diam sit amet quam vehicula elementum
                                        sed sit amet dui. Proin eget tortor risus.</p>
                                </div>
                            </div>
                            
                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h6>Chi tiết sản phẩm</h6>
                                    <p>Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.
                                        Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus.
                                        Vivamus suscipit tortor eget felis porttitor volutpat. Vestibulum ac diam
                                        sit amet quam vehicula elementum sed sit amet dui. Donec rutrum congue leo
                                        eget malesuada. Vivamus suscipit tortor eget felis porttitor volutpat.
                                        Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Praesent
                                        sapien massa, convallis a pellentesque nec, egestas non nisi. Vestibulum ac
                                        diam sit amet quam vehicula elementum sed sit amet dui. Vestibulum ante
                                        ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;
                                        Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula.
                                        Proin eget tortor risus.</p>
                                    <p>Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Lorem
                                        ipsum dolor sit amet, consectetur adipiscing elit. Mauris blandit aliquet
                                        elit, eget tincidunt nibh pulvinar a. Cras ultricies ligula sed magna dictum
                                        porta. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus
                                        nibh. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a.</p>
                                </div>
                            </div>
                            
                            <div class="tab-pane" id="tabs-3" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h6>Bình Luận</h6>
                                    <p>Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.
                                        Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus.
                                        Vivamus suscipit tortor eget felis porttitor volutpat. Vestibulum ac diam
                                        sit amet quam vehicula elementum sed sit amet dui. Donec rutrum congue leo
                                        eget malesuada. Vivamus suscipit tortor eget felis porttitor volutpat.
                                        Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Praesent
                                        sapien massa, convallis a pellentesque nec, egestas non nisi. Vestibulum ac
                                        diam sit amet quam vehicula elementum sed sit amet dui. Vestibulum ante
                                        ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;
                                        Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula.
                                        Proin eget tortor risus.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

<section class="related-product">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title related__product__title">
                        <h2>Sản Phẩm Liên Quan</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="/../JavaWebProduct/assets/web/img/product/product-1.jpg" style="background-image: url(&quot;img/product/product-1.jpg&quot;);">
                            <ul class="product__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="/../JavaWebProduct/assets/web/img/product/product-2.jpg" style="background-image: url(&quot;img/product/product-2.jpg&quot;);">
                            <ul class="product__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="/../JavaWebProduct/assets/web/img/product/product-3.jpg" style="background-image: url(&quot;img/product/product-3.jpg&quot;);">
                            <ul class="product__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="/../JavaWebProduct/assets/web/img/product/product-7.jpg" style="background-image: url(&quot;img/product/product-7.jpg&quot;);">
                            <ul class="product__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
<%@include file="../../footer.jsp" %>
