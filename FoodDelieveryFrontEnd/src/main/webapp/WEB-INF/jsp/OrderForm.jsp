<%@include file="Home.jsp" %>

<br/><br/><br/><br/>
<form action="<c:url value='/addOrder'/>" method="post">
<table align="center" class="table table-condensed" width="50%">
	<tr>
		<td colspan="2"><center>Manage Order</center></td>
	</tr></br>
	<tr>
		<td>Order ID</td>
		<td><input type="text" name="orderId"/></td>
	</tr>
	<tr>
		<td>Item Name </td>
		<td> <input type="text" name="itemName"/></td>
	</tr>
	<tr>
		<td>Order Date</td>
		<td><input type="text" name="orderDate"/></td>
	</tr>
	<tr>
		<td>Amount </td>
		<td> <input type="text" name="amount"/></td>
	</tr>
	<tr>
		<td>mobileNumber </td>
		<td> <input type="text" name="mobileNumber"></td>
	</tr>
	<tr>
		<td colspan="2">
			<center>
			<input type="submit" value="Insert Order" class="btn btn-success"/>
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
			</td>-->
		</tr>
		</c:forEach>
</table>


</body>
</html>