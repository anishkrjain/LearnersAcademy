package com.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.StudentDao;

public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentControllerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDao studentDao = new StudentDao();
		HashMap<Integer,String> student = studentDao.getStudents();
		
		request.setAttribute("students", student);
		
		RequestDispatcher rd = request.getRequestDispatcher("showStudents.jsp");
		rd.forward(request, response);
		
	}

}
