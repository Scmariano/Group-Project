<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%> <%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />

    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <!-- Bootstrap -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

    <title>Tres Amigos|Cart</title>
  </head>
  <body>
    <!-- Header -->
    <div class="container">
      <h1>Tres Amigos</h1>
      <h2>Clothier</h2>
    </div>

    <!-- User's first name must be included here -->
    <div>
      <p>Thank you for shopping with us ${ product.users.first_name }! Please checkout below.</p>
    </div>

    <!-- Cart Items -->
    <div>
      <a href="url">Shoes</a> |
      <a href="/products/${ product.id }/edit">Edit</a>
      <a href="/products/${ product.id }/delete">Delete</a>

      <a href="url">Shirt</a> |
      <a href="/products/${ product.id }/edit">Edit</a>
      <a href="/products/${ product.id }/delete">Delete</a>
    </div>
  </body>
</html>

