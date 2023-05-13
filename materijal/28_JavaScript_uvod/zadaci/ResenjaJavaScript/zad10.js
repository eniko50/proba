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
];

function dodajStudenta (student,listaStudenata) {
	listaStudenata.push(student);
}

function dodajPolozeniIspit(brojIndeksa,ispit,listaStudenata){
	for(redniBrojStudenta in listaStudenata){
		if(brojIndeksa === listaStudenata[redniBrojStudenta].brojIndeksa){
			listaStudenata[redniBrojStudenta].ispiti.push(ispit);
			break;
		}
	}
}

function pronadjiStudenta (brojIndeksa,listaStudenata) {
	for(indeks in listaStudenata){
		if(brojIndeksa === listaStudenata[indeks].brojIndeksa){
			return listaStudenata[indeks];
		}
	}
}

function pronadjiPredmet(sifraPredmeta, listaStudenata){
	for (var i = 0; i < listaStudenata.length; i++) {
		for (var j = 0; j < listaStudenata[i].ispiti.length; j++) {
			if(listaStudenata[i].ispiti[j].predmet.sifra === sifraPredmeta){
				return listaStudenata[i].ispiti[j].predmet;
			}
		}
	}
}

function pronadjiIspit(sifraPredmeta, brojIndeksa, listaStudenata) {
	for(i in listaStudenata){
		if(listaStudenata[i].brojIndeksa===brojIndeksa){
			for(j in listaStudenata[i].ispiti){
				if(listaStudenata[i].ispiti[j].predmet.sifra===sifraPredmeta){
					return listaStudenata[i].ispiti[j];
				}
			}
		}
	}
}

// brisanje
function obrisiStudenta (brojIndeksa, listaStudenata) {
	for(i in listaStudenata){
		if (listaStudenata[i].brojIndeksa === brojIndeksa) {
			listaStudenata.splice(i,1);
			break;
		}
	}
}

function obrisiPredmet (sifraPredmeta, listaStudenata) {
	for(i in listaStudenata){
		for(j = 0; j < listaStudenata[i].ispiti.length; j++){
			if(listaStudenata[i].ispiti[j].predmet.sifra === sifraPredmeta){
				listaStudenata[i].ispiti.splice(j,1);
				j--;
			}
		}
	}
}

function obrisiIspit (brojIndeksa, sifraPredmeta, listaStudenata) {
	for(i in listaStudenata){
		if(listaStudenata[i].brojIndeksa === brojIndeksa){
			for(j = 0; j < listaStudenata[i].ispiti.length; j++){
				if(listaStudenata[i].ispiti[j].predmet.sifra === sifraPredmeta){
					listaStudenata[i].ispiti.splice(j,1);
					j--;
				}
			}
		}
	}
}

// izmena
function izmenaStudenta (student, listaStudenata) {
	for(i in listaStudenata){
		if(listaStudenata[i].brojIndeksa === student.brojIndeksa){
			listaStudenata[i] = student;
		}
	}
}

function izmenaPredmeta (predmet, listaStudenata){
	for(i in listaStudenata){
		for(j in listaStudenata[i].ispiti){
			if(listaStudenata[i].ispiti[j].predmet.sifra === predmet.sifra){
				listaStudenata[i].ispiti[j].predmet = predmet;
			}
		}
	}
}

function izmenaIspita (brojIndeksa, ispit, listaStudenata) {
	for(i in listaStudenata){
		if(listaStudenata[i].brojIndeksa === brojIndeksa){
			for(j in listaStudenata[i].ispiti){
				if(listaStudenata[i].ispiti[j].predmet.sifra === ispit.predmet.sifra){
					listaStudenata[i].ispiti[j] = ispit;
				}
			}
		}
	}
}

function prosecnaOcena (student) {
	suma = 0;
	for(var i in student.ispiti){
		suma += student.ispiti[i].ocena;
	}
	return suma / student.ispiti.length;
}

function pronalazenjeStudenataPoProsecnojOceni (ocena, listaStudenata) {
	retVal = [];
	for(var i in listaStudenata){
		if(prosecnaOcena(listaStudenata[i]) > ocena){
			retVal.push(listaStudenata[i]);
		}
	}
	return retVal;
}

function pronalazenjeStudentaSaNajvisomProsecnomOcenom (listaStudenata) {
	retVal = listaStudenata[0];
	for (var i = 0; i < listaStudenata.length; i++) {
		if(prosecnaOcena(listaStudenata[i])>prosecnaOcena(retVal)){
			retVal = listaStudenata[i];
		}
	};
	return retVal;
}
 
function sortiranjePoOceni(listaStudenata)
{
    var swapped;
    do {
        swapped = false;
        for (var i=0; i < listaStudenata.length-1; i++) {
            if (prosecnaOcena(listaStudenata[i]) < prosecnaOcena(listaStudenata[i+1])) {
                var temp = listaStudenata[i];
                listaStudenata[i] = listaStudenata[i+1];
                listaStudenata[i+1] = temp;
                swapped = true;
            }
        }
    } while (swapped);
}
 
