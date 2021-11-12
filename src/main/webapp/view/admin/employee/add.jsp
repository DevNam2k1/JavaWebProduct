<%-- 
    Document   : add
    Created on : Nov 12, 2021, 2:45:49 PM
    Author     : laptop88
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../admin_layout.jsp" %>
    <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Nhân Viên</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Nhân Viên</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Thêm Nhân Viên <p style="color: red;">${error}</p></h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
       
              <form action="<%=request.getContextPath()%>/employee/store" method="post">
                  
                <div class="card-body">
                  <div class="form-group">
                    <label for="exampleInputEmployeeName">Tên Người Dùng*</label>
                    <input type="text" name="username" class="form-control" id="exampleEmployeeName" placeholder="VD: Namsky1826,....">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputEmail">Email*</label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail" placeholder="VD: xyz@gmail.com,...">
                  </div>                  
                  <div class="form-group">
                    <label for="exampleInputPassword">Mật khẩu*</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword" placeholder="VD: Nam123432#@,.....">
                  </div>
                 <div class="form-group">
                    <label for="exampleInputConfirmPassword">Nhập lại mật khẩu*</label>
                    <input type="password" name="confirm_password" class="form-control" id="exampleConfirmPassword" placeholder="VD: Nam123432#@,.....">
                  </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Thêm</button>
                </div>
              </form>
            </div>
            
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
<%@ include file="../footer.jsp" %>

