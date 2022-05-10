package com.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.web.repository.SQLConnection;

public class SubjectDao {
	
	public HashMap<Integer,String> getSubjects() throws SQLException {
		HashMap<Integer,String> subjects = new HashMap<Integer,String>();
		
			SQLConnection sqlConnection = new SQLConnection();
			Statement st = sqlConnection.createConnection();
			ResultSet rs = st.executeQuery("select * from tb_subject");
			while(rs.next()) {
				subjects.put(rs.getInt("subject_id"), rs.getString("subject_name"));
			}
		
		return subjects;
	}
	
	public void assignSubjects(String teacher, String standard, String subject) throws SQLException {
		int teacherId = 0;
		int classId = 0;
		int subjectId = 0;
			SQLConnection sqlConnection = new SQLConnection();
			Connection con = sqlConnection.getConnection();
			Statement st = sqlConnection.createConnection();
			ResultSet rs1 = st.executeQuery("select teacher_id from tb_teacher where teacher_name='" + teacher + "'");
			if(rs1.next()) {
				teacherId = rs1.getInt("teacher_id");
			}
			ResultSet rs2 = st.executeQuery("select class_id from tb_class where class='" + standard + "'");
			if(rs2.next()) {
				classId = rs2.getInt("class_id");
			}
			ResultSet rs3 = st.executeQuery("select subject_id from tb_subject where subject_name='" + subject + "'"); 
			if(rs3.next()) {
				subjectId = rs3.getInt("subject_id");
			}
			PreparedStatement ps = con.prepareStatement("insert into tb_assign_teachers (class_id,subject_id,teacher_id,class,subject_name,teacher_name) values(?,?,?,?,?,?)");
			ps.setInt(1, classId);
			ps.setInt(2, subjectId);
			ps.setInt(3, teacherId);
			ps.setString(4, standard);
			ps.setString(5, subject);
			ps.setString(6, teacher);
			ps.execute();
		}

}
