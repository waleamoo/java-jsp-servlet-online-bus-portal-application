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
                    <h2>Welcome <%= session.getAttribute("admin_name") %>. The students listed below are in the waiting list. </h2>
                </div>
                
                <div class="row">
                 	<div class="col-md-6 border-1">
                 		<div class="card card-body">
                 			<div class="card-title">Daily Report - Student Subscription for each bus</div>
                        	<canvas id="student-bus-capacity"></canvas>
                 		</div>
                 	</div>
                 	<div class="col-md-6">
                 		<div class="card card-body">
                 			<div class="card-title">Weekly Report - Student Subscription for each bus</div>
                        	
                 		</div>
                 	</div>
                 	
                 </div>

            </div>
            <!-- /.row -->

        </div>
    </div>
</div>

<%@ include file="/static/footer.jsp" %>