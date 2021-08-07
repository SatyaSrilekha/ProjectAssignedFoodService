<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Food Services</title>
	
		<h1 style="font-family: Lucida Handwriting;"><b><u>LEKHA'S FOODDEL</u></b></h1>
		
		<style>
			h1{text-align:center;color:Chocolate;}
		</style>	
	<style>
	
	<style>
		body
		{	
			background-repeat:repeat;
			background-size:1500% 1300%;
		}
	</style>
	
	<style>
		div.a
		{
			text-align:center;
		}
		
		div.b
		{
			text-align:center;
		}
		
		div.c
		{
			text-align:center;
		}
	</style>

</head>
<body>
<img src="<c:url value='/images/bg1.jpg'/> alt="img">
	<!--<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">-->
		<div class="a">
		<h2><p style="color:DarkViolet;"><i>A local food service which have wide 
				range of food varieties and provides parcel service.</i></p></h2>
	</div><br>
	<div class="b">		
		<h3><p style="color:DarkOrange;"><i>"LAUGHTER is BRIGHTEST,where FOOD is BEST...-Irish Proverb!!"</i></p></h3>		
	</div><br>	 				
	
	<h2 style="color:DeepPink;"><marquee>Welcome to Lekha's food!!!</marquee></h2><br><br>
	
		<aside>
			<h3><c:if test="${sessionScope.role==null}">
				<li class="nav-item"><a class="nav-link" href="#" >Home</a></li>
				<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="register">Register</a></li></h3>
				</c:if>
		</aside>
			<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
				<li class="nav-item"><a class="nav-link" href="AdminHome.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value='/category'/>">Manage Category</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value='/supplier'/>">Manage Supplier</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value='/item'/>">Manage Item</a></li>
				<!--  <li class="nav-item"><a class="nav-link" href="<c:url value='/order'/>">Order </a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value='/payment'/>">Payment</a></li>-->
			</c:if>
			<c:if test="${sessionScope.role=='ROLE_USER'}">
			<nav>
				<a href="UserHome.jsp">Home</a>||
				<a href="categoryDisplay">View Categories</a>||
				<a href="itemsDisplay">View Items</a>||
				<a href="order">Order</a>||
				<a href="payment">Payment</a>
			</nav>
			</c:if>
		
	
	<br />
	<br />
	<h2>Welcome :
		${sessionScope.userName}</div></h2>