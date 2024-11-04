package com.techqwerty.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.techqwerty.dao.ApplicationDAO;
import com.techqwerty.dto.BusRouteDto;
import com.techqwerty.dto.ParentStudentInsertDto;
import com.techqwerty.dto.StudentBusRequestDto;
import com.techqwerty.dto.WaitingListRequestDto;
import com.techqwerty.model.Admin;
import com.techqwerty.model.Parent;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/*
 * Servlet implementation class ApplicationServlet
 * Admin password: test
 * Parent password: test
 */
@WebServlet("/")
public class ApplicationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// Emailing parameters 
	private String host;
    private String port;
    private String user;
    private String pass;
    // inject the DAO
	private ApplicationDAO applicationDAO;
	

    @Override
    public void init() throws ServletException {
        applicationDAO = new ApplicationDAO();
        // set the emailing parameters 
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "parent-login":
                loginParent(req, resp);
                break;
            case "staff-login":
                loginStaff(req, resp);
                break;
            case "parent-register":
				try {
					registerParent(req, resp);
				} catch (ServletException | IOException | SQLException e) {
					e.printStackTrace();
				}
                break;
            
            default:
            	req.getRequestDispatcher("index.jsp").forward(req, resp); 
                break;
        }
    };

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
        String action = request.getServletPath();
        ServletContext context = getServletContext();
        
        switch (action) {
	        case "/parent":
	        	request.getRequestDispatcher("index.jsp").forward(request, response);
	            break;
	        case "/parent-dashboard":
	        	// get the login user's students 
	            List<StudentBusRequestDto> students = applicationDAO.getAllStudents((int) session.getAttribute("parent_id"));
	            request.setAttribute("listStudent", students);
	            request.getRequestDispatcher("parent/parent-profile.jsp").forward(request, response);
	        	break;
	        case "/parent-add-child":
	        	request.getRequestDispatcher("parent/parent-add-child.jsp").forward(request, response);
	        	break;
	        case "/parent-payment":
	        	// get the parameter 
	        	int studentId = Integer.parseInt(request.getParameter("studentId"));
	        	int busId = Integer.parseInt(request.getParameter("busId"));
	        	request.setAttribute("studentId", studentId);
	        	request.setAttribute("busId", busId);
	        	request.getRequestDispatcher("parent/parent-payment.jsp").forward(request, response);
	        	break;
	            
	        case "/home":
	        	request.getRequestDispatcher("index.jsp").forward(request, response);
	        	break;
	        case "/register-parent":
	        	// get the bus routes 
	        	List<BusRouteDto> busRouteDtos = applicationDAO.getBusRoute();
	        	request.setAttribute("busRouteDtos", busRouteDtos);
	        	request.getRequestDispatcher("parent/parent-register.jsp").forward(request, response); 
	        	break;
            case "/staff":
            	request.getRequestDispatcher("staff-login.jsp").forward(request, response);
            	break;
                
            case "/logout":
            	session = request.getSession();
                session.invalidate();
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "/staff-dashboard":
            	// check if the user is logged in as a staff
            	if(session != null) {
            		if(session.getAttribute("admin_name") == null){ 
            			response.sendRedirect(context.getInitParameter("WebAppContextPath")); 
            		}else {
            			// show the staff dashboard
            			List<WaitingListRequestDto> waitingList = applicationDAO.getWatingList();
            			request.setAttribute("waitingList", waitingList);
            			request.getRequestDispatcher("admin/staff-profile.jsp").forward(request, response);
            		}
            	}else {
            		response.sendRedirect(context.getInitParameter("WebAppContextPath"));
            	}
            	break;
            case "/staff-email":
            	// check if the user is logged in as a staff
            	if(session != null) {
            		if(session.getAttribute("admin_name") == null){ 
            			response.sendRedirect(context.getInitParameter("WebAppContextPath"));
            		}else {
            			// show the staff dashboard
            			String email = request.getParameter("parentEmail");
            			String student = request.getParameter("studentName");
            			String parent = request.getParameter("parentName");
            			
            			try {
							EmailUtility.sendEmail(host, port, user, pass, email, "Bus Registration Expired", "Hi " + parent + ",\nWe trust this finds you well. This a reminder to tell you that our child " + student + "'s transport subscription has expired. Please login to the bus system to make a payment.");
						} catch (AddressException e) {
							e.printStackTrace();
						} catch (MessagingException e) {
							e.printStackTrace();
						}
            			
            			session.setAttribute("status", "waitingListEmailSent");
            			response.sendRedirect(context.getInitParameter("WebAppContextPath") + "staff-dashboard");
            		}
            	}else { 
            		response.sendRedirect(context.getInitParameter("WebAppContextPath"));
            	}
            	break;
            default: 
            	// checks if the user is logged in
            	if(session != null) {
            		if(session.getAttribute("parent_name") != null){ 
            			response.sendRedirect(context.getInitParameter("WebAppContextPath") + "parent-dashboard");
            		}else if(session.getAttribute("admin_name") != null) {
            			response.sendRedirect(context.getInitParameter("WebAppContextPath") + "staff-dashboard");
            		}else {
            			response.sendRedirect(context.getInitParameter("WebAppContextPath"));
            		}
            	}else{
            		response.sendRedirect(context.getInitParameter("WebAppContextPath"));
            	}
                break;
        }
    }

    private void loginParent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // get the values from the form
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;

        // validate the user entries 
        if(email == null || email.equals("")){
            request.setAttribute("status", "invalidEmail");
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }

        if(password == null || password.equals("")){
            request.setAttribute("status", "invalidPassword");
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }

        // pass the password as encrypted password
        String encryptedPassword = MyEncryptor.getMd5Hash(password);

        // attempt login 
        Parent parent = applicationDAO.loginParent(email, encryptedPassword);

        if (parent != null) {
            session.setAttribute("parent_name", parent.getParentInitials() + " " + parent.getParentSurname());
            session.setAttribute("parent_id", parent.getParentId());
            // get the login user's students 
            List<StudentBusRequestDto> students = applicationDAO.getAllStudents((int) session.getAttribute("parent_id"));
            request.setAttribute("listStudent", students);
            dispatcher = request.getRequestDispatcher("parent/parent-profile.jsp");
        }else{
            request.setAttribute("status", "failed");
            dispatcher = request.getRequestDispatcher("index.jsp");
        }
        dispatcher.forward(request, response);

    }

    private void loginStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // get the values from the form
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        // validate the user entries 
        if(email == null || email.equals("")){
            request.setAttribute("status", "invalidEmail");
            dispatcher = request.getRequestDispatcher("staff-login.jsp");
            dispatcher.forward(request, response);
        }else if(password == null || password.equals("")){
            request.setAttribute("status", "invalidPassword");
            dispatcher = request.getRequestDispatcher("staff-login.jsp");
            dispatcher.forward(request, response);
        }
        // pass the password as encrypted password
        String encryptedPassword = MyEncryptor.getMd5Hash(password);
        // attempt login 
        Admin admin = applicationDAO.loginStaff(email, encryptedPassword);
        if (admin != null) {
            session.setAttribute("admin_name", admin.getAdminInitials() + " " + admin.getAdminSurname());
            session.setAttribute("admin_id", admin.getAdminId());
            // get the students in the waiting list
            List<WaitingListRequestDto> waitingList = applicationDAO.getWatingList();
            request.setAttribute("waitingList", waitingList);
            dispatcher = request.getRequestDispatcher("admin/staff-profile.jsp");
        }else{
            request.setAttribute("status", "failed");
            dispatcher = request.getRequestDispatcher("staff-login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void registerParent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	// get the values from the form 
    	String parentName = request.getParameter("parent_name");
    	String parentInitials = request.getParameter("parent_initials");
    	String parentContactNumber = request.getParameter("parent_contact_number");
    	String parentEmail = request.getParameter("parent_email");
    	String studentName = request.getParameter("student_name");
    	String studentNum = request.getParameter("student_contact_num");
    	String studentAddr = request.getParameter("student_addr");
    	String studentGrade = request.getParameter("student_grd");
    	int busId = Integer.parseInt(request.getParameter("bus_id"));
    	String parentPassword = request.getParameter("parent_password");
    	String parentConfirmPassword = request.getParameter("parent_confirm_password");
    	// get the bus route for display on the page - in case there are errors 
    	List<BusRouteDto> busRouteDtos = applicationDAO.getBusRoute();
    	request.setAttribute("busRouteDtos", busRouteDtos);
    	// validate the entries 
    	if (parentName == null || parentName.trim().equals("")) {
    		request.setAttribute("status", "invalidParentName");
            request.getRequestDispatcher("parent/parent-register.jsp").forward(request, response);
		}else if(parentInitials == null || parentInitials.trim().equals("") || !parentInitials.matches("[A-Z.+]{3}")) {
			request.setAttribute("status", "invalidParentInitials");
            request.getRequestDispatcher("parent/parent-register.jsp").forward(request, response);
		}else if(parentContactNumber == null || parentContactNumber.trim().equals("") || !parentContactNumber.matches("[0-9]{10}")) {
			request.setAttribute("status", "invalidParentContactNumber");
			request.getRequestDispatcher("parent/parent-register.jsp").forward(request, response);
		}else if(parentEmail == null || parentEmail.trim().equals("") || !parentEmail.matches("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$")) {
			request.setAttribute("status", "invalidParentEmail");
			request.getRequestDispatcher("parent/parent-register.jsp").forward(request, response);
		}else if(studentName == null || studentName.trim().equals("") || !studentName.matches("[A-Za-z ]{5,40}")) {
			request.setAttribute("status", "invalidStudentName");
			request.getRequestDispatcher("parent/parent-register.jsp").forward(request, response);
		}else if(studentNum == null || studentNum.trim().equals("") || !studentNum.matches("([0-9]{10})")) {
			request.setAttribute("status", "invalidStudentNumber");
			request.getRequestDispatcher("parent/parent-register.jsp").forward(request, response);
		}else if(studentAddr == null || studentAddr.trim().equals("") || !studentAddr.matches("[A-Za-z0-9 ]{5,40}")) {
			request.setAttribute("status", "invalidStudentAddress");
			request.getRequestDispatcher("parent/parent-register.jsp").forward(request, response);
		}else if(studentGrade == null || studentGrade.trim().equals("") || !studentGrade.matches("[0-9]{2}")) {
			request.setAttribute("status", "invalidStudentGrade");
			request.getRequestDispatcher("parent/parent-register.jsp").forward(request, response);
		}else if(busId <= 0) {
			request.setAttribute("status", "invalidBusId");
			request.getRequestDispatcher("parent/parent-register.jsp").forward(request, response);
		}else if(parentPassword == null || parentPassword.trim().equals("") || parentPassword.trim().length() > 20) {
			request.setAttribute("status", "invalidParentPassword");
			request.getRequestDispatcher("parent/parent-register.jsp").forward(request, response);
		}else if(parentConfirmPassword == null || parentConfirmPassword.trim().equals("")|| parentConfirmPassword.trim().length() > 20 || !parentConfirmPassword.equals(parentPassword)) {
			request.setAttribute("status", "invalidParentConfirmPassword");
			request.getRequestDispatcher("parent/parent-register.jsp").forward(request, response);
		}else {
			// encrypt the parent password 
	    	String encryptedPassword = MyEncryptor.getMd5Hash(parentPassword);
	    	// register the parent and student 
	    	ParentStudentInsertDto dto = new ParentStudentInsertDto(0, parentName, parentInitials, parentContactNumber, parentEmail, encryptedPassword, studentName, parentContactNumber, studentAddr, studentGrade, busId);
	    	applicationDAO.registerParent(dto);
	    	// email the client 
	    	try {
	            EmailUtility.sendEmail(host, port, user, pass, "recipient", "subject", "content");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        } finally {
	        	request.setAttribute("registerMessage", "Parent registration successful.");
	            //getServletContext().getRequestDispatcher("/Result.jsp").forward(request, response);
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	        }
	    	
		}
    	
	}
    
}

