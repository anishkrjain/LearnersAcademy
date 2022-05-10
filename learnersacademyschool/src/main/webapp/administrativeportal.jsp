<%@page import="com.web.model.SubjectDao"%>
<%@page import="com.web.model.Subject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.web.repository.SQLConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.div1 {
  border: 2px solid white;
  margin: 20px;
  padding: 20px;
}
.div2 {
  border: 2px solid white;
  margin: 20px;
  padding: 20px;
  padding-top: 140px;
  padding-bottom: 140px;
}
.input {
    padding: 0;
    height: 30px;
    position: relative;
    left: 0;
    outline: none;
    border: 1px solid #cdcdcd;
    border-color: rgba(0,0,0,.15);
    background-color: white;
    font-size: 16px;
}

.button-73 {
  appearance: none;
  background-color: #FFFFFF;
  border-radius: 40em;
  border-style: none;
  box-shadow: #ADCFFF 0 -12px 6px inset;
  box-sizing: border-box;
  color: #000000;
  cursor: pointer;
  display: inline-block;
  font-family: -apple-system,sans-serif;
  font-size: 1.2rem;
  font-weight: 700;
  letter-spacing: -.24px;
  margin: 0;
  outline: none;
  padding: 1rem 1.3rem;
  quotes: auto;
  text-align: center;
  text-decoration: none;
  transition: all .15s;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}

.button-73:hover {
  background-color: #FFC229;
  box-shadow: #FF6314 0 -6px 8px inset;
  transform: scale(1.125);
}

.button-73:active {
  transform: scale(1.025);
}

@media (min-width: 768px) {
  .button-73 {
    font-size: 1rem;
  }
}
.text1 {
  background-color: yellow;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 10px;
}
select {
        appearance: none;
        outline: 0;
        background: white;
        background-image: none;
        width: 100%;
        height: 100%;
        color: black;
        cursor: pointer;
        border: 2px solid #ccc;
        border-radius: 3px;
        font: Arial;
        font-size: 18px;
    }
.select {
        position: relative;
        display: inline-block;
        width: 15em;
        height: 2em;
        line-height: 3;
        overflow: hidden;
        border-radius: .25em;
        padding-bottom: 15px;
        padding-top: 15px;
    }
