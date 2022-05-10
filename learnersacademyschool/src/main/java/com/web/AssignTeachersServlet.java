package com.web;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.Subject;
import com.web.model.SubjectDao;
import com.web.model.TeacherDao;
import com.web.repository.SQLConnection;

public class AssignTeachersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AssignTeachersServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String submitValue = request.getParameter("submitForAssignTeacher");
		if(submitValue.equals("Assign subject to teacher")) {
			String subject = request.getParameter("subjectForTeacher");
			String teacher1 = request.getParameter("teacher1"); 
			String standard1 = request.getParameter("class1");
			SubjectDao subjectDao = new SubjectDao();
			try {
				subjectDao.assignSubjects(teacher1, standard1, subject);
				response.sendRedirect("administrativeportal.jsp");
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		if(submitValue.equals("Assign class to teacher")) {
			TeacherDao teacherDao = new TeacherDao();
			Subject subjectsForClass = new Subject();
			try {
				String teacher = request.getParameter("teacher");
				String standard = request.getParameter("classForTeacher");
				teacherDao.assignTeachersToClass(teacher, standard);
				ArrayList<String> subjects = new ArrayList<String>();
					SQLConnection sqlConnection = new SQLConnection();
					Statement st = sqlConnection.createConnection();
					ResultSet rs = st.executeQuery("select subject_name from tb_subjects_for_class where class='" + standard + "'");
					while(rs.next()) {
						Subject s = new Subject();
						s.setSubjectName(rs.getString("subject_name"));
						subjects.add(s.getSubjectName());
					}
					request.setAttribute("subjects", subjectsForClass.listSubjects(subjects));
					RequestDispatcher rd = request.getRequestDispatcher("administrativeportal.jsp");
					rd.forward(request, response);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
