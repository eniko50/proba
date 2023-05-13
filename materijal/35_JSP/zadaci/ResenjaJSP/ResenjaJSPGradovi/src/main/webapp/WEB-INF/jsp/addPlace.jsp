<%@ page import="vp.jsp.JSPCountry.model.Country" %>

<html>
	<body>
	
		<% Country country = (Country) request.getAttribute("country"); %> 
	
		<h1> Unos grada </h1>
		
		<form action="/places/add" method="post">
			<!--  skriveno polje da se posalje id drzave -->
			<input type="hidden" name="countryId" value="<%= country.getId() %>" />
			
			<table>
				<tr>
					<td>Drzava</td>
						<!--  ime drzave se ne moze menjati, zato je polje disabled -->
					<td> <input type="text" name="name" value="<%=country.getName() %>" disabled> </td>
				</tr>
				<tr>
					<td>Ptt broj</td>
					<td> <input type="text" name="zipCode"> </td>
				</tr>				
				<tr>
					<td>Naziv</td>
					<td> <input type="text" name="placeName"> </td>
				</tr>

				<tr>
					<td colspan="2"> 
						<input type="submit" value="Dodaj">
					</td>
				</tr>
				
			</table>
				
		
		</form>
		
	</body>
</html>	