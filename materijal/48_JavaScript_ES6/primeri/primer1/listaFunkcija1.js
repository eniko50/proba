var listaFunkcija = [];
for (var i = 0; i < 5; i++) {
	listaFunkcija.push(function () {
		console.log('pozvana je funkcija na indeksu',i-1);		
	});
}
listaFunkcija[2]();