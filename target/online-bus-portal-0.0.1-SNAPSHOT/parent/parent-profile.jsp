<%@ include file="/static/header.jsp" %>
<%@ page import="java.util.*, com.techqwerty.dto.*, java.text.SimpleDateFormat, java.time.LocalDate" %>
<div class="container my-4">
    <div class="row" style="padding-bottom: 100px;">

        <%@ include file="/static/parent-sidebar.jsp" %>

        <div class="col-lg-9">
            <div class="row">

                <div class="col-12">
                    
                    <h2>Welcome to your profile area <b><%= session.getAttribute("parent_name") %></b> </h2>
                    <p>Below is the list of your wares we are transporting.</p>
                    
                    <% var theStudents = (List<StudentBusRequestDto>) request.getAttribute("listStudent"); %>
                    
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Student Name</th>
                                <th>Student Contact Number</th>
                                <th>Student Address</th>
                                <th>Student Grade</th>
                                <th>Payment Date</th>
                                <th>Payment Expiry Date</th>
                                <th>&nbsp;</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<% if(theStudents.size() > 0){ %>
	                        	<% for(StudentBusRequestDto tempStudent : theStudents){ %>
	                            	<tr>
	                            		<td><%= tempStudent.studentName %></td>
	                            		<td><%= tempStudent.studentContactNumber %></td>
	                            		<td><%= tempStudent.studentAddress %></td>
	                            		<td><%= tempStudent.studentGrade %></td>
	                            		<td><%= tempStudent.paymentDate %></td>
	                            		<td><%= tempStudent.paymentExpiryDate %></td>
	                            		<%
	                            		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                            		Date expiryDate = tempStudent.paymentExpiryDate == null ? new Date() : sdf.parse(tempStudent.paymentExpiryDate);
	                            		Date today = new Date();
	                            		%>
	                            		<% if(tempStudent.paymentExpiryDate == null || expiryDate.before(today)){ %>
	                            		<td><a href="parent-payment?studentId=<%= tempStudent.studentId %>&busId=<%= tempStudent.busId %>"><button>Make Payment</button></a></td>
	                            		<% }else{ %>
	                            		<td><span class="text-success">Active</span></td>
	                            		<% } %>
	                            	</tr>
							    <% } %>
						    <% }else{ %>
						    	<tr>
							    	<td colspan="7">No student found</td>
							    </tr>
						    <% } %>
                        </tbody>
                    </table>
                    
                </div>

            </div>

        </div>
    </div>
</div>

<%@ include file="/static/footer.jsp" %>