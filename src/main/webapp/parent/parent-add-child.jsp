<%@ include file="/static/header.jsp" %>
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
  
  						<jsp:include page="/static/errors.jsp" />
  
  
                      <form action="parent-add-child" method="post">
  
                          <div class="form-group">
                            <label for="student_name">Student Name</label>
                            <input type="text" class="form-control" name="student_name" id="student_name" placeholder="Student name">
                            <small class="form-text text-muted">Enter your student name</small>
                          </div>
  
                          <div class="form-group">
                            <label for="student_num">Student Contact Number</label>
                            <input type="text" class="form-control" name="student_num" id="student_num" placeholder="Student contact number">
                            <small class="form-text text-muted">Enter student contact number</small>
                          </div>
  
                          <div class="form-group">
                            <label for="student_addr">Student Address</label>
                            <input type="text" class="form-control" name="student_addr" id="student_addr" placeholder="Student Address">
                            <small class="form-text text-muted">Enter student address</small>
                          </div>
  
                          <div class="form-group">
                            <label for="student_grd">Student Grade</label>
                            <select name="student_grd" id="student_grd">
                                <option value=""></option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select>
                            <small class="form-text text-muted">Enter student grade</small>
                          </div>
  
                          <button type="submit" class="btn btn-primary">Add Student</button>
  
                      </form>
                    
                </div>

            </div>

        </div>
    </div>
</div>

<%@ include file="/static/footer.jsp" %>