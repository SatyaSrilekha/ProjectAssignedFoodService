<%@include file="Home.jsp" %>

<div class="table-responsive">
<form action="<c:url value='/updateCategory'/>" method="post">
<table align="center" class="table ">
	<tr>
		<td colspan="2"><center>Sign Up Here</center></td>
	</tr>
	<tr>
		<td>Category ID</td>
		<td><input type="text" name="categoryId" value="${category.categoryId}"/></td>
	</tr>
	<tr>
		<td>Category Name </td>
		<td> <input type="text" name="categoryName" value="${category.categoryName}"/></td>
	</tr>
	<tr>
		<td>Category Description </td>
		<td> <textarea cols="30" rows="5" name="description">${category.description}</textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<center>
			<input type="submit" value="Update Category"/>
			</center>
		</td>
	</tr>
</table>
</form>
</div>

</body>
</html>