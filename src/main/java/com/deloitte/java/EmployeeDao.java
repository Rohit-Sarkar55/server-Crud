package com.deloitte.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	
	static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "_MySql_@Rohit_1234");
			System.out.println("Successfully Connected to DB");
		}catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public static int saveEmployee(Employee emp) {
		int status = 0;
		try {
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps  = con.prepareStatement("insert into employee"
					+ "(empId, name, dept, salary , email )"
					+ "values (?,?,?,?,?)");
			
			ps.setInt(1, emp.getEmpId());
			ps.setString(2, emp.getName());
			ps.setString(3 , emp.getDept());
			ps.setDouble(4, emp.getSalary());
			ps.setString(5 , emp.getEmail());
			
			status = ps.executeUpdate();
			System.out.println(status + " row(s) inserted");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return status;
	}
	
	public static List<Employee> getRecords(){
		List<Employee> list = new ArrayList();
		try {
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps  = con.prepareStatement("select * from employee");
			
			ResultSet rs = ps.executeQuery();
			
			
			int count = 0;
			while(rs.next()) {
				count++;
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String dept = rs.getString(3);
				double salary = rs.getDouble(4);
				String email = rs.getString(5);
				
				list.add(new Employee(id, name, dept, salary, email));
			}
			
			
			System.out.println(count + " row(s) fetched");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return  list;
	}
	
	public static Employee getEmployee(int empid) {
		Employee emp = null;
		try {
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps  = con.prepareStatement("select * from employee where empid=?");
			
			ps.setInt(1 , empid);
			ResultSet rs = ps.executeQuery();
			
			
			int count = 0;
			while(rs.next()) {
				count++;
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String dept = rs.getString(3);
				double salary = rs.getDouble(4);
				String email = rs.getString(5);
				
				emp = new Employee(id, name, dept, salary, email);
			}
			
			
			System.out.println(count + " row(s) fetched");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return emp;
	}
	
	public static void editEmployee(Employee emp) {
		try {
			
			System.out.println("Servlet "+ emp);
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps  = con.prepareStatement("update employee set name=? , email=? , dept =? , salary=? where empId = ?" );
			
			ps.setString(1,emp.getName());
			ps.setString(2, emp.getEmail());
			ps.setString(3 , emp.getDept());
			ps.setDouble(4, emp.getSalary());
			ps.setInt(5 , emp.getEmpId());
			
			int count = ps.executeUpdate();
			
			
			
			System.out.println(count + " row(s) updated");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void deleteEmployee(int id) {
try {
			
			System.out.println("Servlet "+ id);
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps  = con.prepareStatement("delete from employee where empId =?");
			
			
			ps.setInt(1 , id);
			
			int count = ps.executeUpdate();
			
			
			
			System.out.println(count + " row(s) updated");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
