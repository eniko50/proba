
// console.log(studenti[0].ispiti[0].predmet.naziv)

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

function izmenaPodatakaStudenta (brojIndeksa, ime, prezime, godinaStudija, listaStudenata){
	for(var i in listaStudenata){
		if(studenti[i].brojIndeksa === brojIndeksa){
			studenti[i].ime = ime;
			studenti[i].prezime = prezime;
			studenti[i].godinaStudija = godinaStudija;
			break;
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
		if(prosecnaOcena(listaStudenata[i])>ocena){
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

function ispitiStudenta (brojIndeksa, listaStudenata) {
	for(var i in listaStudenata){
		if(listaStudenata[i].brojIndeksa === brojIndeksa){
			return listaStudenata[i].ispiti;
		}
	}
}