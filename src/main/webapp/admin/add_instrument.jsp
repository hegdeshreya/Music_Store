<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>addInstumrnt</title>
<%@include file="allCss.jsp"%>
<style type="text/css">
.rounded-form {
	border-radius: 15px;
	/* Adjust the value to control the amount of rounding */
	background-color: #f8f9fa; /* Adding a light background color */
	padding: 30px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Adding a subtle shadow */
}

.rounded-form1 {
	border-radius: 15px;
	/* Adjust the value to control the amount of rounding */
	background-color: #f8f9fa; /* Adding a light background color */
	padding: 20px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.4); /* Adding a subtle shadow */
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<h1 class="text-center">Add New Instrument</h1>

<c:if test="${not empty succMsg}">
    <h5 class="text-center text-success">${succMsg}</h5>
    <c:remove var="succMsg" scope="session" />
</c:if>



	<div class="container p-3 ">
		<div class="rounded-form1">
			<div class="row">
				<div class="col-md-6 offset-md-3">
					<div class="card">
						<div class="card-body">


							<form action="../add_instrument" method="post"
								enctype="multipart/form-data">
								<%-- encttype beacuse we used pic --%>
								<div class="rounded-form">
									<div class="form-group">
										<label for="songTitle">Instument Name</label> <input
											type="text" class="form-control" id="songTitle" name="iname"
											required>

										<div class="form-group">
											<label for="album">Price</label> <input type="number"
												class="form-control" id="album" name="price">
										</div>

										<div class="form-group">
											<label for="album">Quantity</label> <input type="number"
												class="form-control" id="album" name="quantity">
										</div>
										
										<div class="form-group">
											<label for="albumPicture"> Picture</label> <input
												type="file" class="form-control-file" id="albumPicture"
												name="img" accept="image/*">
										</div>

										<div class="text-center">
											<button type="submit" class="btn btn-primary mt-3">Add
												Instument</button>
										</div>
									</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>