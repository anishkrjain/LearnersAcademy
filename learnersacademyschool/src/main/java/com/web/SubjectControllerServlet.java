package com.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.SubjectDao;

public class SubjectControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SubjectControllerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SubjectDao subjectDao = new SubjectDao();
		HashMap<Integer, String> subject = new HashMap<Integer,String>();
		try {
			subject = subjectDao.getSubjects();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("subjects", subject);
		
		RequestDispatcher rd = request.getRequestDispatcher("showSubjects.jsp");
		rd.forward(request, response);
	}


}
