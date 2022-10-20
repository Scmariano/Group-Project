<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <!-- CSS -->
   
    <!-- Bootstrap -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
     <link rel="stylesheet" href="/css/style.css" />
    <title>Tres Amigos Clothier</title>
  </head>
  <body>
    <!-- Page Title Display -->
    <div class="container">
      <h5>Welcome to</h5>
      <h1>Tres Amigos</h1>
      <h3>Clothier</h3>
    </div>

    <!-- Register/Login Forms -->
    <div class="forms">        <!-- Register -->
        <div class="register">
          <h1>Sign Up</h1>
          <form:form action="/register" method="POST" modelAttribute="newUser">
                   
            
           	<div class="row">
            	<form:input type="email" class="input" path="email" placeholder="Email"/>
            	<form:errors path="email" class="text-danger" />
            </div>

			<div class="row">
            	<form:input type="password" class="input" path="password" placeholder="Password"/>
            	<form:errors path="password" class="text-danger" />
            </div>

			<div class="row">
            	<form:input type="password" class="input" path="confirm" placeholder="Confirm Password"/>
            	<form:errors path="confirm" class="text-danger" />
			</div>
				
            <input class="btn btn-outline-dark" type="submit" value="Register" />
          </form:form>
        </div>

        <!-- Login -->
        <div class="login">
          <h1>Log In</h1>
          <form:form action="/login" method="POST" modelAttribute="newLogin">
          
            <div class="row">
            	<form:input type="email" class="input" path="email" placeholder="Email"/>
            	<form:errors path="email" class="text-danger" />
            </div>

			<div class="row">
            	<form:input type="password" class="input" path="password" placeholder="Password"/>
            	<form:errors path="password" class="text-danger" />
            </div>

            <input class="btn btn-outline-dark" type="submit" value="Log In" />
          </form:form>
        </div>
      </div>
  </body>
</html>