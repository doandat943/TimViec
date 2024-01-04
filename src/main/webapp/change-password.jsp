<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Forgot Password</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Thay đổi mật khẩu</h1>
                                    </div>
                                    <c:set value="${account}" var="c"/>
                                    <form action="UpdateAccountServlet" method="post" class="user">
                                        <div class="form-group">
                                            <input type="hidden" class="form-control form-control-user"
                                                name="email" aria-describedby="emailHelp"
                                                placeholder="Nhập mật khẩu mới..." value="${c.email}">
                                        </div>
                                        <div class="form-group">
                                            <input type="hidden" class="form-control form-control-user"
                                                name="role" aria-describedby="emailHelp"
                                                placeholder="Nhập lại mật khẩu..." value="${c.role}">
                                        </div>
                                        
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                name="password" aria-describedby="emailHelp"
                                                placeholder="Nhập mật khẩu mới...">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                name="exampleInputEmail" aria-describedby="emailHelp"
                                                placeholder="Nhập lại mật khẩu...">
                                        </div>
                                        <input type="submit" value ="Đổi mật khẩu" class="btn btn-primary btn-user btn-block">
                                            
                                        </input>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="register.jsp">Create an Account!</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="login.jsp">Already have an account? Login!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>