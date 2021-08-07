<%@include file="Home.jsp" %>

<br/><br/><br/><br/>

<table align="center" class="table">
	<tr bgcolor="pink">
		<td colspan="2">
			Confirm Your Details
		</td>
	</tr>
	<tr>
		<td> User Name </td>
		<td> ${userDetail.userName}</td>
	</tr>
	<tr>
		<td> Password </td>
		<td> ********* </td>
	</tr>
	<tr>
		<td>Enabled</td>
		<td>${userDetail.enabled}</td>
	</tr>
	<tr>
		<td>Role</td>
		<td>${userDetail.role}</td>
	</tr>
	<tr>
		<td>Customer EmailId</td>
		<td>${userDetail.emailId}</td>
	</tr>
	<tr>
		<td>Mobile Number</td>
		<td>${userDetail.contactNo}</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="login">Confirm & Sign In</a>
			&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="register">Edit Detail</a>
		</td>
	</tr>

</table>

Details Customer Name : 

</body>
</html>