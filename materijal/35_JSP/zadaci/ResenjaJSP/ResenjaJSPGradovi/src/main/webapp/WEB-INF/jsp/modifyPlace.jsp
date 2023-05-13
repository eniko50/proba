<%@ page import="vp.jsp.JSPCountry.model.Country" %>
<%@ page import="vp.jsp.JSPCountry.model.Place" %>

<html>
	<body>
	
		<% 	Country country = (Country) request.getAttribute("country"); 
			Place place = (Place) request.getAttribute("place");
		%> 
	
		<h1> Izmena grada </h1>
		
		<form action="/places/modify" method="post">
			<!--  skriveno polje da se posalje id drzave -->
			<input type="hidden" name="countryId" value="<%= country.getId() %>" />
			<!--  skriveno polje da se posalje id grada -->
			<input type="hidden" name="id" value="<%= place.getId() %>" />
			
			<table>
				<tr>
					<td>Drzava</td>
						<!--  ime drzave se ne moze menjati, zato je polje disabled -->
					<td> <input type="text" name="name" value="<%=country.getName() %>" disabled> </td>
				</tr>
				<tr>
					<td>Ptt broj</td>
					<td> <input type="text" name="zipCode" value="<%= place.getZipCode()%>"> </td>
				</tr>				
				<tr>
					<td>Naziv</td>
					<td> <input type="text" name="placeName" value="<%= place.getName() %>"> </td>
				</tr>

				<tr>
					<td colspan="2"> 
						<input type="submit" value="Izmeni">
					</td>
				</tr>
				
			</table>
				
		
		</form>
		
	</body>
</html>	