<%@include file="Home.jsp"%>

<title>Items</title>
</head>
<body>
<h1>Items available</h1>
	<table align='center' cellspacing="3" cellpadding="3" class="table">
		<tr bgcolor="cyan">
			<td>Item Id</td>
			<td>Item Name</td>
			<td>Category Id</td>
			<td>Stock</td>
		</tr>
		<c:forEach items="${itemList}" var="item">
		<tr bgcolor="pink">
			<td>${item.itemId}</td>
			<td>${item.itemName}</td>
			<td>${item.categoryId}</td>
			<td>${item.stock}</td>
		</tr>
		</c:forEach>
</table>
</body>
</html>