function ukupnoESPB (student) {
	var retVal = 0;
	for(var i in student.ispiti){
		retVal += student.ispiti[i].predmet.ESPB;
	}
	return retVal;
}

function upisNaredneGodine(listaStudenata){
	var retVal = [];
	for(var i in listaStudenata){
		if(ukupnoESPB(listaStudenata[i]) > listaStudenata[i].godinaStudija * 60){
			retVal.push(listaStudenata[i]);
		}
	}
	return retVal;
}

function ispisiStudente(listaStudenata) {
	var ispis = '';
	for (var i = 0; i < listaStudenata.length; i++) {
		console.log(listaStudenata[i]);
	}
}

/* --------- koriscenje funkcija --------------- */

// dodavanje studenta
s3 = {
	ime:'Milan',
	prezime:'Milanovic',
	godinaStudija:3,
	brojIndeksa:'e777',
	ispiti:[
	{
		ocena:8,
		predmet:{
			naziv:'Matematika',
			sifra:'m1',
			ESPB:8
		}
	}
	]
};
dodajStudenta(s3, studenti);

// dodavanje ispita
ispit1 = {
	ocena:10,
	predmet:{
		naziv:'programiranje',
		sifra:'p1',
		ESPB:8
	}
}
dodajPolozeniIspit('e123', ispit1, studenti);
console.log('Spisak studenata');
ispisiStudente(studenti);

// pronadji studenta
trazeniStudent = pronadjiStudenta('e777', studenti);
console.log('Pronadjeni student: ', trazeniStudent);

// pronalazenje ispita
i = pronadjiIspit('m1', 'e123', studenti);
console.log('Pronadjeni ispit:', i);

// pronalazenje predmeta
trazeniPredmet = pronadjiPredmet('p1', studenti);
console.log('Pronadjeni predmet', trazeniPredmet);

// izmena studenta
s3 = {
	ime:'Nenad',
	prezime:'Milanovic',
	godinaStudija:3,
	brojIndeksa:'e777',
	ispiti:[
	{
		ocena:8,
		predmet:{
			naziv:'Matematika',
			sifra:'m1',
			ESPB:8
		}
	}
	]
};

izmenaStudenta(s3, studenti);
trazeniStudent = pronadjiStudenta('e777', studenti);
console.log('Izmenjeni student: ', trazeniStudent);

// izmena ispita
ispit1 = {
	ocena:9,
	predmet:{
		naziv:'programiranje',
		sifra:'p1',
		ESPB:8
	}
};
izmenaIspita('e123', ispit1, studenti);
console.log('Student sa izmenjenim ispitom:', pronadjiStudenta('e123', studenti));

// izmena predmeta
predmet = {
	naziv:'Osnove programiranja',
	sifra:'p1',
	ESPB:8
};
izmenaPredmeta(predmet, studenti);
trazeniPredmet = pronadjiPredmet('p1', studenti);
console.log('Izmenjeni predmet', trazeniPredmet);

// prosecna ocena
trazeniStudent = pronadjiStudenta('e333', studenti);
prosek = prosecnaOcena(trazeniStudent, studenti);
console.log('Prosecna ocena za studenta sa indeksom e123:', prosek);

// studenti sa prosecnom ocenom
trazeniStudenti = pronalazenjeStudenataPoProsecnojOceni(9, studenti);
console.log('Studenti sa prosekom vecim od 9', trazeniStudenti);

// student sa najvisim prosekom
studentSaNajvisimProsekom = pronalazenjeStudentaSaNajvisomProsecnomOcenom(studenti);
console.log('Student sa najvisim prosekom', studentSaNajvisimProsekom);

// sortiranje po prosecnoj oceni
sortiranjePoOceni(studenti);
console.log('Sortirani studenti', studenti);

// ukupno osvojenih ESPB
bodovi = ukupnoESPB(s3, studenti);
console.log('Student', s3, 'osvojio ukupno ESPB', bodovi);

// studenti koji mogu da upisu narednu godinu
studentiZaUpis = upisNaredneGodine(studenti);
console.log('Studenti za upis naredne godine', studentiZaUpis);

// obrisi predmet
obrisiPredmet('m2', studenti);
obrisaniPredmet = pronadjiPredmet('m2', studenti); // ne sme biti nadjen
console.log('Obrisani predmet: ', obrisaniPredmet); // mora biti undefined jer je obrisan

// obrisi ispit
obrisiIspit('e123', 'p1', studenti);
console.log(pronadjiStudenta('e123', studenti)); // ne sme imati ispit p1 u listi ispita

// obrisi studenta
obrisiStudenta('e777', studenti);
console.log(studenti); // ne sme biti e777 u spisku studenata
