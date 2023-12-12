package com.deloitte.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int empId =Integer.parseInt(((String) req.getParameter("empid")));
		String name = (String ) req.getParameter("name");
		String dept = (String ) req.getParameter("dept");
		double salary = Double.parseDouble((String) req.getParameter("salary"));
		String email = (String) req.getParameter("email");
		
		Employee emp = new Employee(empId, name, dept, salary, email);
		System.err.println(emp);
		EmployeeDao.editEmployee(emp);
		RequestDispatcher rd = req.getRequestDispatcher("GetRecords");
		rd.forward(req, response);
	}

}
