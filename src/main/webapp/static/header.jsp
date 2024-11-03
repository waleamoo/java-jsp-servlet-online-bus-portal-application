<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title><%= application.getInitParameter("WebAppName") %> - Home</title>
  <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="resources/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="resources/css/shop-homepage.css">
</head>

<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="
      <% if(session.getAttribute("user_name") != null) 
    	  out.print(application.getInitParameter("WebAppContextPath") + "list"); 
    	  else if(session.getAttribute("admin_name") != null) 
    		  out.print(application.getInitParameter("WebAppContextPath") + "staff-dashboard");
    	  else
    		  out.print(application.getInitParameter("WebAppContextPath"));
    		  %>"> <%= application.getInitParameter("WebAppName") %> </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
        aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <% if(session.getAttribute("parent_name") != null){ %>
            <li class="nav-item active">
              <a class="nav-link" href="#">Hello <%= session.getAttribute("parent_name") %></a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="logout">Logout</a>
            </li>
          <% }else if(session.getAttribute("admin_name") != null){ %>
          	<li class="nav-item active">
              <a class="nav-link" href="#">Hello <%= session.getAttribute("admin_name") %></a>
            </li>
          	<li class="nav-item active">
              <a class="nav-link" href="staff-dashboard">Staff Dashboard</a>
            </li>
          	<li class="nav-item active">
              <a class="nav-link" href="staff-reports">Reports</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="logout">Logout</a>
            </li>
          <% }else{ %>
          	<li class="nav-item active">
              <a class="nav-link" href="parent">Parent Login
                <span class="sr-only">(current)</span>
              </a>
            </li>
          	<li class="nav-item">
              <a class="nav-link" href="staff">Staff Login</a>
            </li>
          <% } %>
        </ul>
      </div>
    </div>
  </nav>