<%@ page import="vp.jsp.JSPCountry.model.Country" %>

<html>
<body>
	<h1>Unos drzave</h1>

	<%
		Country country = (Country) request.getAttribute("country");
		if (country == null) {
			country = new Country(-1, "", 0);
		}
	%>

	<form action="/countries/add" method="post">
		<input type="hidden" name="id"
			value="<%= country.getId() %>">
		<table>
			<tr>
				<td>Naziv</td>
				<td><input type="text" name="name"
						value="<%= country.getName() %>"></td>
			</tr>

			<tr>
				<td>Broj stanovnika</td>
				<td><input type="text" name="population"
						value="<%= country.getPopulation() %>"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Dodaj"></td>
			</tr>
		</table>
	</form>

</body>
</html>
