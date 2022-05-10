package com.web;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.repository.SQLConnection;

public class GenerateClassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GenerateClassReportServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String standard = request.getParameter("userInput");
		try {
			SQLConnection con = new SQLConnection();
			Statement st1 = con.createConnection();
			Statement st2 = con.createConnection();
			ResultSet rs1 = st1.executeQuery("SELECT tat.teacher_name as Teacher, tat.subject_name as Subject FROM \r\n"
					+ "tb_class tc\r\n"
					+ "inner join tb_assign_teachers tat on tc.class_id = tat.class_id\r\n"
					+ "where  tc.class = '" + standard + "'");
			ResultSet rs2 = st2.executeQuery("SELECT student_name as Student FROM tb_class_for_student where class='" + standard + "'");
			request.setAttribute("table1", rs1);
			request.setAttribute("table2", rs2);
			RequestDispatcher rd = request.getRequestDispatcher("classReport.jsp");
			rd.forward(request, response);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
