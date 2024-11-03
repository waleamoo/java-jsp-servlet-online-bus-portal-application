package com.techqwerty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.techqwerty.dto.BusRouteDto;
import com.techqwerty.dto.ParentStudentInsertDto;
import com.techqwerty.dto.WaitingListRequestDto;
import com.techqwerty.model.Admin;
import com.techqwerty.model.Parent;
import com.techqwerty.model.Student;

public class ApplicationDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/online_bus_system?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    private String jdbcDriver = "com.mysql.cj.jdbc.Driver";

    private static final String LOGIN_PARENT_BY_EMAIL = "SELECT * FROM parents WHERE parent_email = ? AND parent_password = ?";
    private static final String LOGIN_STAFF_BY_EMAIL = "SELECT * FROM admins WHERE admin_email = ? AND admin_password = ?";
    private static final String GET_STUDENTS_BY_PARENT_ID = "SELECT * FROM `students` WHERE `parent_id` = ?;";
    private static final String GET_BUS_ROUTES = "SELECT buses.bus_id, buses.bus_label, buses.bus_capacity, buses.route_id, routes.route_pickup_number, routes.route_name, routes.pickup_name, routes.dropoff_name, routes.pickup_time, routes.dropoff_time FROM buses INNER JOIN routes ON buses.route_id = routes.route_id;";
    private static final String REGISTER_PARENT = "INSERT INTO `parents`(`parent_name`, `parent_initials`, `parent_contact_number`, `parent_email`, `parent_password`) VALUES (?, ?, ?, ?, ?);";
    private static final String REGISTER_STUDENT = "INSERT INTO `students`(`student_name`, `student_contact_number`, `student_address`, `student_grade`, `parent_id`) VALUES (?, ?, ?, ?, ?);";
    private static final String REGISTER_STUDENT_IN_WAITING_LIST = "INSERT INTO `waiting_list`(`student_id`, `bus_id`, `joined_date`) VALUES (?, ?, ?);";
    private static final String REGISTER_STUDENT_IN_BUS = "INSERT INTO `student_buses`(`student_id`, `parent_id`, `bus_id`, `payment_date`, `payment_expiry_date`, `is_active`) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String GET_WAITING_LIST = """ 
    		SELECT waiting_list.*, student_buses.payment_date, student_buses.payment_expiry_date, students.student_name, students.student_contact_number, 
    			parents.parent_name, parents.parent_contact_number, parents.parent_email 
    		FROM waiting_list INNER JOIN student_buses ON waiting_list.student_id = student_buses.student_id 
    		INNER JOIN students ON waiting_list.student_id = students.student_id 
    		INNER JOIN parents ON students.parent_id = parents.parent_id;
    		""";

    public ApplicationDAO(){
    	
    }

    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    /*
     * Action Method to perform CRUD on the database 
     */
    
    /*
     public int registerParent(Parent parent) throws SQLException{
        try(Connection connection = getConnection(); PreparedStatement pst = connection.prepareStatement(REGISTER_PARENT);) {
	            pst.setString(1, parent.getParentSurname());
	            pst.setString(2, parent.getParentInitials());
	            pst.setString(3, parent.getParentContactNumber());
	            pst.setString(4, parent.getParentEmail());
	            pst.setString(5, parent.getParentPassword());
	            int rowCount = pst.executeUpdate();
	        
            return rowCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
     */
    
    public int registerParent(ParentStudentInsertDto dto) throws SQLException{
    	int int_inserted_parent_id = 0, int_inserted_student_id = 0, int_inserted_payment_id = 0;
        try(Connection connection = getConnection(); PreparedStatement pst = connection.prepareStatement(REGISTER_PARENT, Statement.RETURN_GENERATED_KEYS);) {
	            pst.setString(1, dto.parentSurname);
	            pst.setString(2, dto.parentInitials);
	            pst.setString(3, dto.parentContactNumber);
	            pst.setString(4, dto.parentEmail);
	            pst.setString(5, dto.parentPassword);
	            int rowCount = pst.executeUpdate();
	            if (rowCount > 0) {
	            	ResultSet rs = pst.getGeneratedKeys();
		            if (rs.next()) {
		            	int_inserted_parent_id = rs.getInt(1);
					}
		            // add a student under the new parent 
		            try (PreparedStatement pstStudent = connection.prepareStatement(REGISTER_STUDENT, Statement.RETURN_GENERATED_KEYS);){
						pstStudent.setString(1, dto.studentName);
						pstStudent.setString(2, dto.studentContactNumber);
						pstStudent.setString(3, dto.studentAddress);
						pstStudent.setString(4, dto.studentGrade);
						pstStudent.setInt(5, int_inserted_parent_id);						
						int studentRow = pstStudent.executeUpdate();
						if (studentRow > 0) {
							ResultSet studentResultSet = pstStudent.getGeneratedKeys();
							if (studentResultSet.next()) {
								int_inserted_student_id = studentResultSet.getInt(1);
							}
						}
					} catch (Exception e) {
						System.out.println("Student and parent cannot be added: " + e.getMessage());
					}
		            // save student in the waiting list 
		            try (PreparedStatement pstStudent = connection.prepareStatement(REGISTER_STUDENT_IN_WAITING_LIST);){
		            	var df = new SimpleDateFormat("yyyy-MM-dd");
						pstStudent.setInt(1, int_inserted_student_id);
						pstStudent.setInt(2, dto.busId);
						pstStudent.setString(3, df.format(new Date()).toString());						
						pstStudent.executeUpdate();
					} catch (Exception e) {
						System.out.println("Student cannot be added to waiting list: " + e.getMessage());
					}
		            // add a student to a bus - as inactive 
		            try (PreparedStatement pstBus = connection.prepareStatement(REGISTER_STUDENT_IN_BUS);){
						pstBus.setInt(1, int_inserted_student_id);
						pstBus.setInt(2, int_inserted_parent_id);				
						pstBus.setInt(3, dto.busId);
						pstBus.setString(4, null);			
						pstBus.setString(5, null);			
						pstBus.setInt(6, 0);			
						pstBus.executeUpdate();
					} catch (Exception e) {
						System.out.println("Student cannot be added to bus: " + e.getMessage());
					}
				}
	            
            return rowCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public Admin loginStaff(String email, String password){
        try(Connection connection = getConnection(); 
        PreparedStatement pst = connection.prepareStatement(LOGIN_STAFF_BY_EMAIL);) {
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Admin admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                return admin;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Parent loginParent(String email, String password){
        try(Connection connection = getConnection(); 
        PreparedStatement pst = connection.prepareStatement(LOGIN_PARENT_BY_EMAIL);) {
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Parent parent = new Parent(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                return parent;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<WaitingListRequestDto> getWatingList(){
        List<WaitingListRequestDto> waitingList = new ArrayList<WaitingListRequestDto>();
        try (Connection connection = getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement(GET_WAITING_LIST);){
            ResultSet rs =  preparedStatement.executeQuery();
            while(rs.next()){
            	waitingList.add(
                    new WaitingListRequestDto(
                        rs.getInt("id"), 
                        rs.getInt("student_id"), 
                        rs.getInt("bus_id"), 
                        rs.getString("joined_date"), 
                        rs.getString("payment_date"), 
                        rs.getString("payment_expiry_date"),
                        rs.getString("student_name"),
                        rs.getString("student_contact_number"),
                        rs.getString("parent_name"),
                        rs.getString("parent_contact_number"),
                        rs.getString("parent_email")
                    )
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return waitingList; 
    }
    
    public List<Student> getAllStudents(int parentId){
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement(GET_STUDENTS_BY_PARENT_ID);){
            preparedStatement.setInt(1, parentId);
            //System.out.println(preparedStatement);
            ResultSet rs =  preparedStatement.executeQuery();
            while(rs.next()){
                students.add(
                    new Student(
                        rs.getInt("student_id"), 
                        rs.getString("student_name"), 
                        rs.getString("student_contact_number"), 
                        rs.getString("student_address"), 
                        rs.getString("student_grade"), 
                        rs.getInt("parent_id")
                    )
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return students; 
    }
    
    public List<BusRouteDto> getBusRoute(){
    	List<BusRouteDto> busRoutes = new ArrayList<BusRouteDto>();
    	try (Connection connection = getConnection(); 
                PreparedStatement preparedStatement = connection.prepareStatement(GET_BUS_ROUTES);){
                ResultSet rs =  preparedStatement.executeQuery();
                while(rs.next()){
                    busRoutes.add(
                        new BusRouteDto(
                            rs.getInt("bus_id"), 
                            rs.getString("bus_label"), 
                            rs.getInt("route_id"), 
                            rs.getString("route_pickup_number"), 
                            rs.getString("route_name"), 
                            rs.getString("pickup_name"),
                            rs.getString("dropoff_name"),
                            rs.getString("pickup_time"),
                            rs.getString("dropoff_time")
                        )
                    );
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return busRoutes; 
    }

}
