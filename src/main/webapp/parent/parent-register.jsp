<%@ include file="/static/header.jsp" %>
<%@ page import="java.util.List, com.techqwerty.dto.BusRouteDto" %>
<div class="container my-4">
    <div class="row">

        <div class="col-lg-8 offset-lg-2">
            <div class="row">

                <div class="col-12">
                    <h2>Register Parent</h2>
                    <p class="text-muted">
                      Fill in all the fields to register yourself and your child. Add more children to registration when you 
                      login to your portal 
                    </p>
                    
                    <%@ include file="/static/errors.jsp" %>
                    
                    <form method="post">
						<input type="hidden" name="action" value="parent-register" />
                        <div class="form-group">
                          <label for="parent_name">Parent Name</label>
                          <input type="text" class="form-control" name="parent_name" id=""parent_name" placeholder="Parent Name" value="<% if(request.getParameter("parent_name") != null) out.print(request.getParameter("parent_name")); %>">
                          <small class="form-text text-muted">Enter your name</small>
                        </div>

                        <div class="form-group">
                          <label for="parent_initials">Parent Initials</label>
                          <input type="text" class="form-control" name="parent_initials" id="parent_initials" placeholder="Parent Initials" value="<% if(request.getParameter("parent_initials") != null) out.print(request.getParameter("parent_initials")); %>">
                          <small class="form-text text-muted">Enter parent initials</small>
                        </div>

                        <div class="form-group">
                          <label for="parent_contact_number">Parent Contact Number</label>
                          <input type="text" class="form-control" name="parent_contact_number" id="parent_contact_number" placeholder="Parent contact number" value="<% if(request.getParameter("parent_contact_number") != null) out.print(request.getParameter("parent_contact_number")); %>">
                          <small class="form-text text-muted">Enter parent contact number</small>
                        </div>

                        <div class="form-group">
                          <label for="parent_email">Parent Email</label>
                          <input type="text" class="form-control" name="parent_email" id="parent_email" placeholder="Parent email address" value="<% if(request.getParameter("parent_email") != null) out.print(request.getParameter("parent_email")); %>">
                          <small class="form-text text-muted">Enter parent email address</small>
                        </div>

                        <h3>Your student details</h3>
                        <hr>
                        <div class="form-group">
                          <label for="student_name">Student Name</label>
                          <input type="text" class="form-control" name="student_name" id="student_name" placeholder="Student name" value="<% if(request.getParameter("student_name") != null) out.print(request.getParameter("student_name")); %>">
                          <small class="form-text text-muted">Enter your student name</small>
                        </div>

                        <div class="form-group">
                          <label for="student_contact_num">Student Contact Number</label>
                          <input type="text" class="form-control" name="student_contact_num" id="student_contact_num" placeholder="Student contact number" value="<% if(request.getParameter("student_contact_num") != null) out.print(request.getParameter("student_contact_num")); %>">
                          <small class="form-text text-muted">Enter student contact number</small>
                        </div>

                        <div class="form-group">
                          <label for="student_addr">Student Address</label>
                          <input type="text" class="form-control" name="student_addr" id="student_addr" placeholder="Student Address" value="<% if(request.getParameter("student_addr") != null) out.print(request.getParameter("student_addr")); %>">
                          <small class="form-text text-muted">Enter student address</small>
                        </div>

                        <div class="form-group">
                          <label for="student_grd">Student Grade</label>
                          <select class="form-control" name="student_grd" id="student_grd">
                              <option value="<% if(request.getParameter("student_grd") != null) out.print(request.getParameter("student_grd")); else out.print("0"); %>"><% if(request.getParameter("student_grd") != null) out.print(request.getParameter("student_grd")); else out.print("Select a grade"); %></option>
                              <option value="10">10</option>
                              <option value="11">11</option>
                              <option value="12">12</option>
                          </select>
                          <small class="form-text text-muted">Enter student grade</small>
                        </div>
                        
                        <div class="form-group">
                        	<label for="bus_id">Bus</label>
                        	<select class="custom-select" name="bus_id" id="bus_id">
                        		<% List<BusRouteDto> busRoutes = (List<BusRouteDto>) request.getAttribute("busRouteDtos"); %>
                        		<option value="<% if(request.getParameter("bus_id") != null) out.print(request.getParameter("bus_id")); else out.print("0"); %>"><% if(request.getParameter("bus_id") != null) out.print("Bus selected"); else out.print("Select a bus"); %></option>
                        		<% for(BusRouteDto bus : busRoutes){ %>
                        			<option value="<%= bus.busId %>"><%= bus.busLabel %> - <%= bus.routeName %></option>
                        		<% } %>
                        	</select>
                        </div>

                        <hr>

                        <div class="form-group">
                          <label for="parent_password">Parent Password</label>
                          <input type="password" class="form-control" name="parent_password" id="parent_password" placeholder="Parent password" value="<% if(request.getParameter("parent_password") != null) out.print(request.getParameter("parent_password")); %>">
                          <small class="form-text text-muted">Enter a password</small>
                        </div>

                        <div class="form-group">
                          <label for="parent_confirm_password">Parent Confirm Password</label>
                          <input type="password" class="form-control" name="parent_confirm_password" id="parent_confirm_password" placeholder="Confirm Password" value="<% if(request.getParameter("parent_confirm_password") != null) out.print(request.getParameter("parent_confirm_password")); %>">
                          <small class="form-text text-muted">Enter password again</small>
                        </div>

                        <button type="submit" class="btn btn-primary">Register</button>

                    </form>
                </div>

            </div>

        </div>
    </div>
</div>

<%@ include file="/static/footer.jsp" %>