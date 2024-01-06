<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Login - FastJobs</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Roboto Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i,900,900i&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i&display=swap"
	rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- bootstrap css -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

<!-- main css -->
<link rel="stylesheet" type="text/css" href="css/style.css">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
	integrity="sha256-NuCn4IvuZXdBaFKJOAcsU2Q3ZpwbdFisd5dux4jkQ5w="
	crossorigin="anonymous" />

</head>

<body>
	<div class="container-fluid login-fluid clear-left clear-right">
		<div class="login-container">
			<!-- login header -->
			<div class="login-header">
				<div class="w-login m-auto">
					<div class="login-right">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-return">Quay lại Trang chủ</a>
					</div>
				</div>
			</div>
			<!-- (end) login header -->

			<div class="clearfix"></div>

			<div class="padding-top-90"></div>

			<!-- login main -->
			<div class="login-main">
				<div class="w-login m-auto">
					<div class="row">
						<!-- login main descriptions -->
						<div class="col-md-6 col-sm-12 col-12 login-main-left">
							<img src="img/banner-login.png">
						</div>
						<!-- login main form -->
						<div class="col-md-6 col-sm-12 col-12 login-main-right">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Xin chào!</h1>
								<h5 class="h4 text-gray-900 mb-4">${requestScope.error}</h5>
								<c:set var="cookie" value="${pageContext.request.cookies}" />
							</div>
							<form class="user" action="LoginServlet" method="get">
								<div class="form-group">
									<input type="email" class="form-control form-control-user"
										name="email" aria-describedby="emailHelp"
										placeholder="Nhập email" value="${cookie.email.value}">
								</div>
								<div class="form-group">
									<input type="password" class="form-control form-control-user"
										name="password" placeholder="Nhập mật khẩu"
										value="${cookie.password.value}">
								</div>
								<div class="form-group">
									<div class="custom-control custom-checkbox small">
										<input type="checkbox" class="custom-control-input"
											id="customCheck" name="rememberPassword" value="ON"
											${(cookie.rememberPassword!=null?'checked':'')}> <label
											class="custom-control-label" for="customCheck">Lưu
											tài khoản</label>
									</div>
								</div>
								<input type="submit" value="Đăng nhập"
									class="btn btn-primary btn-user btn-block">
								<hr>
								<a href="HomeServlet" class="btn btn-google btn-user btn-block">
									<i class="fab fa-google fa-fw"></i> Đăng nhập với Google
								</a> <a href="HomeServlet" class="btn btn-facebook btn-user btn-block">
									<i class="fab fa-facebook-f fa-fw"></i> Đăng nhập với Facebook
								</a>
							</form>
							<hr>
							<div class="text-center">
								<a class="small" href="forgot-password.jsp">Quên mật khẩu?</a>
							</div>
							<div class="text-center">
								<a class="small" href="register-user.jsp">Tạo tài khoản!</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- (end) login main -->
		</div>
	</div>
	<footer class="login-footer">
		<div class="w-login m-auto">
			<div class="row">
				<!-- login footer left -->
				<div class="col-md-6 col-sm-12 col-12 login-footer-left">
					<div class="login-copyright">
						<p>
							Copyright © 2023 <a href="#"> FastJobs</a>. All Rights Reserved.
						</p>
					</div>
				</div>
				<!-- login footer right -->
				<div class="col-md-6 col-sm-12 col-12 login-footer-right">
					<ul>
						<li><a href="#">Terms & Conditions</a></li>
						<li><a href="#">Privacy Policy</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="js/jquery-3.4.1.slim.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/form.js"></script>

	<script type="text/javascript" src="js/main.js"></script>
</body>

</html>