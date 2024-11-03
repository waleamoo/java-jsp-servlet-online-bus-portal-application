<% if(request.getAttribute("status") == "success" ) { %>
    <div class='alert alert-success border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Success!</strong> Registration successful. Please login.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% }else if(request.getAttribute("status") == "failed" ){ %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> If an account exists, login is invalid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% }else if(request.getAttribute("status") == "invalidEmail" ){ %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Email is invalid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>

<% }else if(request.getAttribute("status") == "invalidPassword" ){ %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Password is invalid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidFullname") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Full name not valid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidUsername") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Username not valid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidEmail") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Email not valid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidPhone") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Phone number not valid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidPassword") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Password does not match.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "failed") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Registration failed.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidPasswordLength") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Please fill the password and confirm.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidParentName") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Parent name is invalid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidParentInitials") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Parent initials is invalid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidParentContactNumber") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Parent contact number is invalid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidParentEmail") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Parent email is invalid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidStudentName") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Student name is invalid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidStudentNumber") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Student number is invalid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidStudentAddress") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Student address is invalid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidStudentGrade") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Student grade is invalid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidBusId") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Bus is invalid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "invalidParentPassword") { %>
    <div class='alert alert-danger border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Password is invalid.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "registerMessage") { %>
    <div class='alert alert-success border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Registration successful.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } else if(request.getAttribute("status") == "waitingListEmailSent") { %>
    <div class='alert alert-success border-1 border-dark alert-dismissible fade show' role='alert'>
        <strong>Error!</strong> Email is sent successfully.
        <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
    </div>
<% } %>