package com.web.model;

import java.sql.*;
import java.util.HashMap;

import com.web.repository.SQLConnection;

public class StudentDao {
	
	public HashMap<Integer,String> getStudents() {
		HashMap<Integer,String> students = new HashMap<Integer,String>();
		
		try {
			
			SQLConnection sqlConnection = new SQLConnection();
			Statement st = sqlConnection.createConnection();
			ResultSet rs = st.executeQuery("select * from tb_student");
			while(rs.next()) {
				students.put(rs.getInt("student_id"), rs.getString("student_name"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return students;
	}
	
	public void assignStudents(String student, String standard) throws SQLException {
		int studentId = 0;
		int classId = 0;
			SQLConnection sqlConnection = new SQLConnection();
			Connection con = sqlConnection.getConnection();
			Statement st = sqlConnection.createConnection();
			ResultSet rs1 = st.executeQuery("select class_id from tb_class where class='" + standard + "'");
			if(rs1.next()) {
				classId = rs1.getInt("class_id");
			}
			ResultSet rs2 = st.executeQuery("select student_id from tb_student where student_name='" + student + "'");
			if(rs2.next()) {
				studentId = rs2.getInt("student_id");
			}
			PreparedStatement ps = con.prepareStatement("insert into tb_class_for_student (student_id,class_id,student_name,class) values(?,?,?,?)");
			ps.setInt(1, studentId);
			ps.setInt(2, classId);
			ps.setString(3, student);
			ps.setString(4, standard);
			ps.execute();
		}
	

}
