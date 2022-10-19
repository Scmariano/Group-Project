<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%> <%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
  <head>
  <title>Tres Amigos|Cart</title>
    <meta charset="UTF-8" />
    
    <link
	  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	  rel="stylesheet"
	/>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/css/home.css" />
  </head>
  <body>
    <!-- Header -->
    <nav id="navbar" class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
		<div class="title">
			<img src="/img/logo.png" class="logo"/>
			<a class="navbar-brand" href="#"><span class="row bigger">Tres Amigos</span><span class="row smaller">Clothier</span></a>
		</div>
		<a class="fa-solid fa-home fa fa-2xl" href="/dashboard"></a>
	</nav>

    <!-- User's first name must be included here -->
    <div class="heading">
      <p>Thank you for shopping with us <c:out value="${ user.name }"></c:out>! <br/>Please checkout below.</p>
    </div>
	<div class="cart-products">
    	<c:forEach var="product" items="${ products }">
    		<div class="item">
	    		<div id="card" class="card" style="width: 18rem;">
				 	<img src="${ product.image }" class="card-img-top">
				  	<div class="card-body">
				    	<h5 class="card-title"><c:out value="${ product.productName } $${ product.price }"/></h5>
				    	<p class="card-text"><c:out value="${ product.description }"/></p>
				    	<a href="/edit/${ product.id }" class="editButton btn btn-outline-primary">Edit</a>
						<a href="/delete/${ product.id }" class="delete btn btn-outline-danger">Remove</a>
				  	</div>
				</div>
			</div>
    	</c:forEach>
    </div>
  </body>
</html>