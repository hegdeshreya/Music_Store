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

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allCss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container-fluid"
		style="height: 20px; background-color: white"></div>

	<c:if test="${not empty succMsg}">
		<h5 class="text-center text-success">${succMsg}</h5>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<c:if test="${not empty failedMsg}">
		<h5 class="text-center text-danger">${failedMsg}</h5>
		<c:remove var="failedMsg" scope="session" />
	</c:if>




	<table class="table table-striped ">
		<thead class="bg-warning">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Album Cover</th>
				<th scope="col">Song name</th>
				<th scope="col">Genera</th>
				<th scope="col">Artist</th>
				<th scope="col">Price</th>
				<!--<th scope="col">status</th>-->
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			SongDAOImpl dao = new SongDAOImpl(DBConnect.getConn());
			List<songdtls> list = dao.getAllSongs();
			for (songdtls s : list) {
			%>
			<tr>

				<td><%=s.getId()%></td>
				<td><img src="../music-img/<%=s.getPicName()%>"
					style="width: 50px; height: 50px;"></td>
				<td><%=s.getsongname()%></td>
				<td><%=s.getGenre()%></td>
				<td><%=s.getArtist()%></td>
				<td><%=s.getPrice()%></td>
			<!-- <td><a href="a" class="btn btn-success">Status</a></td>-->
				<td><a href="../delete?id=<%=s.getId()%>"
					class="btn btn-danger">Delete</a></td>
			</tr>

			<%
			}
			%>


		</tbody>
	</table>

</body>
</html>