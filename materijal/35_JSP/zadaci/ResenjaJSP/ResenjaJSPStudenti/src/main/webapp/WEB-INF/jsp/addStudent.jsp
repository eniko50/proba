<%@ page import="vp.jsp.students.model.Student" %>

<html>
	<body>
		<h1> Unos studenta </h1>
		
		<%  Student student = (Student) request.getAttribute("student"); 
			if (student == null) {
				student = new Student(-1, "", "", "");  
			}
		%>
		
		<form action="/students/save" method="post">
			<input type="hidden" name="id" value="<%= student.getId() %>" /> 
			<table>
				<tr>
					<td> Broj indeksa </td>
					<td> <input type="text" name="cardNumber" value="<%=student.getCardNumber() %>"> </td>
				</tr>
				
				<tr>
					<td>Ime </td>
					<td> <input type="text" name="firstName" value="<%=student.getFirstName() %>"> </td>
				</tr>
				
				<tr>
					<td> Prezime </td>
					<td> <input type="text" name="lastName" value="<%=student.getLastName() %>"> </td>
				</tr>
				
				<tr>
					<td colspan="2"> 
					<%if (student.getId() == -1) { %>
					<input type="submit" value="Dodaj">
					<% } else { %>
					 <input type="submit" value="Izmeni">
					<% } %>
					</td>
				</tr>
				
			</table>
			
			
		
		</form>
		
	</body>
</html>	