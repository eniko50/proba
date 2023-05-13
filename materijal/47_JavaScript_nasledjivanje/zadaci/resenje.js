var Osoba = function (spec) {
	var that = {
		ime: spec.ime,
		prezime: spec.prezime
	};

	return that;
}

var Student = function (spec) {
	var that = Osoba(spec);

	Student.brojac = Student.hasOwnProperty('brojac') ? (Student.brojac + 1) : 1;

	that.indeks = Student.brojac;
	that.ispiti = spec.ispiti || [];

	that.indexOfIspit = function (sifra) {
		for (var i = 0; i < this.ispiti.length; i++) {
			var ispit = this.ispiti[i];
			if (ispit.predmet.sifra === sifra) {
				return i;
			}
		}

		return -1;
	};

	that.pronadjiIspit = function (sifra) {
		var idx = this.indexOfIspit(sifra);
		if (idx !== -1) {
			return this.ispiti[idx];
		}
	};

	that.obrisiIspit = function (sifra) {
		var idx = this.indexOfIspit(sifra);
		var nasaoIspit = idx !== -1;
		if (nasaoIspit) {
			this.ispiti.splice(idx, 1);
		}

		return nasaoIspit;
	};

	that.izmeniIspit = function (izmenjenIspit) {
		var ispit = this.pronadjiIspit(izmenjenIspit.predmet.sifra);
		if (ispit) {
			ispit.ocena = izmenjenIspit.ocena;
		}
	};

	that.prosecnaOcena = function() {
		if (!this.ispiti.length) {
			return 0;
		}

		var sum = 0;

		for (var i = 0; i < this.ispiti.length; i++) {
			var ispit = this.ispiti[i];
			sum += ispit.ocena;
		}
	
		sum /= this.ispiti.length;
		return sum;
	};

	that.ukupnoBodova = function () {
		var sum = 0;
		for (var i = 0; i < this.ispiti.length; i++) {
			var ispit = this.ispiti[i];
			sum += ispit.predmet.espb;
		}

		return sum;
	};

	return that;
}

var PolozeniIspit = function (spec) {
	var that = {
		ocena: spec.ocena,
		predmet: spec.predmet
	};

	return that;
}

var Predmet = function (spec) {
	var that = {
		sifra: spec.sifra,
		naziv: spec.naziv,
		espb: spec.espb
	};

	return that;
}

