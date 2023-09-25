<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<div class="container-fluid" style="height:15px;background-color:#1a237e" ></div>
<div class="container-fluid p-3 bg-Light">
	<div class="row">
		<div class="col-md-3 text-red">
			<h3><i class="fas fa-music"></i> Music Store</h3>
		</div>
		<div class="col-md-6">
			<form class="form-inline my-2 my-lg-0">
				<!--  <input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">-->
				<!--  <button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>-->
			</form>
		</div>
		<c:if test="${not empty userobj }">
		<div class="col-md-3">
		<a href="cart.jsp" ><i class="fas fa-cart-plus"></i></a>
		 <a href="login.jsp" class="btn btn-success">${userobj.name }</a>
		  <a href="Logout" class="btn btn-primary">Logout</a>
		  <a href="cart2.jsp" ><i class="fas fa-cart-plus"></i></a>
		 </div>
		 </c:if>
		 
		 <c:if test="${ empty userobj }">
		<div class="col-md-3">
		 <a href="login.jsp" class="btn btn-success">Login</a>
		  <a href="signup.jsp" class="btn btn-primary">Register</a>
		 </div>
		 </c:if>
	</div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-custom">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
		
			<li class="nav-item active"><a class="nav-link" href="index.jsp"><i class="fas fa-home"></i>Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link" href="all_recentsong.jsp"><i class="fas fa-music"></i> New Songs</a></li>
			<li class="nav-item active"><a class="nav-link" href="all_southsong.jsp"><i class="fas fa-headphones"></i> South song</a></li>
			<li class="nav-item active"><a class="nav-link " href="all_bollywoodsong.jsp"><i class="fas fa-guitar"></i> Bollywood songs</a>
			</li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
		
		 <a href="order.jsp">	<div class="btn btn-light my-2 my-sm-0 mr-2" type="submit"><i class="fas fa-user"></i>Song Orders</div></a>
		  <a href="Order2.jsp">	<div class="btn btn-light my-2 my-sm-0 mr-2" type="submit"><i class="fas fa-user"></i>Instrument Orders</div></a>
		<!--  	<button class="btn btn-light my-2 my-sm-0 ml-1" type="submit"><i class="fas fa-address-book"></i> contact</button> -->
		</form>
	</div>
</nav>