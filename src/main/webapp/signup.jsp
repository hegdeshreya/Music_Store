<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sign up</title>
<%@include file="all_components/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;" ]>
	<%@include file="all_components/navbar.jsp"%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center ">Sign up</h4>
						
						<c:if test="${not empty succMsg }">
						<p class="text-center text-success">${ succMsg }</p>
						<c:remove var ="succMsg" scope="session"/>
						</c:if>
						<c:if test="${not empty failedMsg }">
						<p class="text-center text-danger">${ failedMsg }</p>
							<c:remove var ="failedMsg" scope="session"/>
						</c:if>
						
						<form action="register" method=post>
							<div class="form-group">
								<label for="exampleInputname">Name</label> <input type="text"
									class="form-control" id="exampleInputname"
									aria-describedby="emailHelp" placeholder="Enter name"
									name="fname">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email"
									name="email">

							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">phone no</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter phno"
									name="phno">

							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password" name="password">
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary mt-3 mb-1">Signup</button>
								<br> <a href="signup.jsp">already registered?Login
									account</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@include file="all_components/footer.jsp"%>
</body>
</html>