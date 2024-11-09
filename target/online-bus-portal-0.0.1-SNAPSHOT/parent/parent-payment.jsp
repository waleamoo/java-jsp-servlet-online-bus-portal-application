<%@ include file="/static/header.jsp"%>
<%@ page
	import="java.util.*, com.techqwerty.dto.*, java.text.SimpleDateFormat, java.time.LocalDate"%>
<div class="container my-4">
	<div class="row">

		<%@ include file="/static/parent-sidebar.jsp"%>

		<div class="col-lg-9">
			<div class="row">

				<div class="col-12">

					<h2>Make a payment</h2>
					<p>Select a transporting plan.</p>

					<form id="payment-form" method="POST">
						
						<h2>Choose Bus Transportation Ticket Plan</h2>

						<hr>

						<div class="form-check form-check-inline">
							<label class="form-check-label"> <input
								class="form-check-input" type="radio" name="journey" id="1m"
								value="420.00" required> R420 (1 month)
							</label> &nbsp; <label class="form-check-label"> <input
								class="form-check-input" type="radio" name="journey" id="2m"
								value="840.00" required> R840 (2 month)
							</label> &nbsp; <label class="form-check-label"> <input
								class="form-check-input" type="radio" name="journey" id="3m"
								value="1260.00" required> R1,260 (3 month)
							</label> &nbsp;
						</div>

						<br>

						<!-- <h2>Payment</h2>
						<hr>

						<div class="form-group">
							<label for="card_number">Card Number</label> <input type="text"
								class="form-control" name="card_number" id="card_number"
								placeholder="####-####-####-####" required>
						</div>

						<div class="form-group">
							<label for="card_expiry_date">Card Expiry Date</label> <input
								type="text" class="form-control" name="card_expiry_date"
								id="card_expiry_date" placeholder="06/26" required>
						</div>

						<div class="form-group">
							<label for="card_cvv">CVV</label> <input type="text"
								class="form-control" name="card_cvv" id="card_cvv"
								placeholder="CVV" maxlength="3" required>
						</div>

						<div class="form-group">
							<label for="card_pin">PIN</label> <input type="password"
								class="form-control" name="card_pin" id="card_pin" maxlength="4"
								required>
						</div> -->
						
						<input type="hidden" name="user_email" id="user_email" value="<%= session.getAttribute("parent_email") %>"> 
						  <input type="hidden" name="amount" id="amount" value=""> 
						  <input type="hidden" name="cartid" id="cartid" value="<%= session.getAttribute("studentId") %>"> 
						  <input type="hidden" name="callback_url" id="callback_url" value="<%= application.getInitParameter("WebAppContextPath") + "thank-you" %>">
						
						<input type="image" src="${pageContext.request.contextPath}/resources/images/paystack-btn.png" name="pay_now" id="pay-now" title="Pay now" class="mb-4" />
						
					</form>

				</div>

			</div>

		</div>
	</div>
</div>

<%@ include file="/static/footer.jsp"%>