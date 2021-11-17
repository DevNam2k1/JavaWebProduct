<%-- 
    Document   : list
    Created on : Nov 2, 2021, 4:28:54 PM
    Author     : laptop88
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../admin_layout.jsp" %>
    <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Sản Phẩm</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Sản Phẩm</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
    
        <!-- /.row -->
        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                  <h3 class="card-title"><a href="../JavaWebProduct/product/new"><button type="button" class="btn btn-block btn-outline-success">+ Thêm sản phẩm</button></a></h3>
       
                <div class="card-tools">
                     <form action="<%=request.getContextPath()%>/product/search" method="post">
                  <div class="input-group input-group-sm" style="width: 150px;">
                     
                    <input type="text" name="productName" value="${searchName}"class="form-control float-right" placeholder="Search">
                      
                    <div class="input-group-append">
                      <button type="submit" class="btn btn-default">
                        <i class="fas fa-search"></i>
                      </button>
                       
                    </div>
                  </div>
                    </form>
                </div>
                     
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Tên Sản Phẩm</th>
                      <th>Ảnh</th>
                      <th>Giá</th>
                      <th>Mô tả</th>
                      <th>Tiêu đề</th>
                      <th>Số lượng</th>
                      <th></th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items = "${listProduct}" var = "p">
                    <tr>
                      <td>${p.id}</td>
                      <td>${p.name}</td>
                      <td><img src="../../../JavaWebProduct/assets/web/img/product/${p.image}" style="width: 100px; height: 100px;"></td>
                      <td><span class="tag tag-success">${p.price}</span></td>
                      <td>${p.description}</td>
                      <td>${p.title}</td>
                      <td>${p.amount}</td>
                      <td><a href="<%=request.getContextPath()%>/product/edit?id=${p.id}" class="active styling-edit " ui-toggle-class="" >
                          <i class="far fa-edit text-success" ></i>
                          </a></td>
                      <td><a onClick="return confirm('Bạn có chắc muốn xóa môn học này không?')" href="<%=request.getContextPath()%>/product/delete?id=${p.id}"  class="active styling-edit" ui-toggle-class="">
                          <i class="fa fa-times text-danger "></i>
                          </a></td>
   
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
              <div class="card-footer clearfix">
                <ul class="pagination pagination-sm m-0 float-right">
                    <c:if test="${start != 1}">
                  <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/product?page=${start-1}">«</a></li>
                    </c:if>
                  <c:forEach begin="1" end="${totalPage}" var="i">
                  <li class="page-item ${start == i ? "active":""}"><a class="page-link" href="<%=request.getContextPath()%>/product?page=${i}">${i}</a></li>
                  </c:forEach>
                  <c:if test="${start != totalPage}">
                  <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/product?page=${start+1}">»</a></li>
                  </c:if>
                </ul>
              </div>
            </div>
              
            <!-- /.card -->
          </div>
        </div>
        <!-- /.row -->

            
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
<%@ include file="../footer.jsp" %>
