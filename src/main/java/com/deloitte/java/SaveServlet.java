package com.deloitte.java;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int empId =Integer.parseInt(((String) req.getParameter("empid")));
		String name = (String ) req.getParameter("name");
		String dept = (String ) req.getParameter("dept");
		double salary = Double.parseDouble((String) req.getParameter("salary"));
		String email = (String) req.getParameter("email");
		
		Employee emp = new Employee(empId, name, dept, salary ,email);
		int status = EmployeeDao.saveEmployee(emp);
		
		
		if(status > 0) {
			RequestDispatcher rd = req.getRequestDispatcher("GetRecords");
//			List<Employee> list= EmployeeDao.getRecords();
//			for(Employee e: list) {
//				System.out.println(e);
//			}
			rd.forward(req, resp);
		}
		System.out.println(empId+" "+ name + " "+ dept + " " + salary + " " + email);
		System.out.println(status);
	}
	
	

}
