<%@ include file="/static/header.jsp" %>
<div class="container my-4">
    <div class="row">
        <div class="col-lg-3">

            <h1 class="my-4">What's up? Hello?</h1>
            <div class="list-group">
                <a href="#" class="list-group-item">Category 1</a>
                <a href="#" class="list-group-item">Category 2</a>
                <a href="#" class="list-group-item">Category 3</a>
            </div>

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">
            <div class="row">

                <div class="col-12">
                    <ul class="navbar-nav">
                        <li>
                            <a href="<%= request.getContextPath() %>/list" class="nav-list">Students List</a>
                        </li>
                    </ul>
                    <h2>Welcome to your profile area <%= session.getAttribute("user_name") %> </h2>
                    
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Country</th>
                                <th>&nbsp;</th>
                            </tr>
                        </thead>
                        <tbody>
                                                        
                        </tbody>
                    </table>
                </div>

            </div>
            <!-- /.row -->

        </div>
    </div>
</div>

<%@ include file="/static/footer.jsp" %>