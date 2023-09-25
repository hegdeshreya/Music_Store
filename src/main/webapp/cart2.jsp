<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.entity.User"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="com.DAO.SongDAOImpl"%>
<%@ page import="com.DAO.Cart2DAOImpl"%>
<%@ page import="com.DAO.InstrumentDAOImpl"%>
<%@ page import="com.entity.songdtls"%>
<%@ page import="com.entity.instrument"%>
<%@ page import="com.entity.Cart2"%>
<%@ page import="java.util.List"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cart</title>
<%@include file="all_components/allCss.jsp"%>
</head>
<body>
<body style="background-color: #f0f1f2;" ]>
	<%@include file="all_components/navbar.jsp"%>

	<c:if test="${ empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

	<c:if test="${not empty failedMsg }">
		<h5 class="text-center text-danger">${ failedMsg }</h5>
		<c:remove var="failedMsg" scope="session" />
	</c:if>
	<c:if test="${not empty succMsg }">
		<div class="alert alert-success" role="alert">${ succMsg }</div>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<div class="container">
		<div class="row p-2">
			<div class="col-md-6 ">


				<div class="card bg-white">
					<div class="card-body">
						<h3 class="text-center text-success">Your Selected Items</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">Instrument Name</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								User u = (User) session.getAttribute("userobj");
								Cart2DAOImpl dao = new Cart2DAOImpl(DBConnect.getConn());
								List<Cart2> cart = dao.getinstrumentByUser(u.getId());
								for (Cart2 c : cart) {
								%>


								<tr>
									<th scope="row"><%=c.getInstruname()%></th>
									<td>$<%=c.getPrice()%></td>
									<td><a href="remove_instrument?iid=<%=c.getIid()%>&&uid=<%=c.getUid() %>"
										class="btn btn-sm btn-danger">Remove </a></td>
								</tr>
								<%
								}
								%>
								<tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Your details for order</h3>
						<form action="order2" method="post">
						<input type="hidden" value="${userobj.id }" name="id">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Name</label> <input type="text"
										class="form-control" id="inputEmail4" value="${userobj.name }" name="username" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Email</label> <input type="email"
										class="form-control" id="inputPassword4" value="${userobj.email}" name="email" required>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Phone Number</label> <input
										type="number" class="form-control" id="inputEmail4" value="${userobj.phno}" name="phno" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Address</label> <input type="text"
										class="form-control" id="inputPassword4" name="address" required>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Landmark</label> <input type="text"
										class="form-control" id="inputEmail4"  name="landmark" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">city</label> <input type="text"
										class="form-control" id="inputPassword4" name="city" required>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">State</label> <input type="text"
										class="form-control" id="inputEmail4" name="state" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Pincode</label> <input type="text"
										class="form-control" id="inputPassword4" name="pincode" required>
								</div>
							</div>

							<div class="form-group">
								<label for="payment-mode">Payment Mode</label> <select
									class="form-control" id="payment-mode" name="payment-mode" name="payment" required>
									<option value="COD">Cash on delivary</option>
							<!--  	<option value="credit-card">Credit Card</option>
									<option value="debit-card">Debit Card</option> -->

									<!-- Add more payment options as needed -->
								</select>
							</div>
							<div class="text-center">
								<button class="btn btn-warning">Order Now</button>
								<a href="index.jsp" class="btn btn-success">Continue
									shopping</a>
							</div>
						</form>
					</div>
				</div>

			</div>

		</div>
	</div>
</body>
</html>