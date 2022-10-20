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
		<c:if test="${ shoes.size() > 0 }">
    		<div class="item">
	    		<div id="card" class="card" style="width: 18rem;">
				 	<img src="${ shoes.get(0).image }" class="card-img-top">
				  	<div class="card-body">
				    	<h5 class="card-title"><c:out value="${ shoes.get(0).productName } "/>&emsp;<c:out value="$ ${ shoes.get(0).price * shoes.size() }"/></h5>
				    	<p class="card-text"><c:out value="${ shoes.get(0).description }"/></p>
				    	<a href="/edit/${ shoes.get(shoes.size() - 1).id }" class="editButton btn btn-outline-primary">Edit</a>
						<a href="/delete/${ shoes.get(shoes.size() - 1).id }" class="delete btn btn-outline-danger">Remove</a>
						<p class="amount">x<c:out value="${ shoes.size() }"></c:out></p>
				  	</div>
				</div>
			</div>
		</c:if>
    	<c:if test="${ shirts.size() > 0 }">
    		<div class="item">
	    		<div id="card" class="card" style="width: 18rem;">
				 	<img src="${ shirts.get(0).image }" class="card-img-top">
				  	<div class="card-body">
				    	<h5 class="card-title"><c:out value="${ shirts.get(0).productName } "/>&emsp;<c:out value="$ ${ shirts.get(0).price * shirts.size() }"/></h5>
				    	<p class="card-text"><c:out value="${ shirts.get(0).description }"/></p>
				    	<a href="/edit/${ shirts.get(shirts.size() - 1).id }" class="editButton btn btn-outline-primary">Edit</a>
						<a href="/delete/${ shirts.get(shirts.size() - 1).id }" class="delete btn btn-outline-danger">Remove</a>
						<p class="amount">x<c:out value="${ shirts.size() }"></c:out></p>
				  	</div>
				</div>
			</div>
		</c:if>
		<c:if test="${ ties.size() > 0 }">
    		<div class="item">
	    		<div id="card" class="card" style="width: 18rem;">
				 	<img src="${ ties.get(0).image }" class="card-img-top">
				  	<div class="card-body">
				    	<h5 class="card-title"><c:out value="${ ties.get(0).productName } "/>&emsp;<c:out value="$ ${ ties.get(0).price * ties.size() }"/></h5>
				    	<p class="card-text"><c:out value="${ ties.get(0).description }"/></p>
				    	<a href="/edit/${ ties.get(ties.size() - 1).id }" class="editButton btn btn-outline-primary">Edit</a>
						<a href="/delete/${ ties.get(ties.size() - 1).id }" class="delete btn btn-outline-danger">Remove</a>
						<p class="amount">x<c:out value="${ ties.size() }"></c:out></p>
				  	</div>
				</div>
			</div>
		</c:if>
		<c:if test="${ pants.size() > 0 }">
    		<div class="item">
	    		<div id="card" class="card" style="width: 18rem;">
				 	<img src="${ pants.get(0).image }" class="card-img-top">
				  	<div class="card-body">
				    	<h5 class="card-title"><c:out value="${ pants.get(0).productName } "/>&emsp;<c:out value="$ ${ pants.get(0).price * pants.size() }"/></h5>
				    	<p class="card-text"><c:out value="${ pants.get(0).description }"/></p>
				    	<a href="/edit/${ pants.get(pants.size() - 1).id }" class="editButton btn btn-outline-primary">Edit</a>
						<a href="/delete/${ pants.get(pants.size() - 1).id }" class="delete btn btn-outline-danger">Remove</a>
						<p class="amount">x<c:out value="${ pants.size() }"></c:out></p>
				  	</div>
				</div>
			</div>
		</c:if>
    	
    </div>
  </body>
</html>









