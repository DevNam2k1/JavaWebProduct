<%-- 
    Document   : employee
    Created on : Nov 7, 2021, 3:43:07 PM
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
            <h1>Quản lý nhân viên</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Quản lý nhân viên</li>
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
                  <h3 class="card-title"><a href="<%=request.getContextPath()%>/employee/new"><button type="button" class="btn btn-block btn-outline-success">+ Thêm nhân viên</button></a></h3>
                   <p style="color: greenyellow;">${success}
                <div class="card-tools">
                  <div class="input-group input-group-sm" style="width: 150px;">
                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">

                    <div class="input-group-append">
                      <button type="submit" class="btn btn-default">
                        <i class="fas fa-search"></i>
                      </button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Tên người dùng</th>
                      <th>Email</th>
                      <th>Mật khẩu</th>
                      <th>Vô hiệu</th>
                    </tr>
                  </thead>
                  <tbody>
                      <c:forEach items="${listUser}" var="u">
                    <tr>
                      <td>${u.id}</td>
                      <td>${u.username}</td>
                      <td>${u.email}</td>
                      <td>${u.password}</td>
                      <td><button type="button" class="btn btn-block btn-success">ON</button></td>
                    </tr>
                      </c:forEach>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
               <div class="card-footer clearfix">
                <ul class="pagination pagination-sm m-0 float-right">
                    <c:if test="${start != 1}">
                  <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/employee?page=${start-1}">«</a></li>
                    </c:if>
                  <c:forEach begin="1" end="${totalPage}" var="i">
                  <li class="page-item ${start == i ? "active":""}"><a class="page-link" href="<%=request.getContextPath()%>/employee?page=${i}">${i}</a></li>
                  </c:forEach>
                  <c:if test="${start != totalPage}">
                  <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/employee?page=${start+1}">»</a></li>
                  </c:if>
                </ul>
              </div>
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

