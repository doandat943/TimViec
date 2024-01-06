<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Profile - FastJob</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Roboto Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i,900,900i&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i&display=swap"
	rel="stylesheet">

<!-- bootstrap css -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

<!-- main css -->
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>

<body>
	<div class="container-fluid login-fluid clear-left clear-right">
		<div class="login-container">
			<!-- login header -->
			<div class="login-header">
				<div class="w-login m-auto">
					<div class="login-logo">
						<h3>
							<!-- <a href="#">Tech<span class="txb-logo">Jobs.</span></a> -->
							<a href="#"> <img src="img/fast-logo.png" alt="FastJobs">
							</a>
						</h3>
						<span class="login-breadcrumb"><em>/</em> Profile</span>
					</div>
					<div class="login-right">
						<a href="${pageContext.request.contextPath}/JobListServlet"
							class="btn btn-return">Quay lại Dashboard</a>
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
						<div class="col-md-5 col-sm-12 col-12 login-main-left">
							<img src="img/banner-login.png">
						</div>
						<!-- login main form -->
						<div class="col-md-7 col-sm-12 col-12 login-main-right">

							<form class="user" action="UpdateProfileServlet" method="get">
								<div class="reg-info">
									<h3>Thông tin cá nhân</h3>
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										name="email" aria-describedby="emailHelp"
										placeholder="Họ và tên" value="${data.email }" style="display: none;">
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										name="fullname" aria-describedby="emailHelp"
										placeholder="Họ và tên" value="${data.fullname }">
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										name="phone" aria-describedby="emailHelp"
										placeholder="Số điện thoại" value="${ data.phone }">
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										name="address" aria-describedby="emailHelp"
										placeholder="Địa chỉ" value="${ data.address }">
								</div>
								<div class="form-group">
									<select class="form-control form-control-user" name="sex">
										<option value="male" ${data.sex == 'male' ? 'selected' : ''}>Nam</option>
										<option value="female"
											${data.sex == 'female' ? 'selected' : ''}>Nữ</option>
										<option value="other" ${data.sex == 'other' ? 'selected' : ''}>Khác</option>
									</select>
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										name="dob" aria-describedby="emailHelp"
										placeholder="dd/mm/yyyy" value="${ data.dob }">
								</div>
								<input type="submit" value="Lưu"
									class="btn btn-primary btn-user btn-block">
								<hr>
							</form>
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
							Copyright © 2020 <a href="#"> FastJob</a>. All Rights Reserved.
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