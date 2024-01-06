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
								<h1 class="h4 text-gray-900 mb-4">Xin chào! Bạn thật tuyệt vời!!!</h1>
								<h5 class="h4 text-gray-900 mb-4" style="color: red;">${requestScope.error}</h5>
							</div>
							<form class="user" action="RegisterEmployerServlet" method="get">
								<div class="reg-info">
									<h3>Tài khoản</h3>
								</div>
								<div class="form-group">
									<input type="email" class="form-control form-control-user"
										name="email" aria-describedby="emailHelp"
										placeholder="Nhập email" value="">
								</div>
								<div class="form-group">
									<input type="password" class="form-control form-control-user"
										name="password" placeholder="Nhập mật khẩu" value="">
								</div>
								<div class="form-group">
									<input type="password" class="form-control form-control-user"
										name="repeatPassword" placeholder="Nhập lại mật khẩu" value="">
								</div>
								<div class="reg-info">
									<h3>Thông tin nhà tuyển dụng</h3>
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										name="contact_name" aria-describedby="emailHelp"
										placeholder="Tên đại diện" value="">
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										name="employer_name" aria-describedby="emailHelp"
										placeholder="Tên nhà tuyển dụng" value="">
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										name="phone" aria-describedby="emailHelp"
										placeholder="Số điện thoại" value="">
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										name="address" aria-describedby="emailHelp"
										placeholder="Địa chỉ" value="">
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										name="image" aria-describedby="emailHelp"
										placeholder="Ảnh" value="">
								</div>
								<div class="form-group">
									<select
										class="form-control form-control-user" name="city">
										<option value="1">Hồ Chí Minh</option>
											<option value="2">Hà Nội</option>
											<option value="3">An Giang</option>
											<option value="4">Bạc Liêu</option>
											<option value="5">Bà Rịa-Vũng Tàu</option>
											<option value="6">Bắc Cạn</option>
											<option value="7">Bắc Giang</option>
											<option value="8">Bắc Ninh</option>
											<option value="9">Bến Tre</option>
											<option value="10">Bình Dương</option>
											<option value="11">Bình Định</option>
											<option value="12">Bình Phước</option>
											<option value="13">Bình Thuận</option>
											<option value="14">Cao Bằng</option>
											<option value="15">Cà Mau</option>
											<option value="16">Cần Thơ</option>
											<option value="17">Đà Nẵng</option>
											<option value="18">Đắk Lắk</option>
											<option value="19">Đắk Nông</option>
											<option value="20">Điện Biên</option>
											<option value="21">Đồng Nai</option>
											<option value="22">Đồng Tháp</option>
											<option value="23">Gia Lai</option>
											<option value="24">Hà Giang</option>
											<option value="25">Hà Nam</option>
											<option value="27">Hà Tĩnh</option>
											<option value="28">Hải Dương</option>
											<option value="29">Hải Phòng</option>
											<option value="30">Hậu Giang</option>
											<option value="31">Hòa Bình</option>
											<option value="32">Hưng Yên</option>
											<option value="33">Khánh Hòa</option>
											<option value="34">Kiên Giang</option>
											<option value="35">Kon Tum</option>
											<option value="36">Lai Châu</option>
											<option value="37">Lạng Sơn</option>
											<option value="38">Lào Cai</option>
											<option value="39">Lâm Đồng</option>
											<option value="40">Long An</option>
											<option value="41">Nam Định</option>
											<option value="42">Nghệ An</option>
											<option value="43">Ninh Bình</option>
											<option value="44">Ninh Thuận</option>
											<option value="45">Phú Thọ</option>
											<option value="46">Phú Yên</option>
											<option value="47">Quảng Bình</option>
											<option value="48">Quảng Nam</option>
											<option value="49">Quảng Ngãi</option>
											<option value="50">Quảng Ninh</option>
											<option value="51">Quảng Trị</option>
											<option value="52">Sóc Trăng</option>
											<option value="53">Sơn La</option>
											<option value="54">Tây Ninh</option>
											<option value="55">Thái Bình</option>
											<option value="56">Thái Nguyên</option>
											<option value="57">Thanh Hóa</option>
											<option value="58">Thừa Thiên-Huế</option>
											<option value="59">Tiền Giang</option>
											<option value="60">Trà Vinh</option>
											<option value="61">Tuyên Quang</option>
											<option value="62">Vĩnh Long</option>
											<option value="63">Vĩnh Phúc</option>
											<option value="64">Yên Bái</option>
											<option value="65">Toàn quốc</option>
											<option value="66">Nước ngoài</option>
									</select>
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