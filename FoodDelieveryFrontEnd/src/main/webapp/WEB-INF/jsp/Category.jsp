<head>
<title>Categories</title>
<h1 style="font-family: Lucida Handwriting;color:HotPink;"><b><u>CATEGORIES</u></b>
</h1>

<style>
h1 {
	text-align: center;
}
</style>
<style> 
body {
  background-color: Thistle;
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
<form action="<c:url value='/insertCategory'/>" method="post">
	<table align="center" class="table table-condensed" width="50%">
		<tr>
			<td colspan="2"><center>Manage Category</center></td>
		</tr>
		<tr>
			<td>Category ID</td>
			<td><input type="text" name="categoryId" /></td>
		</tr>
		<tr>
			<td>Category Name</td>
			<td><input type="text" name="categoryName" /></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><textarea cols="30" rows="5" name="description"></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<center>
					<input type="submit" value="Insert Category"
						class="btn btn-success" />
				</center>
			</td>
		</tr>
	</table>
</form>
<div>	

	<table align='center' cellspacing="3" cellpadding="3" class="table">
		<tr bgcolor="cyan">
			<td>Category Id</td>
			<td>Category Name</td>
			<td>Description</td>
			<td>Operation</td>
		</tr>
		<c:forEach items="${categoryList}" var="category">
			<tr bgcolor="pink">
				<td>${category.categoryId}</td>
				<td>${category.categoryName}</td>
				<td>${category.description}</td>
				<td><a
					href="<c:url value='/deleteCategory/${category.categoryId}'/>">Delete</a>
					&nbsp;&nbsp;|&nbsp;&nbsp; <a
					href="<c:url value='/editCategory/${category.categoryId}'/>">Edit</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</div>
</body>
</html>