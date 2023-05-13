<%@ page import="vp.jsp.students.model.Student" %>
<%@ page import="vp.jsp.students.model.Exam" %>
<%@ page import="java.util.List" %>

<html>
	<body>
		<h1> Ispiti studenta </h1>
		
		<%  
			List<Exam> exams = (List<Exam>) request.getAttribute("exams");
			Student student = (Student) request.getAttribute("student"); %>
		
		<table>
			<tr>
				<td> Student </td>
				<td> <%= student.getCardNumber() %> <%= student.getFirstName() %> <%= student.getLastName() %> </td>
			</tr>
			
		</table>
		
		<h2> Ispiti studenta </h2>
		<table>
			<tr>
				<th>Predmet</th>
				<th>Ocena</th>
				<th></th>
			</tr>
			
			<% for (Exam exam: exams) { %>
			<tr>
				<td> <%= exam.getCourse().getName() %> </td>
				<td> <%= exam.getGrade() %> </td>
				<td> <a href="/exams/remove?id=<%= exam.getId() %>">Obrisi</a> </td>
			</tr>
			
			<% } %>
		
		</table>
		
		<a href="/addExamPage?studentId=<%= student.getId() %>">Dodaj ispit</a>
		
		<!--  Link za povratak na prethodnu stranicu -->
		<p>
			<a href="/students">Povratak</a>
		</p>
		
	</body>
</html>	