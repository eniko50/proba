studenti = [
{
	ime:'Pera',
	prezime:'Peric',
	godinaStudija:2,
	brojIndeksa:'e123',
	ispiti:[
	{
		ocena:8,
		predmet:{
			naziv:'Matematika1',
			sifra:'m1',
			ESPB:20
		}
	},
	{
		ocena:8,
		predmet:{
			naziv:'Elektronika',
			sifra:'e1',
			ESPB:20
		}
	},
	{
		ocena:8,
		predmet:{
			naziv:'Mehanika',
			sifra:'me',
			ESPB:20
		}
	},
	{
		ocena:8,
		predmet:{
			naziv:'Matematika2',
			sifra:'m2',
			ESPB:20
		}
	},
	{
		ocena:9,
		predmet:{
			naziv:'Fizika',
			sifra:'f2',
			ESPB:20
		}
	}
	]
},
{
	ime:'Marko',
	prezime:'Markovic',
	godinaStudija:2,
	brojIndeksa:'e333',
	ispiti:[
	{
		ocena:10,
		predmet:{
			naziv:'Matematika',
			sifra:'m1',
			ESPB:8
		}
	}
	]
}
]

function prikaziStudente(studenti){
	var ulStudenti = document.getElementById('studenti');
	var htmlStudenti = '';
	for (var i = 0; i < studenti.length; i++) {
		htmlStudenti += '<li>'+studenti[i].brojIndeksa+' '+studenti[i].godinaStudija+' '+
		studenti[i].ime+' '+studenti[i].prezime+
		' <button onclick="obrisiStudentaSaHTML(\''+studenti[i].brojIndeksa+'\')">izbrisi</button>'+
		' <button onclick="prikaziPolozeneIspite(\''+studenti[i].brojIndeksa+'\')">prikazi ispite</button></li>';
	};
	ulStudenti.innerHTML = htmlStudenti;
}

function dodajStudentaSaHTML () {
	var student = {};
	student.ime = document.getElementById('ime').value;
	student.prezime = document.getElementById('prezime').value;
	student.brojIndeksa = document.getElementById('brojIndeksa').value;
	student.godinaStudija = document.getElementById('godinaStudija').value;
	dodajStudenta(student, studenti);
	prikaziStudente(studenti);
}

function obrisiStudentaSaHTML (indeks) {
	obrisiStudenta(indeks, studenti);
	prikaziStudente(studenti);
}

function  izmeniPodatkeOStudentuSaHTML () {
	var ime = document.getElementById('ime').value;
	var prezime = document.getElementById('prezime').value;
	var brojIndeksa = document.getElementById('brojIndeksa').value;
	var godinaStudija = document.getElementById('godinaStudija').value;
	izmenaPodatakaStudenta(brojIndeksa, ime, prezime, godinaStudija, studenti);
	prikaziStudente(studenti);
}

function prikaziIspite (student) {
	var divIspiti = document.getElementById('ispiti');
	var htmlIspiti = 'Student '+student.ime+' '+student.prezime+' je polozio sledece ispite:<ul>';
	for (var i = 0; i < student.ispiti.length; i++) {
		htmlIspiti += '<li>'+student.ispiti[i].predmet.naziv+' '+student.ispiti[i].ocena+'</li>';
	};
	htmlIspiti+='</ul>';
	divIspiti.innerHTML = htmlIspiti;
}

function prikaziPolozeneIspite (brojIndeksa) {
	var student = pronadjiStudenta(brojIndeksa, studenti);
	prikaziIspite(student);
}

function filtriraj(){
	var prosecnaOcena = document.getElementById('prosecnaOcena').value;
	var filtriraniStudenti = pronalazenjeStudenataPoProsecnojOceni(prosecnaOcena, studenti);
	prikaziStudente(filtriraniStudenti);
}

function dodajIspitSaHTML(){
	var brojIndeksa = document.getElementById('ispitBrojIndeksa').value;
	var predmet = {};
	var ispit = {};
	ispit.ocena = document.getElementById('ocena').value;
	predmet.naziv = document.getElementById('nazivPredmeta').value;
	predmet.sifra = document.getElementById('sifraPredmeta').value;
	predmet.espb = document.getElementById('espb').value;
	ispit.predmet = predmet;
	dodajPolozeniIspit(brojIndeksa, ispit, studenti);
}