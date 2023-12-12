package com.deloitte.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetRecords
 */
public class GetRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");
		List<Employee> list  = EmployeeDao.getRecords();
		PrintWriter out = resp.getWriter();
		
		
		out.println("<h1>Employee Detail List</h1>");
		out.println("<table border='1'>");
		out.print("<tr><th>Emp Id</th><th>Name</th><th>Email</th><th>Emp Depatment</th><th>Salary</th><th>Action</th></tr>");
		for(Employee e: list) {
				
		out.print("<tr><td>"+e.getEmpId() + "</td><td>"+ e.getName()+ "</td><td> "+ e.getEmail()+ 
				"</td><td> "+ e.getDept()+"</td><td> "+e.getSalary()+ "</td><td>"
						+ "<a href='EditEmployee?empid="+e.getEmpId()+"'>Edit</a> <a href='DeleteEmployee?empid="+e.getEmpId()+"'>Delete</a></td></tr>");
				
		}
		out.print("</table>");
	}
	

}
