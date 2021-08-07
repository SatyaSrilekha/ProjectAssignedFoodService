<%@include file="Home.jsp" %>

<div class="table-responsive">
<form action="<c:url value='/updateItem'/>" method="post">
<table align="center" class="table ">
	<tr>
		<td colspan="2"><center>Update here</center></td>
	</tr>
	<tr>
		<td>Item ID</td>
		<td><input type="text" name="itemId" value="${item.itemId}"/></td>
	</tr>
	<tr>
		<td>Item Name </td>
		<td> <input type="text" name="itemName" value="${item.itemName}"/></td>
	</tr>
	<tr>
		<td>Category ID</td>
		<td><input type="text" name="categoryId" value="${item.categoryId}"/></td>
	</tr>
	<tr>
		<td>Supplier ID </td>
		<td> <input type="text" name="supplierId" value="${item.supplierId}"/></td>
	</tr>
	<tr>
		<td>Stock </td>
		<td> <input type="text"" name="stock" value="${item.stock}"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<center>
			<input type="submit" value="Update Item"/>
			</center>
		</td>
	</tr>
</table>
</form>
</div>

</body>
</html>