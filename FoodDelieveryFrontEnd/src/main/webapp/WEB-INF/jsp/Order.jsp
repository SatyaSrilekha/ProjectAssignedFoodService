

<title>Order</title>
<h1 style="font-family: Lucida Handwriting;color:SlateBlue;"><b><u>ORDER</u></b>
</h1>

<style>
h1 {
	text-align: center;
}
</style>
<style>
body {
	background-repeat: no-repeat;
	background-size:100% 130%;
}
</style>

<body background="images/yellow.jpg">
<form action="<c:url value='/insertOrder'/>" method="post">
<table align="center" class="table table-condensed" width="50%">
	<tr>
		<td colspan="2"><center><h2 style="color:OrangeRed";><marquee>Place your order!!!</marquee></h2></center></td>
	</tr></br>
	<tr>
		<td><h3>Order ID</h3></td>
		<td><input type="text" name="orderId"/></td>
	</tr>
	<tr>
		<td><h3>Item Name</h3> </td>
		<td> <input type="text" name="itemName"/></td>
	</tr>
	<tr>
		<td><h3>Order Date</h3></td>
		<td><input type="text" name="orderDate"/></td>
	</tr>
	<tr>
		<td><h3>Amount</h3> </td>
		<td> <input type="text" name="amount"/></td>
	</tr>
	<tr>
		<td><h3>MobileNumber</h3> </td>
		<td> <input type="text" name="mobileNumber"></td>
	</tr>
	<tr>
		<td colspan="2">
			<center>
			<input type="submit" value=" Proceed Order" class="btn btn-success"/>
			</center>
		</td>
	</tr>
</table>
</form>

<!-- <table align='center' cellspacing="3" cellpadding="3" class="table">
		<tr bgcolor="DeepSkyBlue">
			<td>Order Id</td>
			<td>Item Name</td>
			<td>Order Date</td>
			<td>Amount</td>
			<td>MobileNumber</td>
		</tr>
		<c:forEach items="${orderList}" var="order">
		<tr bgcolor="Aquamarine">
			<td>${order.orderId}</td>
			<td>${order.itemName}</td>
			<td>${order.orderDate}</td>
			<td>${order.amount}</td>
			<td>${order.mobileNumber}</td>
			  <td>
				<a href="<c:url value='/deleteOrder/${order.orderId}'/>">Delete</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="<c:url value='/editOrder/${order.orderId}'/>">Edit</a>
			</td>
		</tr>
		</c:forEach>
</table>-->


</body>
</html>