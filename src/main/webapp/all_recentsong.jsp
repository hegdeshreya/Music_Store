<%@ page import="com.DB.DBConnect"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="com.DAO.SongDAOImpl"%>
<%@ page import="com.entity.songdtls"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recent</title>
<%@include file="all_components/allCss.jsp"%>
</head>
<body>
	<%@include file="all_components/navbar.jsp"%>
	<div class="container p-3">
		<div class="row">
			<%
			SongDAOImpl dao1 = new SongDAOImpl(DBConnect.getConn());
			List<songdtls>  list = dao1.getAllRecentsongs();
			for (songdtls s : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img src="music-img/<%=s.getPicName()%>" alt="Album Image"
							class="img-thumblin" style="width: 200px; height: 150px;">

						<p><%=s.getsongname()%>
						</p>
						<!-- Audio Player -->
						<div class="audio-player">
							<audio controls style="max-width: 100%; width: 100%; margin: 0;">
								<source src="music/<%=s.getSong()%>" " type="audio/mpeg">

							</audio>
						</div>
						<p>
							Category:<%=s.getGenre()%>
						</p>
						<div class="row">
							<a href="" class="btn btn-success btn-sm ml-5">Add to cart</a> <a href=""
								class="btn btn-danger btn-sm ml-2">$<%=s.getPrice()%></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>


		</div>
	</div>
</body>
</html>