<%@ page import="vp.jsp.students.model.Course" %>

<html>
	<body>
		<h1> Unos kursa </h1>
		
		<%  Course course = (Course) request.getAttribute("course"); 
			if (course == null) {
				course = new Course(-1, "", 0);  
			}
		%>
		
		<form action="/courses/save" method="post">
			<input type="hidden" name="id" value="<%= course.getId() %>" /> 
			<table>
				<tr>
					<td> Naziv </td>
					<td> <input type="text" name="name" value="<%=course.getName() %>"> </td>
				</tr>
				
				<tr>
					<td>ESPB </td>
					<td> <input type="text" name="espb" value="<%=course.getEspb() %>"> </td>
				</tr>
				
				<tr>
					<td colspan="2"> 
					<%if (course.getId() == -1) { %>
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