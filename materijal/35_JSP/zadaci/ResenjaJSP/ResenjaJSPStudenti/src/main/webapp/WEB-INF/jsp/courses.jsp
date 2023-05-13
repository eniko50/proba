<!DOCTYPE html>
<%@ page import="vp.jsp.students.model.Course" %>
<%@ page import="java.util.List" %>

<html>

	<body>
		<h1> Predmeti </h1>
		
		<% List<Course> courses = (List<Course>) request.getAttribute("courses"); %>
		
		<table>
			<tr>
				<th>Naziv</th>
				<th>ESPB</th>
				<th></th>
				<th></th>
			</tr>
			<% for (Course course: courses) { %> 
			
			<tr>
				<td> <%= course.getName() %> </td>
				<td> <%= course.getEspb() %> </td>
				<td> <a href="/courses/remove?id=<%=course.getId() %>">Obrisi</a> </td>
				<td> <a href="/modifyCoursePage?id=<%=course.getId() %>">Izmeni</a> </td>
			</tr>
			
			<% } %>    <!-- kraj for petlje -->	
		</table>
		
		<br/>
		
		<a href="/addCoursePage">Dodaj predmet</a>
		
		<p>
			<a href="/">Povratak</a>
		</p>
		
	</body>

</html>