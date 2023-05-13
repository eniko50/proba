var listaFunkcija = [];
for (var i = 0; i < 5; i++) {
	(function (x) {
		listaFunkcija.push(function () {
			console.log('pozvana je funkcija na indeksu',x-1);		
		});
	}(i));
}
listaFunkcija[2]();