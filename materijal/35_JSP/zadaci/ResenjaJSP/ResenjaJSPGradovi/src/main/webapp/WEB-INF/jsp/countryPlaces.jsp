<%@ page import="vp.jsp.JSPCountry.model.Country" %>
<%@ page import="vp.jsp.JSPCountry.model.Place" %>
<%@ page import="java.util.List" %>

<html>
	<body>
		<h1> Detalji drzave </h1>
		
		<%  
			List<Place> places = (List<Place>) request.getAttribute("places");
			Country country = (Country) request.getAttribute("country"); %>
		
		<table>
			<tr>
				<td> Drzava </td>
				<td> <%=country.getName() %> </td>
			</tr>
			
			<tr>
				<td>Broj stanovnika</td>
				<td> <%=country.getPopulation() %></td>
			</tr>
		</table>
		
		<h2> Gradovi u drzavi </h2>
		<table>
			<tr>
				<th>Ptt broj</th>
				<th>Naziv</th>
				<th></th>
				<th></th>
			</tr>
			
			<% for (Place place: places) { %>
			<tr>
				<td> <%= place.getZipCode() %> </td>
				<td> <%= place.getName() %> </td>
				<td> <a href="/places/remove?id=<%= place.getId() %>">Obrisi</a> </td>
				<td> <a href="/modifyPlacePage?id=<%= place.getId() %>">Izmeni</a> </td>
			</tr>
			
			<% } %>
		
		</table>
		
		<!--  link za dodavanje grada u drzavu. Parametar je id drzave u koju dodajemo grad -->
		<a href="/addPlacePage?countryId=<%= country.getId() %>">Dodaj grad</a>
		
		<!--  Link za povratak na prethodnu stranicu -->
		<p>
			<a href="/countries">Povratak na spisak drzava</a>
		</p>
		
	</body>
</html>	