var StudentskaSluzba = function (spec) {
	var studenti = [];
	var predmeti = [];
	var that = {};

	var indexOfStudent = function (indeks) {
		for (var i = 0; i < studenti.length; i++) {
			var student = studenti[i];
			if (student.indeks === indeks) {
				return i;
			}
		}

		return -1;
	};

	var indexOfPredmet = function (sifra) {
		for (var i = 0; i < predmeti.length; i++) {
			var predmet = predmeti[i];
			if (predmet.sifra === sifra) {
				return i;
			}
		}

		return -1;
	}

	that.dodajStudenta = function (student) {
		studenti.push(student);
	};

	that.dodajPredmet = function (predmet) {
		predmeti.push(predmet);
	};

	that.dodajIspit = function (indeks, ispit) {
		var idx = indexOfStudent(indeks);
		if (idx !== -1) {
			studenti[idx].ispiti.push(ispit);
		}
	};

	that.pronadjiStudenta = function (indeks) {
		var idx = indexOfStudent(indeks);
		if (idx !== -1) {
			return studenti[idx];
		}
	};

	that.pronadjiPredmet = function (sifra) {
		var idx = indexOfPredmet(sifra);
		if (idx !== -1) {
			return predmeti[idx];
		}
	};

	that.pronadjiIspit = function (indeks, sifra) {
		var student = this.pronadjiStudenta(indeks);
		if (student) {
			return student.pronadjiIspit(sifra);
		}
	};

	that.obrisiStudenta = function (indeks) {
		var idx = indexOfStudent(indeks);
		var nasaoStudenta = idx !== -1;
		if (nasaoStudenta) {
			studenti.splice(idx, 1);
		}

		return nasaoStudenta;
	};

	that.obrisiPredmet = function (sifra) {
		var idx = indexOfPredmet(sifra);
		var nasaoPredmet = idx !== -1;
		if (nasaoPredmet) {
			predmeti.splice(idx, 1);
		}

		for (var i = 0; i < studenti.length; i++) {
			studenti[i].obrisiIspit(sifra);
		}

		return nasaoPredmet;
	};

	that.obrisiIspit = function (indeks, sifra) {
		var student = this.pronadjiStudenta(indeks);
		var nasaoIspit = false;
		if (student) {
			nasaoIspit = student.obrisiIspit(sifra);
		}

		return nasaoIspit;
	};

	that.izmeniStudenta = function (izmenjenStudent) {
		var student = this.pronadjiStudenta(izmenjenStudent.indeks);
		if (student) {
			student.ime = izmenjenStudent.ime;
			student.prezime = izmenjenStudent.prezime;
		}
	};

	that.izmeniPredmet = function (izmenjenPredmet) {
		var predmet = this.pronadjiPredmet(izmenjenPredmet.sifra);
		if (predmet) {
			predmet.naziv = izmenjenPredmet.naziv;
			predmet.espb = izmenjenPredmet.espb;
		}
	};

	that.izmeniIspit = function (indeks, izmenjenIspit) {
		var student = this.pronadjiStudenta(indeks);
		if (student) {
			student.izmeniIspit(izmenjenIspit);
		}
	};

	that.pronadjiStudenteSaOcenomVecomOd = function (ocena) {
		var ret = [];
		for (var i = 0; i < studenti.length; i++) {
			var student = studenti[i];
			if (student.prosecnaOcena() > ocena) {
				ret.push(student);
			}
		}

		return ret;
	};

	that.pronadjiStudentaSaNajvecomProsecnomOcenom = function () {
		if (!studenti.length) {
			return;
		}

		var maxStudent = studenti[0];
		var maxProsek = maxStudent.prosecnaOcena();

		for (var i = 0; i < studenti.length; i++) {
			var student = studenti[i];
			var prosek = student.prosecnaOcena();
			
			if (prosek > maxProsek) {
				maxStudent = student;
				maxProsek = prosek;
			}
		}

		return maxStudent;
	};

	that.sortirajPoProsecnojOceni = function () {
		for (var i = 0; i < studenti.length - 1; i++) {
			for (var j = 0; j < studenti.length - i - 1; j++) {
				var sj = studenti[j];
				var si = studenti[i];
	
				if (si.prosecnaOcena() > sj.prosecnaOcena()) {
					studenti[j] = si;
					studenti[i] = sj;
				}
			}
		}

		return studenti;
	};

	that.pronadjiStudenteZaUpis = function () {
		var ret = [];
		for (var i = 0; i < studenti.length; i++) {
			var student = studenti[i];
			if (student.ukupnoBodova() > 60) {
				ret.push(student);
			}
		}

		return ret;
	};

	return that;
};

var sluzba = new StudentskaSluzba();
var s1 = new Student({ime: 'Mika', prezime: 'Mikic'});
var s2 = new Student({ime: 'Zika', prezime: 'Zikic'});
var s3 = new Student({ime: 'Pera', prezime: 'Peric'});
var s4 = new Student({ime: 'Steva', prezime: 'Stevic'});
var p1 = new Predmet({sifra: 'p100', naziv: 'Matematika', espb: 8});
var p2 = new Predmet({sifra: 'p101', naziv: 'Web', espb: 7});
var p3 = new Predmet({sifra: 'p102', naziv: 'Osnove programiranja', espb: 9});
var p4 = new Predmet({sifra: 'p103', naziv: 'Algoritmi', espb: 9});

sluzba.dodajStudenta(s1);
sluzba.dodajStudenta(s2);
sluzba.dodajStudenta(s3);
sluzba.dodajStudenta(s4);

sluzba.dodajPredmet(p1);
sluzba.dodajPredmet(p2);
sluzba.dodajPredmet(p3);
sluzba.dodajPredmet(p4);

var pi1 = new PolozeniIspit({ocena: 10, predmet: p1});
var pi2 = new PolozeniIspit({ocena: 6, predmet: p1});
var pi3 = new PolozeniIspit({ocena: 7, predmet: p2});
var pi4 = new PolozeniIspit({ocena: 9, predmet: p3});
var pi5 = new PolozeniIspit({ocena: 8, predmet: p4});

sluzba.dodajIspit(1, pi1);
sluzba.dodajIspit(2, pi2);
sluzba.dodajIspit(2, pi3);
sluzba.dodajIspit(3, pi4);
sluzba.dodajIspit(4, pi5);

