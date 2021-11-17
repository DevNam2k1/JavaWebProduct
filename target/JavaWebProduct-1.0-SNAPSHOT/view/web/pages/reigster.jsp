<%-- 
    Document   : reigsiter
    Created on : Nov 5, 2021, 10:07:24 PM
    Author     : laptop88
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Đăng Kí</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="../../../JavaWebProduct/assets/web/img/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../../JavaWebProduct/assets/web/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../../JavaWebProduct/assets/web/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../../JavaWebProduct/assets/web/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../../JavaWebProduct/assets/web/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="../../../JavaWebProduct/assets/web/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../../JavaWebProduct/assets/web/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../../JavaWebProduct/assets/web/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="../../../JavaWebProduct/assets/web/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../../../JavaWebProduct/assets/web/css/util.css">
	<link rel="stylesheet" type="text/css" href="../../../JavaWebProduct/assets/web/css/main.css">
<!--===============================================================================================-->
</head>
<body style="background-color: #666666;">
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
                            <form class="login100-form validate-form" action="<%=request.getContextPath()%>/reigster" method="post">
					<span class="login100-form-title p-b-43">
						Đăng Kí
					</span>
                                        <%
                                            if(request.getAttribute("error") != null){
                                        %>
                                        <div class="text-center p-t-46 p-b-20">
						<span class="txt2" style="color: red; text-align: center;">
							${error}
						</span>
					</div>
                                        <%
                                            }
					%>
					<div class="wrap-input100 validate-input" data-validate = "Yêu cầu tên người dùng: Gasky2k1">
						<input class="input100" type="text" name="username">
						<span class="focus-input100"></span>
						<span class="label-input100">Username</span>
					</div>
                                    
					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="email">
						<span class="focus-input100"></span>
						<span class="label-input100">Email</span>
					</div>
					
					
					<div class="wrap-input100 validate-input" data-validate="Nhập mật khẩu">
						<input class="input100" type="password" name="password">
						<span class="focus-input100"></span>
						<span class="label-input100">Password</span>
					</div>
                                    
                                       	<div class="wrap-input100 validate-input" data-validate="Xác nhận mật khẩu">
						<input class="input100" type="password" name="comfirm_password">
						<span class="focus-input100"></span>
						<span class="label-input100">Comfirm Password</span>
					</div>

					<div class="flex-sb-m w-full p-t-3 p-b-32">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								Remember me
							</label>
						</div>

						<div>
							<a href="#" class="txt1">
								Forgot Password?
							</a>
						</div>
					</div>
			

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Đăng kí
						</button>
					</div>
					
					<div class="text-center p-t-46 p-b-20">
						<span class="txt2">
							or login 
						</span>
					</div>

					<div >
						<a href="<%=request.getContextPath()%>/login-form" class=" flex-c-m ">
							Đăng Nhập Tài Khoản
						</a>

					</div>
				</form>

				<div class="login100-more" style="background-image: url('../../../JavaWebProduct/assets/web/img/bg-01.jpg');">
				</div>
			</div>
		</div>
	</div>
	
	

	
	
<!--===============================================================================================-->
	<script src="../../../JavaWebProduct/assets/web/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="../../../JavaWebProduct/assets/web/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="../../../JavaWebProduct/assets/web/vendor/bootstrap/js/popper.js"></script>
	<script src="../../../JavaWebProduct/assets/web/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="../../../JavaWebProduct/assets/web/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="../../../JavaWebProduct/assets/web/vendor/daterangepicker/moment.min.js"></script>
	<script src="../../../JavaWebProduct/assets/web/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="../../../JavaWebProduct/assets/web/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="../../../JavaWebProduct/assets/web/js/main1.js"></script>

</body>
</html>
