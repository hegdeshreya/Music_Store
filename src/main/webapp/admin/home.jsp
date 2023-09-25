<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN HOME</title>
<%@include file="allCss.jsp"%>
<style type="text/css">
.circle-card {
	width: 200px; /* Set the desired width */
	height: 200px; /* Set the desired height */
	border-radius: 20%;
	/* Create a circle by setting border-radius to 50% */
	overflow: hidden;
	/* Hide any content that exceeds the circle's bounds */
	background-color: rgba(173, 216, 230, 0.5);
	/* Set a mix of blue and pink */
	transition: background-color 0.3s;
	/* Add transition for smoother color change */
}

.circle-card:hover {
	background-color: rgba(255, 192, 203, 0.8);
	/* Change background color on hover */
}

.custom-margin-left {
	margin-left: 400px;
}

.custom-margin-up {
	margin-top: -50px;
}

a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
	color: green;
}
</style>
</head>
<body>

	<%@include file="navbar.jsp"%>

	<div class="container p-5 custom-margin-left">
		<div class="row">
			<div class="col-md-3">
				<a href="add_song.jsp">
					<div class="card circle-card">
						<div
							class="card-body d-flex flex-column align-items-center justify-content-center">
							<i class="fas fa-plus-square fa-3x text-primary"></i>
							<h4>Add Songs</h4>
						</div>
					</div>
			</div>
			<div class="col-md-3">
				<a href="all_song.jsp">
					<div class="card circle-card">
						<div
							class="card-body d-flex flex-column align-items-center justify-content-center">
							<i class="fas fa-plus-square fa-3x text-primary"></i>
							<h4>All songs</h4>
						</div>
					</div>
			</div>
		</div>
	</div>

	<div class="container p-5  custom-margin-left custom-margin-up">
		<div class="row">
			<div class="col-md-3">
				<a href="all_instrument.jsp">
					<div class="card circle-card">
						<div
							class="card-body d-flex flex-column align-items-center justify-content-center">
							<i class="fas fa-plus-square fa-3x text-danger"></i>
							<h4>All Instruments</h4>
						</div>
					</div>
			</div>
			<div class="col-md-3">
				<a href="add_instrument.jsp">
					<div class="card circle-card">
						<div
							class="card-body d-flex flex-column align-items-center justify-content-center">
							<i class="fas fa-plus-square fa-3x text-danger"></i>
							<h4>Add Instument</h4>
						</div>
					</div>
			</div>
		</div>
	</div>
	<div class="container p-5  custom-margin-left custom-margin-up">
		<div class="row">
			<div class="col-md-3">
				<a href="orders.jsp">
					<div class="card circle-card">
						<div
							class="card-body d-flex flex-column align-items-center justify-content-center">
							<i class="fas fa-flag fa-3x text-danger"></i>
							<h4>Song Orders</h4>
						</div>
						
					</div>
			</div>
			<div class="col-md-3">
				<a href="orders2.jsp">
					<div class="card circle-card">
						<div
							class="card-body d-flex flex-column align-items-center justify-content-center">
							<i class="fas fa-flag fa-3x text-danger"></i>
							<h4>Instrument Orders</h4>
						</div>
						
					</div>
			</div>
			
			</div>
			</div>
</body>
</html>