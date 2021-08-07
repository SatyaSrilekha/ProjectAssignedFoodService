<h1 style="font-family: Lucida Handwriting;color:HotPink;"><b><u>ITEMS</u></b>
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
<form action="<c:url value='/insertItem'/>" method="post">
<table align="center" class="table table-condensed" width="50%">
	<tr>
		<td colspan="2"><center>Manage Category</center></td>
	</tr>
	<tr>
		<td>Item ID</td>
		<td><input type="text" name="itemId"/></td>
	</tr>
	<tr>
		<td>Item Name </td>
		<td> <input type="text" name="itemName"/></td>
	</tr>
	<tr>
		<td>CategoryId </td>
		<td><input type="text" name="categoryId"></td>
	</tr>
	<tr>
		<td>SupplierId</td>
		<td> <input type="text" name="supplierId"/></td>
	</tr>
	<tr>
		<td>Stock </td>
		<td><input type="text" name="stock"></td>
	</tr>
	
	<tr>
		<td colspan="2">
			<center>
			<input type="submit" value="Insert Item" class="btn btn-success"/>
			</center>
		</td>
	</tr>
</table>
</form>

<table align='center' cellspacing="3" cellpadding="3" class="table">
		<tr bgcolor="lightsalmon">
			<td>Item Id</td>
			<td>Item Name</td>
			<td>Category Id</td>
			<td>Supplier Id</td>
			<td>Stock</td>
			<td>Operation</td>
			
		</tr>
		<c:forEach items="${itemList}" var="item">
		<tr bgcolor="lightsteelblue">
			<td>${item.itemId}</td>
			<td>${item.itemName}</td>
			<td>${item.categoryId}</td>
			<td>${item.supplierId}</td>
			<td>${item.stock}</td>
			<td>
				<a href="<c:url value='/deleteItem/${item.itemId}'/>">Delete</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="<c:url value='/editItem/${item.itemId}'/>">Edit</a>
			</td>
		</tr>
		</c:forEach>
</table>


</body>
</html>