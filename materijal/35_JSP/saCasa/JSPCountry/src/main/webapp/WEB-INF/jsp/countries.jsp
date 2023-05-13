<!DOCTYPE html>
<%@ page import="vp.jsp.JSPCountry.model.Country" %>
<%@ page import="java.util.List" %>

<html>

	<body>
		<h1> Drzave </h1>
		
		<% List<Country> countries = (List<Country>) request.getAttribute("countries"); %>

		<form action="/countries">
			<input type="text" name="query"
				value="<%= request.getParameter("query") %>">
			<input type="submit" value="Pretrazi">
		</form>
		
		<table>
			<tr>
				<th>Naziv</th>
				<th>Populacija</th>
			</tr>
			<% for (Country country: countries) { %> <!-- dinamicki dodamo onoliko redova u tabelu koliko ima drzava u listi -->
			
			<tr>
				<td> <%= country.getName() %> </td>
				<td> <%= country.getPopulation() %> </td>
				<td><a href="/countries/edit/<%= country.getId() %>">Izmeni</a></td>
				<td><a href="/countries/delete/<%= country.getId() %>">Obrisi</a></td>
			</tr>
			
			<% } %>    <!-- kraj for petlje -->	
		</table>
		
		<br/>
		
		<a href="/addCountryPage">Dodaj drzavu</a>
	</body>

</html>