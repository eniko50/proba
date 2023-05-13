<!DOCTYPE html>
<%@ page import="vp.jsp.JSPCountry.model.Country" %>
<%@ page import="java.util.List" %>

<html>

	<body>
		<% 
			// preuzmemo tekst koji treba prikazati u search polju (tekst unesen pri prethodnoj pretrazi)
			String searchText = (String) request.getAttribute("searchText");
			// kada tek dodjemo na stranicu, ovaj atribut ce biti null
			if (searchText == null) {
				searchText = "";
			}
		%>
	
		<h1> Drzave </h1>
		
		<form action="/countries/search" method="get">
			<input type="text" name="searchValue" value="<%= searchText %>" >
			<input type="submit" value="Trazi">
		</form>
		
		<% List<Country> countries = (List<Country>) request.getAttribute("countries"); %>
		
		<table>
			<tr>
				<th>Naziv</th>
				<th>Populacija</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<% for (Country country: countries) { %> <!-- dinamicki dodamo onoliko redova u tabelu koliko ima drzava u listi -->
			
			<tr>
				<td> <%= country.getName() %> </td>
				<td> <%= country.getPopulation() %> </td>
				<td> <a href="/countries/remove?id=<%=country.getId() %>">Obrisi</a> </td>
				<td> <a href="/modifyCountryPage?id=<%=country.getId() %>">Izmeni</a> </td>
				<td> <a href="/placesPage?countryId=<%=country.getId() %>">Detalji</a> </td>
			</tr>
			
			<% } %>    <!-- kraj for petlje -->	
		</table>
		
		<br/>
		
		<a href="/addCountryPage">Dodaj drzavu</a>
	</body>

</html>