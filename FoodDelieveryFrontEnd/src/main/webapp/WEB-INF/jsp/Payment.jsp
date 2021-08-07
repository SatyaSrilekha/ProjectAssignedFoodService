<title>Payment</title>
<h1 style="font-family: Lucida Handwriting;color:Ivory;"><b><u>Payment</u></b>
</h1>

<style>
h1 {
	text-align: center;
}
</style>
<style>
body
{	
	background-repeat:no-repeat;
	background-size:100% 200%;
}
</style>

<body background="images/pink.jpg">

<br/><br/><br/><br/>
<form action="<c:url value='/insertPayment'/>" method="post">
<table align="center" class="table table-condensed" width="50%">
	<tr>
		<td colspan="2"><center><h2 style="color:MediumVioletRed";><marquee>Pay here!!!</marquee></h2></center></td>
	</tr></br>
	<tr>
		<td><h3 style="color:Ivory";>Payment Id</td>
		<td><input type="text" name="paymentId"/></td>
	</tr>
	<tr>
		<td><h3 style="color:Ivory";>Order Id </td>
		<td> <input type="text" name="orderId"/></td>
	</tr>
	<tr>
		<td><h3 style="color:Ivory";>Mode Of Transaction</td>
		<td><input type="text" name="ModeOfTrans"/></td>
	</tr>
	<tr>
		<td><h3 style="color:Ivory";>Mobile Number </td>
		<td> <input type="text" name="mobileNumber"/></td>
	</tr>
	<tr>
		<td><h3 style="color:Ivory";>Total </td>
		<td> <input type="text" name="total"></td>
	</tr>
	<tr>
		<td colspan="2">
			<center>
			<input type="submit" value="Pay" class="btn btn-success"/>
			</center>
		</td>
	</tr>
</table>
</form>

<!--<table align='center' cellspacing="3" cellpadding="3" class="table">
		<tr bgcolor="cyan">
			<td>Payment Id</td>
			<td>Order Id</td>
			<td>Mode Of Transaction</td>
			<td>MobileNumber</td>
			<td>Total</td>
		</tr>
		<c:forEach items="${paymentList}" var="payment">
		<tr bgcolor="pink">
			<td>${payment.paymentId}</td>
			<td>${payment.orderId}</td>
			<td>${payment.modeOfTrans}</td>
			<td>${payment.mobileNumber}</td>
			<td>${payment.total}</td>
			<td>
				<a href="<c:url value='/deletePayment/${payment.paymentId}'/>">Delete</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="<c:url value='/editPayment/${payment.paymentId}'/>">Edit</a>
			</td>
		</tr>
		</c:forEach>-->
</table>


</body>
</html>