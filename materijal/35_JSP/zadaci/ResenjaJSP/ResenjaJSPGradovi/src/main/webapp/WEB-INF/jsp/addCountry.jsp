<%@ page import="vp.jsp.JSPCountry.model.Country" %>

<html>
	<body>
		<h1> Unos drzave </h1>
		
		<%  Country country = (Country) request.getAttribute("country"); 
			// za novu drzavu, nece biti objekta country u zahtevu
			// u tom slucaju postavljamo prazan objekat za drzavu sa id-om -1, kao identifikator da nije postojeca drzava
			if (country == null) {
				country = new Country(-1, "", 0);  
			}
		%>
		
		<!--  Isti URL i za dodavanje i za izmenu drzave -->
		<form action="/countries/save" method="post">
			<input type="hidden" name="id" value="<%= country.getId() %>" /> <!--  skriveno polje da se posalje id drzave pri modifikaciji -->
			<table>
				<tr>
					<td> Naziv </td>
					<td> <input type="text" name="name" value="<%=country.getName() %>"> </td>
				</tr>
				
				<tr>
					<td>Broj stanovnika</td>
					<td> <input type="text" name="population" value="<%=country.getPopulation() %>"> </td>
				</tr>
				
				<tr>
					<td colspan="2"> <!--  Na dugmetu pise Dodaj ili Izmeni, zavisno od toga da li menjamo ili unosimo drzavu -->
					<%if (country.getId() == -1) { %>
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