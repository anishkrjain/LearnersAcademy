package com.web.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.web.repository.SQLConnection;

public class TeacherDao {
	
	public HashMap<Integer,String> getTeachers() {
		HashMap<Integer,String> teachers = new HashMap<Integer,String>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_learnersacademy","root","Samiksha123@!");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from tb_teacher");
			while(rs.next()) {
				teachers.put(rs.getInt("teacher_id"), rs.getString("teacher_name"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return teachers;
	}
	
	
	public void assignTeachersToClass(String teacher, String standard) throws SQLException {
		int teacherId = 0;
		int classId = 0;
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
		PreparedStatement ps = con.prepareStatement("insert into tb_class_for_teachers (teacher_id,class_id,teacher,class) values(?,?,?,?)");
		ps.setInt(1, teacherId);
		ps.setInt(2, classId);
		ps.setString(3, teacher);
		ps.setString(4, standard);
		ps.execute();
	}

}
