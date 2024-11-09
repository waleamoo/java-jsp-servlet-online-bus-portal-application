<%@ include file="/static/header.jsp" %>
<%@ page import="java.util.List, com.techqwerty.dto.BusRouteDto" %>
<div class="container my-4">
    <div class="row">

        <%@ include file="/static/parent-sidebar.jsp" %>

        <div class="col-lg-9">
            <div class="row">

                <div class="col-12">
                    
                    <h2>Add Child to Bus Transport </h2>
                    <p class="text-muted">
                        Fill all fields to add a new child to your children list for bus transport 
                      </p>
  
  					<%@ include file="/static/errors.jsp" %>
 
                      <form method="post">
                      
                      		<input type="hidden" name="action" value="parent-add-child" />
  
                          <div class="form-group">
                            <label for="student_name">Student Name</label>
                            <input type="text" class="form-control" name="student_name" id="student_name" placeholder="Student name" value="<% if(request.getParameter("student_name") != null) out.print(request.getParameter("student_name")); %>">
                            <small class="form-text text-muted">Enter your student name</small>
                          </div>
  
                          <div class="form-group">
                            <label for="student_num">Student Contact Number</label>
                            <input type="text" class="form-control" name="student_num" id="student_num" placeholder="Student contact number" value="<% if(request.getParameter("student_num") != null) out.print(request.getParameter("student_num")); %>">
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
                                <option value="0">Select a grade</option>
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
  
                          <button type="submit" class="btn btn-primary">Add Student</button>
  
                      </form>
                    
                </div>

            </div>

        </div>
    </div>
</div>

<%@ include file="/static/footer.jsp" %>