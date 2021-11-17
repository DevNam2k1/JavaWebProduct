<%-- 
    Document   : search
    Created on : Nov 16, 2021, 5:24:35 PM
    Author     : laptop88
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
                <form action="<%=request.getContextPath()%>/search" method="post">
                        <div class="hero__search__categories">
                                    Danh mục 
                            <span class="arrow_carrot-down"></span>
                        </div>
                        <input type="text" value="${searchName}" name="productName" placeholder="Bạn cần tìm kiếm sản phẩm nào?">
                        <button type="submit" class="site-btn">Tìm Kiếm</button>
               </form>