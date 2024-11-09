<%@ include file="/static/header.jsp" %>
<div class="container my-4">
    <div class="row">

        <%@ include file="/static/parent-sidebar.jsp" %>

        <div class="col-lg-9">
            <div class="row">

                <div class="col-12">
                    
                    <h2>Thank you for making a payment <%= session.getAttribute("parent_name") %></h2>
                    <p>Your payment has been successfully received and your transport access activated.</p>
                    <a href="parent-dashboard"><h1>Back to Parent Dashboard</h1></a>
                    
                </div>

            </div>

        </div>
    </div>
</div>

<%@ include file="/static/footer.jsp" %>