var infoText;
var student;
var studenti;
var predmet;
var uspesnost;
var i;

console.log('Pronalazenje studenta:');
student = sluzba.pronadjiStudenta(2);
infoText = student ? 'Pronadjeni student: ' + student : 'Nema studenta sa unetim brojem indeksa';
console.log(infoText);

console.log('\nPronalazenje predmeta:');
predmet = sluzba.pronadjiPredmet('p101');
infoText = predmet ? 'Pronadjeni predmet: ' + predmet : 'Nema predmeta sa unetom sifrom';
console.log(infoText);

console.log('\nPronalazenje ispita:');
predmet = sluzba.pronadjiIspit(2, 'p101');
infoText = predmet ? 'Pronadjeni ispit: ' + predmet.toString() : 'Nema ispita za studenta sa brojem indeksa sa unetom sifrom';
console.log(infoText);

console.log('\nBrisanje studenta:');
uspesnost = sluzba.obrisiStudenta(3);
infoText = uspesnost ? 'Student je uspesno uklonjen' : 'Problem pri uklanjanju studenta';
console.log(infoText);

console.log('\nBrisanje predmeta:');
uspesnost = sluzba.obrisiPredmet('p102');
infoText = uspesnost ? 'Predmet je uspesno uklonjen' : 'Problem pri uklanjanju predmeta';
console.log(infoText);

console.log('\nBrisanje ispita:');
uspesnost = sluzba.obrisiIspit(2, 'p101');
infoText = uspesnost ? 'Ispit je uspesno uklonjen' : 'Problem pri uklanjanju ispita';
console.log(infoText);

console.log('\nIzmena podataka o studentu:');
var studentIzmena = {
	indeks: 4,
	ime: 'Imenko',
	prezime: 'Prezimenkovic'
}
sluzba.izmeniStudenta(studentIzmena);
student = sluzba.pronadjiStudenta(studentIzmena.indeks);
uspesnost = student.ime === studentIzmena.ime && student.prezime === studentIzmena.prezime;
infoText = uspesnost ? 'Podaci o studentu su uspesno izmenjeni' : 'Problem pri izmeni podataka';
console.log(infoText);

console.log('\nIzmena podataka o predmetu:');
var predmetIzmena = {
	sifra: 'p101',
    naziv: 'Lak predmet',
    espb: 9
}
sluzba.izmeniPredmet(predmetIzmena);
predmet = sluzba.pronadjiPredmet(predmetIzmena.sifra);
uspesnost = predmet.naziv === predmetIzmena.naziv && predmet.espb === predmetIzmena.espb;
infoText = uspesnost ? 'Podaci o predmetu su uspesno izmenjeni' : 'Problem pri izmeni podataka';
console.log(infoText);

console.log('\nIzmena podataka o ispitu:');
var ispitIzmena = {
	ocena: 10,
	predmet: p4
}
sluzba.izmeniIspit(4, ispitIzmena);
ispit = sluzba.pronadjiIspit(4, ispitIzmena.predmet.sifra);
uspesnost = ispit.ocena === ispitIzmena.ocena;
infoText = uspesnost ? 'Podaci o ispitu su uspesno izmenjeni' : 'Problem pri izmeni podataka';
console.log(infoText);

console.log('\nStudenti sa ocenom iznad prosecne:');
studenti = sluzba.pronadjiStudenteSaOcenomVecomOd(8.5);
if (studenti.length > 0) {
    console.log('Studenti sa ocenom vecom od prosecne:');
    for (i in studenti) {
        console.log(studenti[i]);
    }
} else {
    console.log('Nema studenata koji imaju vecu prosecnu ocenu od unete')
}

console.log('\nStudent sa najvisom prosecnom ocenom');
student = sluzba.pronadjiStudentaSaNajvecomProsecnomOcenom();
console.log('Student : ' + student);

console.log('\nStudenti sa uslovom za sledecu godinu');
studenti = sluzba.pronadjiStudenteZaUpis();
if (studenti.length > 0) {
    for (i in studenti) {
        console.log(studenti[i].toString());
    }
} else {
    console.log('Nijedan student nema uslov za sledecu godinu');
}

console.log('\nSortiranje po prosecnoj oceni');
studenti = sluzba.sortirajPoProsecnojOceni();
for (i in studenti) {
    console.log(studenti[i].toString());
}
