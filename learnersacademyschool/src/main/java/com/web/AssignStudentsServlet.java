package com.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.StudentDao;

public class AssignStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AssignStudentsServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String student = request.getParameter("student");
		String standard = request.getParameter("classForStudent");
		
		StudentDao studentDao = new StudentDao();
		try {
			studentDao.assignStudents(student, standard);
			response.sendRedirect("administrativeportal.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
