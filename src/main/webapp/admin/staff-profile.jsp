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
                    <h2>Welcome to your profile area <%= session.getAttribute("admin_name") %> </h2>
                    
                    <% var waitingList = (List<WaitingListRequestDto>) request.getAttribute("waitingList"); %>
                    
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Student Name</th>
                                <th>Student Contact Number</th>
                                <th>Parent Name</th>
                                <th>Parent Contact Number</th>
                                <th>Parent Email</th>
                                <th>&nbsp;</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<% if(waitingList.size() > 0){ %>
	                        	<% for(WaitingListRequestDto wait : waitingList){ %>
	                            	<tr>
	                            		<td><%= wait.studentName %></td>
	                            		<td><%= wait.studentContactNumber %></td>
	                            		<td><%= wait.parentName %></td>
	                            		<td><%= wait.parentContactNumber %></td>
	                            		<td><%= wait.parentEmail %></td>
	                            		<td><a href="staff-email?parentName=<%= wait.parentName %>&studentName=<%= wait.studentName %>&parentEmail=<%= wait.parentEmail %>"><button>Email Parent</button></a> 
	                            		| <a href=""><button>Call Parent</button></a> | <a href=""><button>Call Student</button></a></td>
	                            	</tr>	
							    <% } %>
						    <% }else{ %>
						    	<tr>
							    	<td colspan="6">No student in waiting list</td>
							    </tr>
						    <% } %>
                        </tbody>
                    </table>
                    
                </div>

            </div>
            <!-- /.row -->

        </div>
    </div>
</div>

<%@ include file="/static/footer.jsp" %>