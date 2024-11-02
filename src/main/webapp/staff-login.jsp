<% 
if(session.getAttribute("user_name") !=null){ 
  response.sendRedirect(application.getInitParameter("WebAppContextPath") + "/list" ); 
}
%>
<%@ include file="/static/header.jsp" %>
<div class="container my-4">
	<div class="row">

		<div class="col-lg-8 offset-lg-2">
			<div class="row">

				<div class="col-12">

					<h3>Administrative area</h3>

					<p class="text-muted">Provide your administrative credentials to login</p>

					<%@ include file="/static/errors.jsp" %>

						<form action="login-staff" method="post">

							<input type="hidden" name="action" value="staff-login">

							<div class="form-group">
								<label for="email">Staff Email</label>
								<input type="text" class="form-control" name="email" id="email"
									placeholder="Staff email">
								<small class="form-text text-muted">Enter staff email</small>
							</div>

							<div class="form-group">
								<label for="password">Staff Password</label>
								<input type="password" class="form-control" name="password" id="password"
									placeholder="Staff Password">
								<small class="form-text text-muted">Enter staff password</small>
							</div>

							<button type="submit" class="btn btn-success">Login Staff</button>

						</form>

				</div>

			</div>

		</div>

	</div>
</div>
<%@ include file="/static/footer.jsp" %>