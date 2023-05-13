'use strict';

var listaFunkcija = [];

var _loop = function _loop(i) {
	listaFunkcija.push(function () {
		console.log('pozvana je funkcija na indeksu', i - 1);
	});
};

for (var i = 0; i < 5; i++) {
	_loop(i);
}
listaFunkcija[2]();
