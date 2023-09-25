<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page import="com.entity.songdtls"%>
<%@ page import="java.util.List"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.DAO.SongDAOImpl"%>
<%@ page import="com.DAO.SongDAO"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="com.DAO.SongOrderImpl"%>
<%@ page import="com.entity.songdtls"%>
<%@ page import="com.entity.Instrument_Order"%>
<%@ page import="com.DAO.InstrumentOrderDAOImpl"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allCss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container p-1">
		<h3 class="text-center text-primary">User Order</h3>

		<table class="table table-striped mt-3">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Address</th>
					<th scope="col">PhNo</th>
					<th scope="col">Item Name</th>
					<th scope="col">Price</th>
					<th scope="col">Payment Method</th>
				</tr>
			</thead>
			<tbody>
		       <% 
				
		       InstrumentOrderDAOImpl dao= new InstrumentOrderDAOImpl(DBConnect.getConn()); 
			List<Instrument_Order> ilist = dao.getAllorder();
				for(Instrument_Order s: ilist) { 
				%>
				<tr>
					<th scope="row"><%=s.getOrderId()%></th>
					
					<td><%=s.getUserName()%></td>
					<td><%=s.getEmail()%></td>
					<td><%=s.getFulladd()%></td>
					<td><%=s.getPhno()%></td>
					<td><%=s.getInstruName()%></td>
						<td><%=s.getPrice()%></td>
					<td><%=s.getPaymentType()%></td>
				</tr>
				<% 
				
				} 
				
				%> 
			
				
				
			</tbody>
		</table>
	</div>
	
</body>
</html>