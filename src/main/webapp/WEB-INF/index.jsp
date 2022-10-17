<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%> <%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
	
    <link
	  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	  rel="stylesheet"
	/>
	<link rel="stylesheet" type="text/css" href="/css/home.css" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" 
		rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>Tres Amigos|Home</title>
  
  </head>
  <body>
	<nav id="navbar" class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
		<div class="title">
			<img src="/img/logo.png" class="logo"/>
			<a class="navbar-brand" href="#"><span class="row bigger">Tres Amigos</span><span class="row smaller">Clothier</span></a>
		</div>
		<a class="fa-solid fa-cart-shopping fa fa-2xl" href="/cart"></a>
	</nav>
    <!--  -->
    <div class="section">
		<img src="/img/carousel1.jpg" class="header img-fluid" />
    </div>

    <!-- Product list. Will improve the appearance after functionality is added -->
    <div>
      <a href="url">Shirt</a>
      <a href="url">Pants</a>
      <a href="url">Tie</a>
      <a href="url">Shoes</a>
    </div>
    
    
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
  </body>
</html>