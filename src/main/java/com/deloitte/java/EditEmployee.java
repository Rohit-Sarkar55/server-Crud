package com.deloitte.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditEmployee
 */
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Edit block");
		
		int id  = Integer.parseInt((String)request.getParameter("empid"));
		Employee emp = EmployeeDao.getEmployee(id);
		System.out.println(emp);
		
		request.setAttribute("empid" , emp.getEmpId());
		request.setAttribute("name", emp.getName());
		request.setAttribute("dept", emp.getDept());
		request.setAttribute("email", emp.getEmail());
		request.setAttribute("salary", emp.getSalary());
		RequestDispatcher rd = request.getRequestDispatcher("editEmp.jsp");
		rd.forward(request, response);
	}

}
