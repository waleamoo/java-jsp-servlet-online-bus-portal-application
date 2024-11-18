<%@ include file="/static/header.jsp"%>
<%@ page import="java.util.*, com.techqwerty.dto.*"%>
<div class="container my-4">
	<div class="row">

		<div class="col-lg-12">
			<div class="row">

				<div class="col-12">
					<ul class="navbar-nav">
						<li><a href="<%= request.getContextPath() %>/staff-dashboard"
							class="nav-list">Staff Dashboard</a></li>
					</ul>
					<h2>Waiting List</h2>
				</div>

				<div class="row">
					<div class="col-md-12 border-1">
						<div class="card card-body">
							<% var waitingList = (List<BusWaitingListRequestDto>) request.getAttribute("busWaitingList"); %>
							<div class="card-title">
								There are currently <b class="text-danger"><%= waitingList.size() %>students</b> that joined 
								the waiting list today
							</div>


							<table class="table">
								<thead>
									<tr>
										<th>Student Name</th>
										<th>Student Address</th>
										<th>Parent Name</th>
										<th>Parent Email</th>
										<th>Parent Contact Number</th>
										<th>&nbsp;</th>
									</tr>
								</thead>
								<tbody>
									<% if(waitingList.size() > 0){ %>
									<% for(BusWaitingListRequestDto l : waitingList){ %>
									<tr>
										<td><%= l.studentName %></td>
										<td><%= l.studentAddress %></td>
										<td><%= l.parentEmail %></td>
										<td><%= l.parentEmail %></td>
										<td><%= l.parentContactNumber %></td>
										<td><a href="mailto:<%= l.parentEmail %>"
											class="btn btn-danger btn-sm">Email Parent</a> <a
											href="tel:<%= l.parentContactNumber %>"
											class="btn btn-info btn-sm">Call Parent</a></td>
									</tr>
									<% } %>
									<% }else{ %>
									<tr>
										<td colspan="5">No students in the waiting list for today</td>
									</tr>
									<% } %>
								</tbody>
							</table>

						</div>
					</div>

				</div>

			</div>
			<!-- /.row -->

		</div>
	</div>
</div>

<%@ include file="/static/footer.jsp"%>