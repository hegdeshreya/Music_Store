<%@page import="com.entity.User"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="com.DAO.SongDAOImpl"%>
<%@ page import="com.DAO.InstrumentDAOImpl"%>
<%@ page import="com.entity.songdtls"%>
<%@ page import="com.entity.instrument"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Index</title>
<%@include file="all_components/allCss.jsp"%>
<style type="text/css">
.back-img {
	background: url("img/musicc.webp");
	height: 50vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
	/* Adjust background position to center the image */
	background-position: center center;
	transform: rotate(0deg);
}

.text-cr {
	color: black;
	font-family: 'Pacifico', cursive; /* Apply the Pacifico font */
	font-size: 36px;
	font-weight: normal;
	text-align: left;
	transform-origin: top left;
}

.audio-player {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 10px;
	/* Add spacing between the image and the audio player */
}

.crd-ho:hover {
	background-color: #fcf7f7;
}

.round-image {
	border-radius: 50%;
}
</style>
</head>
<body style="background-color: #f5f7f7;">
	<%
	User u = (User) session.getAttribute("userobj");
	%>
	<!-- Include this snippet within the <body> tag -->
	<div id="toast"
		style="position: fixed; bottom: 30px; left: 50%; transform: translateX(-50%); background: #333; padding: 10px; color: white; text-align: center; z-index: 1; font-size: 18px; visibility: hidden;">
		<span id="toastMessage"></span>
	</div>
	<script type="text/javascript">
		var showToastInterval; // Global variable to hold the interval ID

		function showToast(message) {
			var toast = document.getElementById("toast");
			var toastMessage = document.getElementById("toastMessage");

			clearInterval(showToastInterval); // Clear any previous intervals
			toastMessage.textContent = message;
			toast.style.visibility = "visible";

			showToastInterval = setInterval(function() {
				toast.style.visibility = "hidden";
				toastMessage.textContent = ""; // Clear the message after displaying
				clearInterval(showToastInterval);
			}, 12000); // Set the interval to 4 seconds
		}
	</script>




	<%@include file="all_components/navbar.jsp"%>

	<diV class="container-fluid back-img">
		<h2 class=" text-cr">Find your song!</h2>
	</diV>


	<!-- Recent book -->
	<div class="container">
		<h3 class=" text-center mb-3 mt-3">Recent Songs</h3>
		<div class="row">

			<%
			SongDAOImpl dao1 = new SongDAOImpl(DBConnect.getConn());
			List<songdtls> list = dao1.getRecentsongs();
			for (songdtls s : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img src="music-img/<%=s.getPicName()%>" alt="Album Image"
							class="img-thumblin round-image"
							style="width: 200px; height: 200px; border-radius: 50%;">

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
							<%
							if (u == null) {
							%>
							<a href="login.jsp" class="btn btn-success btn-sm ml-5">Add to cart</a>
							<%
							} else {
							%>
							<a href="cart?sid=<%=s.getId()%>&&uid=<%=u.getId()%>"
								class="btn btn-success btn-sm ml-5"
								onclick="showToast('Song successfully ordered')">Add to cart</a>
							<%
							}
							%>
							 <a
								href="" class="btn btn-danger btn-sm ml-2">$<%=s.getPrice()%></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>



		</div>
		<div class="text-center mt-3">
			<a href="all_recentsong.jsp" class="btn btn-danger btn-sm">Veiw
				all</a>
		</div>
	</div>

	<!-- end -->

	<hr>
	<!-- Bollywood Songs -->
	<div class="container">
		<h3 class=" text-center mb-3 mt-3">Bollywood Songs</h3>
		<div class="row">

			<%
			SongDAOImpl dao = new SongDAOImpl(DBConnect.getConn());
			List<songdtls> list1 = dao.getNewsongs();
			for (songdtls s : list1) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img src="music-img/<%=s.getPicName()%>" alt="Album Image"
							class="img-thumblin round-image"
							style="width: 200px; height: 200px; border-radius: 50%;">
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
							<%
							if (u == null) {
							%>
							<a href="login.jsp" class="btn btn-success btn-sm ml-5">Add to cart</a>
							<%
							} else {
							%>
							<a href="cart?sid=<%=s.getId()%>&&uid=<%=u.getId()%>"
								class="btn btn-success btn-sm ml-5"
								onclick="showToast('Song successfully ordered')">Add to cart</a>
							<%
							}
							%>
							<a href="" class="btn btn-danger btn-sm ml-3">$<%=s.getPrice()%></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>




		</div>
		<div class="text-center mt-3">
			<a href="all_bollywoodsong.jsp" class="btn btn-danger btn-sm">Veiw
				all</a>
		</div>
	</div>

	<!-- end Bollywood song -->
	<hr>
	<!-- pop -->
	<div class="container">
		<h3 class=" text-center mb-3 mt-3">South Songs</h3>
		<div class="row">

			<%
			SongDAOImpl dao2 = new SongDAOImpl(DBConnect.getConn());
			List<songdtls> list2 = dao2.getSouthsongs();
			for (songdtls s : list2) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img src="music-img/<%=s.getPicName()%>" alt="Album Image"
							class="img-thumblin round-image"
							style="width: 200px; height: 200px; border-radius: 50%;">
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
							<%
							if (u == null) {
							%>
							<a href="login.jsp" class="btn btn-success btn-sm ml-5 onclick="
								showToast('Song successfullyordered')">Add to cart</a>
							<%
							} else {
							%>
							<a href="cart?sid=<%=s.getId()%>&&uid=<%=u.getId()%>"
								class="btn btn-success btn-sm ml-5">Add to cart</a>
							<%
							}
							%>
							<a href="" class="btn btn-danger btn-sm ml-3">$<%=s.getPrice()%></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>




		</div>
		<div class="text-center mt-3">
			<a href="all_southsong.jsp" class="btn btn-danger btn-sm">Veiw
				all</a>
		</div>
	</div>

	<!-- pop -->
	<hr>
	<!-- Instument -->
	<div class="container">
		<h3 class=" text-center mb-3 mt-3">Instrument</h3>
		<div class="row">

			<%
			InstrumentDAOImpl dao4 = new InstrumentDAOImpl(DBConnect.getConn());
			List<instrument> list4 = dao4.getInstruments();
			for (instrument i : list4) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img src="instru-img/<%=i.getPicName()%>" alt="Album Image"
							class="img-thumblin round-image mb-2"
							style="width: 200px; height: 200px; border-radius: 50%;">
							<br>
						<p><%=i.getInstruname()%>
						</p>
						
						<div class="row">
							<%
							if (u == null) {
							%>
							<a href="login.jsp" class="btn btn-success btn-sm ml-5 onclick="
								showToast('Song successfully ordered')">Add to cart</a>
							<%
							} else {
							%>
							<a href="cart2?iid=<%=i.getId()%>&&uid=<%=u.getId()%>"
								class="btn btn-success btn-sm ml-5">Add to cart</a>
							<%
							}
							%>
							<a href="" class="btn btn-danger btn-sm ml-3">$<%=i.getPrice()%></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>




		</div>
		<div class="text-center mt-3">
			<a href="all_southsong.jsp" class="btn btn-danger btn-sm">Veiw
				all</a>
		</div>
	</div>
	<div style="margin-top: 130px;">
		<%@include file="all_components/footer.jsp"%></div>
</body>
</html>