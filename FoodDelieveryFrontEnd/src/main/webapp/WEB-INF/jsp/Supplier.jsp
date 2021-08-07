<head>
<title>Suppliers</title>
<h1 style="font-family: Lucida Handwriting;color:HotPink;"><b><u>SUPPLIERS</u></b>
</h1>

<style>
h1 {
	text-align: center;
}
</style>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<br/><br/><br/><br/>
<form action="<c:url value='/insertSupplier'/>" method="post">
<table align="center" class="table table-condensed" width="50%">
	<tr>
		<td colspan="2"><center>Manage Supplier</center></td>
	</tr>
	<tr>
		<td>Supplier ID</td>
		<td><input type="text" name="supplierId"/></td>
	</tr>
	<tr>
		<td>Supplier Name </td>
		<td> <input type="text" name="supplierName"/></td>
	</tr>
	<tr>
		<td>Supplier Description </td>
		<td> <textarea cols="30" rows="5" name="supplierDesc"></textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<center>
			<input type="submit" value="Insert Supplier" class="btn btn-success"/>
			</center>
		</td>
	</tr>
</table>
</form>

<table align='center' cellspacing="3" cellpadding="3" class="table">
		<tr bgcolor="LightSkyBlue">
			<td>Supplier Id</td>
			<td>Supplier Name</td>
			<td> Supplier Description</td>
			<td>Operation</td>
		</tr>
		<c:forEach items="${supplierList}" var="supplier">
		<tr bgcolor="LightGreen">
			<td>${supplier.supplierId}</td>
			<td>${supplier.supplierName}</td>
			<td>${supplier.supplierDesc}</td>
			<td>
				<a href="<c:url value='/deleteSupplier/${supplier.supplierId}'/>">Delete</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="<c:url value='/editSupplier/${supplier.supplierId}'/>">Edit</a>
			</td>
		</tr>
		</c:forEach>
</table>


</body>
</html>