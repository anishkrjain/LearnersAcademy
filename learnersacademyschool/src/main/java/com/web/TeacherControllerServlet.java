package com.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.TeacherDao;

public class TeacherControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TeacherControllerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherDao teacherDao = new TeacherDao();
		HashMap<Integer,String> teacher = teacherDao.getTeachers();
		
		request.setAttribute("teachers", teacher);
		
		RequestDispatcher rd = request.getRequestDispatcher("showTeachers.jsp");
		rd.forward(request, response);
	}

}
