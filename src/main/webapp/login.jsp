<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@include file="all_components/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;" ]>
	<%@include file="all_components/navbar.jsp"%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center ">Login</h4>
						
						
						<c:if test="${not empty failedMsg }">
						<h5 class="text-center text-danger">${ failedMsg }</h5>
							<c:remove var ="failedMsg" scope="session"/>
						</c:if>
						<c:if test="${not empty succMsg }">
						<h5 class="text-center text-success">${succdMsg }</h5>
							<c:remove var ="succMsg" scope="session"/>
						</c:if>
						
						
						<form action="Login" method="post">

							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email" required
									name="email">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password" required name="password">
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary mt-3 mb-1">Login</button>
								<br> <a href="signup.jsp">create account</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>



</body>
</html>