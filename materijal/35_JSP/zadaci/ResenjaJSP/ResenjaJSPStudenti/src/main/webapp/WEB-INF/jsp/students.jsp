<!DOCTYPE html>
<%@ page import="vp.jsp.students.model.Student" %>
<%@ page import="java.util.List" %>

<html>

	<body>
		<h1> Studenti </h1>
		
		<% List<Student> students = (List<Student>) request.getAttribute("students"); %>
		
		<table>
			<tr>
				<th>Broj indeksa</th>
				<th>Ime</th>
				<th>Prezime</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<% for (Student student: students) { %> 
			
			<tr>
				<td> <%= student.getCardNumber() %> </td>
				<td> <%= student.getFirstName() %> </td>
				<td> <%= student.getLastName() %> </td>
				<td> <a href="/students/remove?id=<%=student.getId() %>">Obrisi</a> </td>
				<td> <a href="/modifyStudentPage?id=<%=student.getId() %>">Izmeni</a> </td>
				<td> <a href="/examsPage?studentId=<%=student.getId() %>">Ispiti</a> </td>
			</tr>
			
			<% } %>    <!-- kraj for petlje -->	
		</table>
		
		<br/>
		
		<a href="/addStudentPage">Dodaj studenta</a>
		
		<p>
			<a href="/">Povratak</a>
		</p>
	</body>

</html>