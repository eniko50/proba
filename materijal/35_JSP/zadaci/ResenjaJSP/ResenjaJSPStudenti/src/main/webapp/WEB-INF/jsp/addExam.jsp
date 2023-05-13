<%@ page import="vp.jsp.students.model.Student" %>
<%@ page import="vp.jsp.students.model.Course" %>
<%@ page import="java.util.List" %>

<html>
	<body>
	
		<% 	Student student = (Student) request.getAttribute("student"); 
			List<Course> courses = (List<Course>) request.getAttribute("courses");
		%> 
	
		<h1> Unos ispita </h1>
		
		<form action="/exams/add" method="post">
			<input type="hidden" name="studentId" value="<%= student.getId() %>" />
			
			<table>
				<tr>
					<td>Ispit</td>
					<td> <input type="text" name="student" 
						value="<%= student.getCardNumber() %> <%= student.getFirstName() %> <%= student.getLastName() %> " 
						disabled> </td>
				</tr>
				<tr>
					<td>Predmet</td>
					<td> 
					<select name="courseId">
						<% for (Course course: courses) { %>
  						<option value="<%= course.getId() %>"><%= course.getName() %></option>
  						<% } %>
  					</select> 
					
					</td>
				</tr>				
				<tr>
					<td>Ocena</td>
					<td> <input type="text" name="grade"> </td>
				</tr>

				<tr>
					<td colspan="2"> 
						<input type="submit" value="Dodaj">
					</td>
				</tr>
				
			</table>
				
		
		</form>
		
	</body>
</html>	