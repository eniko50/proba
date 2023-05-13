function ispisiStudente() {
	ulStudenti = document.getElementById('studenti');
	htmlStudenti = '';
	for (var i = 0; i < studenti.length; i++) {
		htmlStudenti += '<li>'+ studenti[i].brojIndeksa + ' ' + studenti[i].ime + ' ' + studenti[i].prezime 
					 +' <button onclick="izbrisiStudenta('+i+')">izbrisi</button></li>';
	};
	ulStudenti.innerHTML = htmlStudenti;
}

function dodajStudentaSaHtmlom() {
	var brojIndeksa = document.getElementById('brojIndeksa').value;
	var ime = document.getElementById('ime').value;
	var prezime = document.getElementById('prezime').value;
	var godinaStudija = document.getElementById('godinaStudija').value;

	var noviStudent = {
		brojIndeksa: brojIndeksa,
		ime: ime,
		prezime: prezime,
		godinaStudija: godinaStudija
	};

	dodajStudenta(noviStudent, studenti);
	ispisiStudente();
}