.h3 {
	color: black;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 35px;
}
</style>
</head>
<script>
function getSpecificSubjects(){
	document.getElementById("specificSubjects").style.visibility = 'visible';
}
</script>
<body>
	<h3 class="h3">Welcome to Learner's Academy administrative portal</h3>
	<table>
	<tr>
	<th>
		<div class="div1">
			<ul style="list-style-type:none">
			<li>
			<form action="ClassControllerServlet" method="GET">
			<button type="submit" name = "classes" class="button-73" role="button">All classes</button>
			</form>
			<br/>
			</li>
			<li>
			<form action="SubjectControllerServlet" method="GET">
			<button type="submit" name = "subjects" class="button-73" role="button">All subjects</button>
			</form>
			<br/>
			</li>
			<li>
			<form action="TeacherControllerServlet" method="GET">
			<button type="submit" name = "teachers" class="button-73" role="button">All teachers</button>
			</form>
			<br/>
			</li>		
			<li>
			<form action="StudentControllerServlet" method="GET">
			<button type="submit" name = "students" class="button-73" role="button">All students</button>
			</form>
			<br/>
			</li>
			</ul>		
		</div>
	</th>
	<th>
		<div class="div1">
			<ul style="list-style-type:none">
			<li>
				<form action="AssignClassServlet" method="POST">
				<select class="form-control" name="subject">
				<option value="-1">Select subject</option>
				<%
				String teacher = new String();
				String standard = new String();
				try{
					SQLConnection sqlConnection = new SQLConnection();
					Statement st = sqlConnection.createConnection();
					ResultSet rs1 = st.executeQuery("select * from tb_subject");
					while(rs1.next()){
						%>
						<option value="<%=rs1.getString("subject_name")%>"><%=rs1.getString("subject_name")%></option>
						<%
					}
					%>
					</select>
						<select class="form-control" name="class" class="input">
						<option value="-1">Select class</option>
					<%
					ResultSet rs2 = st.executeQuery("select * from tb_class");
					while(rs2.next()){
						%>
						<option value="<%=rs2.getString("class")%>"><%=rs2.getString("class")%></option>
						<%
					}
					%>
					</select>
					<%
				}
				catch(Exception ex){
					out.println(ex.getMessage());
				}
				%>
				<button type="submit" class="button-73" role="button">Assign subject to class</button>
				</form>
				<br/>
			</li>
			<li>
				<form action="AssignStudentsServlet" method="POST">
				<select class="form-control" name="student" class="input">
				<option value="-1">Select student</option>
				<%
				try{
					SQLConnection sqlConnection = new SQLConnection();
					Statement st = sqlConnection.createConnection();
					ResultSet rs1 = st.executeQuery("select * from tb_student order by student_id ASC");
					while(rs1.next()){
						%>
						<option value="<%=rs1.getString("student_name")%>"><%=rs1.getString("student_name")%></option>
						<%
					}
					%>
					</select>
						<select class="form-control" name="classForStudent" class="input">
						<option value="-1">Select class</option>
					<%
					ResultSet rs2 = st.executeQuery("select * from tb_class");
					while(rs2.next()){
						%>
						<option value="<%=rs2.getString("class")%>"><%=rs2.getString("class")%></option>
						<%
					}
					%>
					</select>
					<%
				}
				catch(Exception ex){
					out.println(ex.getMessage());
				}
				%>
				<button type="submit" class="button-73" role="button">Assign student to class</button>
				</form>
				<br/>
			</li>
			<li>
				<form action="AssignTeachersServlet" method="POST">
				<select class="form-control" name="teacher" id="teacherId">
				<option value="-1">Select teacher</option>
				<%
				try{
					SQLConnection sqlConnection = new SQLConnection();
					Statement st = sqlConnection.createConnection();
					ResultSet rs1 = st.executeQuery("select * from tb_teacher");
					while(rs1.next()){
						%>
						<option value="<%=rs1.getString("teacher_name")%>"><%=rs1.getString("teacher_name")%></option>
						<%
					}
					%>
					</select>
						<select class="form-control" name="classForTeacher" id="classForTeacher">
						<option value="-1">Select class</option>
					<%
					ResultSet rs2 = st.executeQuery("select * from tb_class");
					while(rs2.next()){
						%>
						<option value="<%=rs2.getString("class")%>"><%=rs2.getString("class")%></option>
						<%
					}
					%>
					</select>
					<button type="submit" name="submitForAssignTeacher" value="Assign class to teacher" class="button-73" role="button">Assign class to teacher</button>
					<%
				}
				catch(Exception ex){
					out.println(ex.getMessage());
				}
				%>
				</form>
				<br/>
			</li>
			<li>
			</li>
			<li style="visibility: hidden;" id = "specificSubjects">
			<%
			String subjects = (String)request.getAttribute("subjects");
			out.println("Please enter a subject from the list to assign to teacher : ");
			out.println("<BR>");
			out.println(subjects);
			%>
			</li>
			<li>
			<form action="AssignTeachersServlet" method="POST" id="getSpecificSubjects">
				<input style="visibility: hidden;" type="text" name="teacher1" value=<%=request.getParameter("teacher") %>>
				<input style="visibility: hidden;" type="text" name="class1" value=<%=request.getParameter("classForTeacher") %>> 
				<br/>
				<input type="text" name="subjectForTeacher" placeholder="Enter subject from selected class" class="input" onclick="return getSpecificSubjects();">
				<input type="submit" name="submitForAssignTeacher" value="Assign subject to teacher" class="button-73" role="button">
			</form>
			</li>
			</ul>
		</div>
	</th>
	<th>
	<div class="div2">
	<form action="GenerateClassReportServlet" method="POST">
		<input type="text" name="userInput" placeholder="Enter class" class="input">
		<input type="submit" value="Generate class report" class="button-73" role="button">
	</form>
	</div>
	</th>
	</tr>
	</table>
</body>
</html>