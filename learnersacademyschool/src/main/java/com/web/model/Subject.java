package com.web.model;

import java.util.ArrayList;

public class Subject {
	
	private int subjectId;
	private String subjectName;
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public String listSubjects(ArrayList<String> subjects) {
		String subjectsForClass = new String();
		for(String subject : subjects) {
			subjectsForClass += subject + "\n";
		}
		return subjectsForClass;
		
	}

	
	
}
