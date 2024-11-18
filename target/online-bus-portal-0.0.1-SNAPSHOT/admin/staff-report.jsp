<%@ include file="/static/header.jsp" %>
<%@ page import="java.util.*, com.techqwerty.dto.*" %>
<div class="container my-4">
    <div class="row">

        <div class="col-lg-12">
            <div class="row">

                <div class="col-12">
                    <ul class="navbar-nav">
                        <li>
                            <a href="<%= request.getContextPath() %>/staff-dashboard" class="nav-list">Staff Dashboard</a>
                        </li>
                    </ul>
                    <h2>Management Information System (MIS) Report. </h2>
                </div>
                
                <div class="row">
                 	<div class="col-md-6 border-1">
                 		<div class="card card-body">
                 			<div class="card-title">Daily Report - Student Subscription for each bus (Active and Non-active Registrations)</div>
                        	<canvas id="student-bus-capacity"></canvas>
                 		</div>
                 	</div>
                 	<div class="col-md-6">
                 		<div class="card card-body">
                 			<div class="card-title">Daily Report - Student Subscription for each bus (Active Registrations Only)</div>
                        	<canvas id="student-bus-capacity-active"></canvas>
                 		</div>
                 	</div>
                 	
                 </div>
                 
                <div class="row">
                 	<div class="col-md-6 border-1">
                 		<div class="card card-body">
                 			<div class="card-title">Weekly Report - Students using the bus for the current week (Active Registrations Only)</div>
                        	
                        	<% var reports = (List<BusCapacityRequestDto>) request.getAttribute("busCapacityWeeklyReport"); %>
                    
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Bus Label</th>
                                <th>Bus Capacity</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<% if(reports.size() > 0){ %>
	                        	<% for(BusCapacityRequestDto report : reports){ %>
	                            	<tr>
	                            		<td><%= report.bus_label %></td>
	                            		<td><%= report.bus_count %></td>
	                            	</tr>
							    <% } %>
						    <% }else{ %>
						    	<tr>
							    	<td colspan="2">No report</td>
							    </tr>
						    <% } %>
                        </tbody>
                    </table>
                    
                        	
                 		</div>
                 	</div>
                 	<div class="col-md-6">
                 		<div class="card card-body">
                 			<div class="card-title">Monthly Report - Student who joined the waiting list for the current month</div>
                        	<b class="text-danger"><%= request.getAttribute("busWaitingListCurentMonthReport") %> students</b> 
                        	
                 		</div>
                 	</div>
                 	
                 </div>

            </div>
            <!-- /.row -->

        </div>
    </div>
</div>

<%@ include file="/static/footer.jsp" %>