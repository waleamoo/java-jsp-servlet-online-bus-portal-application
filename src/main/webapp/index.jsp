<%@ include file="/static/header.jsp" %>
<div class="container my-4">
	<div class="row">

		<div class="col-lg-8 offset-lg-2">
			<div class="row">

				<div class="col-12">

					<h3>Login to your online bus portal</h3>

					<p class="text-muted">Provide your credentials to login</p>

					<%@ include file="static/errors.jsp" %>

						<form method="post">
						
							<input type="hidden" name="action" value="parent-login" />
							
							<div class="form-group">
								<label for="email">Parent Email</label>
								<input type="text" class="form-control" name="email" id="email"
									placeholder="Parent email" value="<% if(request.getParameter("email") != null) out.print(request.getParameter("email")); %>">
								<small class="form-text text-muted">Enter parent email</small>
							</div>

							<div class="form-group">
								<label for="password">Parent Password</label>
								<input type="password" class="form-control" name="password" id="password"
									placeholder="Password">
								<small class="form-text text-muted">Enter parent password</small>
							</div>

							<button type="submit" class="btn btn-success">Login Parent</button>

							<p class="text-muted">Not yet a member? <a href="register-parent">Register yourself and your child now</a></p>

						</form>

				</div>

			</div>

		</div>

	</div>
</div>
<%@ include file="/static/footer.jsp" %>