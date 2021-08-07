
<title>Register</title>
<h1 style="font-family: Lucida Handwriting;color:HotPink;"><b><u>REGISTER</u></b>
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
<br><br>
<body background="images/lavender.jpg">
	<h2 style="color:ForestGreen";><marquee>Register here!!!</marquee></h2><br><br>
	
	
	<h3><form action="<c:url value='/registerUser'/>" method="post">		
			<center>
				User Name:     <input type="text" name="userName" required /><br><br>
				
				 Password: 	   <input type="password" name="password" required /><br><br>
				 				 
				  EmailId: <input type="text" name="emailId" required/><br><br>
			
			 MobileNumber: <input type="text" name="mobileNumber" required/><br><br>
			
				  Address: <textarea name="address" cols="30" rows="6" required></textarea><br><br>
			
							<input type="submit" value="Submit" />
		</center>
	</form></h3>
	
</body>
</html>