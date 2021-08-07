


<html>
<head>
</style>
	<style>
* {
  box-sizing: border-box;
}

.row {
  display: flex;
}


.column {
  flex: 33.33%;
  padding: 5px;
}
</style>
	
</head>
<body>
<form action="<c:url value='/categoryDisplay'/>" method="post">
	<h1>Categories available</h1>
	<table align='center' cellspacing="3" cellpadding="3" class="table">
		<tr bgcolor="cyan">
			<td>Category Id</td>
			<td>Category Name</td>
		</tr>
		<c:forEach items="${categoryList}" var="category">
		<tr bgcolor="pink">
			<td>${category.categoryId}</td>
			<td>${category.categoryName}</td>
		</tr>
		</c:forEach>
	</table>

	<div class="row">
  		<div class="column">	
				<img src="images/breadgif.gif" alt="bread" width="200">
		</div>
		<div class="column">
				<img src="images/cakegif.gif" alt="cake" width="200"><br><br>
		</div>	
		<div class="column">
				<img src="images/dosagif.gif" alt="dosa" width="200"><br><br>
		</div>		
		<div class="column">
				<img src="images/ice-creamgif.gif" alt="icecream" width="200"><br><br>
		</div>		
		<div class="column">
				<img src="images/pizzagif.gif" alt="pizza" width="200"><br><br>
		</div>		
		<div class="column">
				<img src="images/ricegif.gif" alt="rice" width="200"><br><br>
		</div>
	</div>
	</form>
</body>
</html>