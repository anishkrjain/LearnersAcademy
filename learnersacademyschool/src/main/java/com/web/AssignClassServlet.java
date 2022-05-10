package com.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.ClassesDao;

public class AssignClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AssignClassServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter("subject");
		String standard = request.getParameter("class");
		
		ClassesDao classesDao = new ClassesDao();
		try {
			classesDao.assignClass(subject, standard);
			response.sendRedirect("administrativeportal.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
