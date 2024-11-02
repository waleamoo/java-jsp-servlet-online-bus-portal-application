<%@ include file="/static/header.jsp" %>
<%@ page import="java.util.*, com.techqwerty.model.*" %>
<div class="container my-4">
    <div class="row">

        <%@ include file="/static/parent-sidebar.jsp" %>

        <div class="col-lg-9">
            <div class="row">

                <div class="col-12">
                    
                    <h2>Welcome to your profile area <b><%= session.getAttribute("parent_name") %></b> </h2>
                    <p>Below is the list of your wares we are transporting.</p>
                    
                    <% List<Student> theStudents = (List<Student>) request.getAttribute("listStudent"); %>
                    
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Student Name</th>
                                <th>Student Contact Number</th>
                                <th>Student Address</th>
                                <th>Student Grade</th>
                                <th>&nbsp;</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<% if(theStudents.size() > 0){ %>
	                        	<% for(Student tempStudent : theStudents){ %>
	                            	<tr>
	                            		<td><%= tempStudent.getStudentName() %></td>
	                            		<td><%= tempStudent.getStudentContactNumber() %></td>
	                            		<td><%= tempStudent.getStudentAddress() %></td>
	                            		<td><%= tempStudent.getStudentGrade() %></td>
	                            		<td><a href=""><button>Make Payment</button></a></td>
	                            	</tr>	
							    <% } %>
						    <% }else{ %>
						    	<tr>
							    	<td colspan="5">No student found</td>
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