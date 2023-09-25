<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<div class="container-fluid"
	style="height: 15px; background-color: #1a237e"></div>
<div class="container-fluid p-3 bg-Light">
	<div class="row">
		<div class="col-md-3 text-red">
			<h3>
				<i class="fas fa-music"></i> Music Store
			</h3>
		</div>
<div class="col-md-3 offset-md-5 text-right">
				<c:if test="${not empty userobj }">
					<a href="../login.jsp" class="btn btn-success"><i
						class="fas fa-user"></i>${userobj.name }</a>
						<a href="../Logout" class="btn btn-success"><i
						class="fas fa-sign-in-alt"></i>Logout</a>
						</c:if>
			</div>

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
			<li class="nav-item active"><a class="nav-link" href="home.jsp"><i
					class="fas fa-home"></i>Home <span class="sr-only">(current)</span>
			</a></li>
			
			<li class="nav-item"
				style="display: flex; align-items: center; margin-left: 500px; font-size: 28px; color: white; font-family: 'Pacifico', cursive;">Hello
				admin!</li>
 
		</ul>
		
 
	</div>
</nav>
