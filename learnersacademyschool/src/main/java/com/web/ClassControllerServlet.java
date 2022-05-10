package com.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.ClassesDao;

public class ClassControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ClassControllerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassesDao classesDao = new ClassesDao();
		HashMap<Integer, String> classes = new HashMap<Integer,String>();
		try {
			classes = classesDao.getClasses();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("classes", classes);
		
		RequestDispatcher rd = request.getRequestDispatcher("showClasses.jsp");
		rd.forward(request, response);
	}

}
