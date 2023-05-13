<!DOCTYPE html>


<html>

	<body>
		<h1>		
			<!--  JSP Expression. Prikazuje atribut message koji je ranije postavljen -->
		
			<%= request.getAttribute("message") %>  
		</h1>
		
		<a href="/countries">Spisak drzava</a>
	</body>

</html>