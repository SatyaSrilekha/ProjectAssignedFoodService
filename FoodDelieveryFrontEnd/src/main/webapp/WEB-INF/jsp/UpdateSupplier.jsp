<%@include file="Home.jsp" %>

<div class="table-responsive">
<form action="<c:url value='/updateSupplier'/>" method="post">
<table align="center" class="table ">
	<tr>
		<td colspan="2"><center>Update Here</center></td>
	</tr>
	<tr>
		<td>Supplier ID</td>
		<td><input type="text" name="supplierId" value="${supplier.supplierId}"/></td>
	</tr>
	<tr>
		<td>Supplier Name </td>
		<td> <input type="text" name="supplierName" value="${supplier.supplierName}"/></td>
	</tr>
	<tr>
		<td>Supplier Description </td>
		<td> <textarea cols="30" rows="5" name="supplierDesc">${supplier.supplierDesc}</textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<center>
			<input type="submit" value="Update Supplier"/>
			</center>
		</td>
	</tr>
</table>
</form>
</div>

</body>
</html>