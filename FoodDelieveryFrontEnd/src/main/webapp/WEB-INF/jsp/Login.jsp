<%@include file="Home.jsp"%>

<br/><br/>

<div class="container login-container">
	<div class="row">
		<div class="col-md-6 login-form-1">
			<h3>Login</h3>
			<form action="perform_login" method="post">
				<div class="form-group">
					<input type="text" name="username" class="form-control" placeholder="Your Email *"	value="" />
				</div></br>
				<div class="form-group">
					<input type="password" name="password" class="form-control"	placeholder="Your Password *" value="" />
				</div>
				<div class="form-group">
					<input type="submit" class="btnSubmit" value="Login" />
				</div>
				<div class="form-group">
					<a href="#" class="ForgetPwd">Forget Password?</a>
				</div>
			</form>
		</div>
	</div>
</div>

</body>
</html>