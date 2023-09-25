<%@ page import="com.DB.DBConnect"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="com.DAO.SongDAOImpl"%>
<%@ page import="com.entity.songdtls"%>
<%@ page import="java.util.List"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bollywood</title>
<%@include file="all_components/allCss.jsp"%>
<style type="text/css">


#toast {
	min-width: 300px;
	position: fixed;
	bottom: 30px;
	left: 50%;
	margin-left: -125px;
	background: #333;
	padding: 10px;
	color: white;
	text-align: center;
	z-index: 1;
	font-size: 18px;
	visibility: hidden;
	box-shadow: 0px 0px 100px #000;
}

#toast.display {
	visibility: visible;
	animation: fadeIn 0.5, fadeOut 0.5s 2.5s;
}

@keyframes fadeIn {from { bottom:0;
	opacity: 0;
}

to {
	bottom: 30px;
	opacity: 1;
}

}
@keyframes fadeOut {form { bottom:30px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}
}
</style>
</head>
<body>
<%
User u=(User)session.getAttribute("userobj");
%>
<!-- Include this snippet within the <body> tag -->
<div id="toast" class="display">
    <span id="toastMessage">${addcart}</span>
</div>

<script type="text/javascript">
    // Check if the toastMessage element contains text, and display the toast accordingly
    var toastMessage = document.getElementById("toastMessage");
    if (toastMessage.textContent !== "") {
        showToast(toastMessage.textContent);
    }

    function showToast(message) {
        var toast = document.getElementById("toast");
        toast.classList.add("display");
        toastMessage.textContent = message;
        setTimeout(function () {
            toast.classList.remove("display");
            toastMessage.textContent = ""; // Clear the message after displaying
        }, 2000);
    }
</script>



	<%@include file="all_components/navbar.jsp"%>
	<div class="container p-3">
		<div class="row">
			<%
			SongDAOImpl dao1 = new SongDAOImpl(DBConnect.getConn());
			List<songdtls>  list = dao1.getAllNewsongs();
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
						<%
						if(u==null){
							%>
							<a href="login.jsp" class="btn btn-success btn-sm ml-5">Buy</a>
							<% 
						}else{
							%>
							<a href="cart?sid=<%=s.getId() %>&&uid=<%=u.getId() %>" class="btn btn-success btn-sm ml-5">Add to cart</a>
							<% 
						}
						%>
							 <a href=""
								class="btn btn-danger btn-sm ml-3">$<%=s.getPrice()%></a>
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