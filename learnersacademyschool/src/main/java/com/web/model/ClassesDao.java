package com.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.web.repository.SQLConnection;

public class ClassesDao {
	
	public HashMap<Integer,String> getClasses() throws SQLException {
		HashMap<Integer,String> classes = new HashMap<Integer,String>();
		
			SQLConnection sqlConnection = new SQLConnection();
			Statement st = sqlConnection.createConnection();
			ResultSet rs = st.executeQuery("select * from tb_class");
			while(rs.next()) {
				classes.put(rs.getInt("class_id"), rs.getString("class"));
			}
		
		return classes;
	}
	
	public void assignClass(String subject, String standard) throws SQLException {
		int classId = 0;
		int subjectId = 0;
			SQLConnection sqlConnection = new SQLConnection();
			Connection con = sqlConnection.getConnection();
			Statement st = sqlConnection.createConnection();
			ResultSet rs1 = st.executeQuery("select class_id from tb_class where class='" + standard + "'");
			if(rs1.next()) {
				classId = rs1.getInt("class_id");
			}
			ResultSet rs2 = st.executeQuery("select subject_id from tb_subject where subject_name='" + subject + "'");
			if(rs2.next()) {
				subjectId = rs2.getInt("subject_id");
			}
			PreparedStatement ps = con.prepareStatement("insert into tb_subjects_for_class (class_id,subject_id,class,subject_name) values(?,?,?,?)");
			ps.setInt(1, classId);
			ps.setInt(2, subjectId);
			ps.setString(3, standard);
			ps.setString(4, subject);
			ps.execute();
		}
		
	}

