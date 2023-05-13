var Student = function(ime, prezime, godStudija, brIndeksa, polozeniIspiti) {
    this.ime = ime;
    this.prezime = prezime;
    this.godStudija = godStudija;
    this.brIndeksa = brIndeksa;
    this.polozeniIspiti = polozeniIspiti || [];
};

Student.prototype.toString = function() {
    return this.ime + ', ' + this.prezime + ', ' + this.brIndeksa;
}

Student.prototype.indexOfIspit = function(sifraPredmeta) {
    for (var i = 0; i < this.polozeniIspiti.length; i++) {
        if (this.polozeniIspiti[i].predmet.sifra === sifraPredmeta) {
            return i;
        }
    }
    return -1;
}

Student.prototype.dodajPolozeniIspit = function(ispit) {
    this.polozeniIspiti.push(ispit);
}

Student.prototype.obrisiIspit = function(sifraPredmeta) {
    var idx = this.indexOfIspit(sifraPredmeta);
    var uspesnoObrisan = false;
    if (idx !== -1) {
        this.polozeniIspiti.slice(idx, 1);
        uspesnoObrisan = true;
    }
    return uspesnoObrisan;
}

Student.prototype.izmeniIspit = function(sifraPredmeta, ocena) {
    var idx = this.indexOfIspit(sifraPredmeta);
    var uspesnoIzmenjen = false;

    if (idx !== -1) {
        this.polozeniIspiti[idx].ocena = ocena;
        uspesnoIzmenjen = true;
    }
    return uspesnoIzmenjen;
}

Student.prototype.prosecnaOcena = function() {
    if (!this.polozeniIspiti.length)
        return 0;

    var sum = 0;
    var polozeniIspiti = this.polozeniIspiti;
    for (var i in polozeniIspiti) {
        sum += polozeniIspiti[i].ocena;
    }
    return sum / polozeniIspiti.length;
}

Student.prototype.ukupnoBodova = function() {
    if (!this.polozeniIspiti.length)
        return 0;

    var sum = 0;
    for (var i in this.polozeniIspiti) {
        sum += this.polozeniIspiti[i].predmet.espbPoeni;
    }
    return sum;
}

var PolozeniIspit = function(ocena, predmet, tipIspita) {
    this.ocena = ocena;
    this.predmet = predmet;
};

PolozeniIspit.prototype.toString = function() {
    return this.predmet.naziv + ', ' + this.ocena;
}

var Predmet = function(sifra, naziv, espbPoeni) {
    this.sifra = sifra;
    this.naziv = naziv;
    this.espbPoeni = espbPoeni;
};

Predmet.prototype.toString = function() {
    return this.naziv + ', ' + this.sifra + ', ' + this.espbPoeni;
}

var StudentskaSluzba = function() {
    this.predmeti = [];
    this.studenti = [];
};

StudentskaSluzba.prototype.dodajPredmet = function(predmet) {
    this.predmeti.push(predmet);
};

StudentskaSluzba.prototype.dodajStudenta = function(student) {
    this.studenti.push(student);
};

StudentskaSluzba.prototype.dodajPolozeniIspit = function(brojIndeksa, ispit) {
    var idx = this.indexOfStudent(brojIndeksa);
    if (idx !== -1) {
        this.studenti[idx].dodajPolozeniIspit(ispit);
    }
};

StudentskaSluzba.prototype.pronadjiStudenta = function(brIndeksa) {
    var idx = this.indexOfStudent(brIndeksa);
    if (idx !== -1) {
        return this.studenti[idx];
    }
};

StudentskaSluzba.prototype.pronadjiPredmet = function(sifraPredmeta) {
    var idx = this.indexOfPredmet(sifraPredmeta);
    if (idx !== -1) {
        return this.predmeti[idx];
    }
};

StudentskaSluzba.prototype.pronadjiIspit = function(brIndeksa, sifraPredmeta) {
    var idx = this.indexOfStudent(brIndeksa);
    if (idx !== -1) {
        var student = this.studenti[idx];
        var ispitIdx = student.indexOfIspit(sifraPredmeta);
        if (ispitIdx !== -1)
            return student.polozeniIspiti[ispitIdx];
    }
};

StudentskaSluzba.prototype.obrisiStudenta = function(brIndeksa) {
    var idx = this.indexOfStudent(brIndeksa);
    var uspesnoObrisan = false;

    if (idx !== -1) {
        this.studenti.splice(idx, 1);
        uspesnoObrisan = true;
    }
    return uspesnoObrisan;
}

StudentskaSluzba.prototype.obrisiPredmet = function(sifraPredmeta) {
    var idx = this.indexOfPredmet(sifraPredmeta);
    var uspesnoObrisan = false;

    if (idx !== -1) {
        this.predmeti.splice(idx, 1);
        uspesnoObrisan = true;

        for (var i in this.studenti) {
            this.studenti[i].obrisiIspit(sifraPredmeta);
        }
    }
    return uspesnoObrisan;
};

StudentskaSluzba.prototype.obrisiIspit = function(brIndeksa, sifraPredmeta) {
    var studentIdx = this.indexOfStudent(brIndeksa);
    var uspesnoObrisan = false;

    if (studentIdx !== -1) {
        uspesnoObrisan = this.studenti[studentIdx].obrisiIspit(sifraPredmeta);
    }
    return uspesnoObrisan;
};

StudentskaSluzba.prototype.izmeniStudenta = function(brIndeksa, student) {
    var idx = this.indexOfStudent(brIndeksa);
    var uspesnoIzmenjen = false;

    if (idx !== -1) {
        this.studenti[idx].ime = student.ime;
        this.studenti[idx].prezime = student.prezime;
        uspesnoIzmenjen = true;
    }
    return uspesnoIzmenjen;
};

StudentskaSluzba.prototype.izmeniPredmet = function(sifraPredmeta, predmet) {
    var idx = this.indexOfPredmet(sifraPredmeta);
    var uspesnoIzmenjen = false;

    if (idx !== -1) {
        this.predmeti[idx].naziv = predmet.naziv;
        this.predmeti[idx].espbPoeni = predmet.espbPoeni;
        uspesnoIzmenjen = true;
    }
    return uspesnoIzmenjen;
};

StudentskaSluzba.prototype.izmeniIspit = function(brIndeksa, sifraPredmeta, ispit) {
    var studentIdx = this.indexOfStudent(brIndeksa);
    var uspesnoIzmenjen = false;

    if (studentIdx !== -1) {
        uspesnoIzmenjen = this.studenti[studentIdx].izmeniIspit(sifraPredmeta, ispit.ocena);
    }
    return uspesnoIzmenjen;
};

StudentskaSluzba.prototype.pronadjiStudenteSaOcenomIznadZadate = function(ocena) {
    var _studenti = [];
    var prosecnaOcena;
    for (var i in this.studenti) {
        prosecnaOcena = this.studenti[i].prosecnaOcena();
        if (prosecnaOcena > ocena) {
            _studenti.push(this.studenti[i]);
        }
    }
    return _studenti;
};

StudentskaSluzba.prototype.pronadjiStudentaSaNajvisomProsecnomOcenom = function() {
    var maxStudent = this.studenti[0];
    var maxProsek = maxStudent.prosecnaOcena();
    var tempStudent, tempProsek;

    for (var i = 1; i < this.studenti.length; i++) {

        tempStudent = this.studenti[i];
        tempProsek = tempStudent.prosecnaOcena();

        if (tempProsek > maxProsek) {
            maxStudent = tempStudent;
            maxProsek = tempProsek;
        }
    }
    return maxStudent;
};

StudentskaSluzba.prototype.sortirajPoProsecnojOceni = function() {
    var temp;
    for (var i = 0; i < this.studenti.length - 1; i++) {
        for (var j = 0; j < this.studenti.length - i - 1; j++) {

            if (this.studenti[j].prosecnaOcena() > this.studenti[j + 1].prosecnaOcena()) {
                temp = this.studenti[j];
                this.studenti[j] = this.studenti[j + 1]
                this.studenti[j + 1] = temp;
            }
        }
    }
    return this.studenti;
};

StudentskaSluzba.prototype.pronadjiZaUpisNaredneGodine = function() {
    var retVal = [];
    for (var i in this.studenti) {
        if (this.studenti[i].ukupnoBodova() > 60) {
            retVal.push(this.studenti[i]);
        }
    }
    return retVal;
};

// pomocne funkcije za pronalazenje
StudentskaSluzba.prototype.indexOfStudent = function(brIndeksa) {
    for (var i = 0; i < this.studenti.length; i++) {
        if (this.studenti[i].brIndeksa === brIndeksa) {
            return i;
        }
    }
    return -1;
}

StudentskaSluzba.prototype.indexOfPredmet = function(sifra) {
    for (var i = 0; i < this.predmeti.length; i++) {
        if (this.predmeti[i].sifra === sifra) {
            return i;
        }
    }
    return -1;
}


var sluzba = new StudentskaSluzba();

var s1 = new Student('Mika', 'Mikic', 2, 'e100');
var s2 = new Student('Zika', 'Zikic', 3, 'e101');
var s3 = new Student('Pera', 'Peric', 4, 'e102');
var s4 = new Student('Steva', 'Stevic', 1, 'e103');

var p1 = new Predmet('p100', 'Matematika', 8);
var p2 = new Predmet('p101', 'Web', 7);
var p3 = new Predmet('p102', 'Osnove programiranja', 9);
var p4 = new Predmet('p103', 'Algoritmi', 9);

sluzba.dodajStudenta(s1);
sluzba.dodajStudenta(s2);
sluzba.dodajStudenta(s3);
sluzba.dodajStudenta(s4);

sluzba.dodajPredmet(p1);
sluzba.dodajPredmet(p2);
sluzba.dodajPredmet(p3);
sluzba.dodajPredmet(p4);

var pi1 = new PolozeniIspit(10, p1);
var pi2 = new PolozeniIspit(6, p1);
var pi3 = new PolozeniIspit(7, p2);
var pi4 = new PolozeniIspit(9, p3);
var pi5 = new PolozeniIspit(8, p4);

sluzba.dodajPolozeniIspit('e100', pi1);
sluzba.dodajPolozeniIspit('e101', pi2);
sluzba.dodajPolozeniIspit('e101', pi3);
sluzba.dodajPolozeniIspit('e102', pi4);
sluzba.dodajPolozeniIspit('e103', pi5);


var infoText;
var student;
var studenti;
var predmet;
var uspesnost;
var i;

// Pronalazenje
console.log('Pronalazenje studenta:');
student = sluzba.pronadjiStudenta('e101');
infoText = student ? 'Pronadjeni student: ' + student.toString() : 'Nema studenta sa unetim brojem indeksa';
console.log(infoText);

console.log('\nPronalazenje predmeta:');
predmet = sluzba.pronadjiPredmet('p100');
infoText = predmet ? 'Pronadjeni predmet: ' + predmet.toString() : 'Nema predmeta sa unetom sifrom';
console.log(infoText);

console.log('\nPronalazenje ispita:');
predmet = sluzba.pronadjiIspit('e101', 'p101');
infoText = predmet ? 'Pronadjeni ispit: ' + predmet.toString() : 'Nema ispita za studenta sa brojem indeksa sa unetom sifrom';
console.log(infoText);

// Brisanje
console.log('\nBrisanje studenta:');
uspesnost = sluzba.obrisiStudenta('e101');
infoText = uspesnost ? 'Student je uspesno uklonjen' : 'Problem pri uklanjanju studenta';
console.log(infoText);

console.log('\nBrisanje predmeta:');
uspesnost = sluzba.obrisiPredmet('p102');
infoText = uspesnost ? 'Predmet je uspesno uklonjen' : 'Problem pri uklanjanju predmeta';
console.log(infoText);

console.log('\nBrisanje ispita:');
uspesnost = sluzba.obrisiIspit('e102', 'p102');
infoText = uspesnost ? 'Ispit je uspesno uklonjen' : 'Problem pri uklanjanju ispita';
console.log(infoText);

// Izmena
console.log('\nIzmena podataka o studentu:');
var studentIzmena = {
    ime: 'Imenko',
    prezime: 'Prezimenkovic'
}
uspesnost = sluzba.izmeniStudenta('e102', studentIzmena);
infoText = uspesnost ? 'Podaci o studentu su uspesno izmenjeni' : 'Problem pri izmeni podataka';
console.log(infoText);

console.log('\nIzmena podataka o predmetu:');
var predmetIzmena = {
    naziv: 'Lak predmet',
    espbPoeni: 9
}
uspesnost = sluzba.izmeniPredmet('p101', predmetIzmena);
infoText = uspesnost ? 'Podaci o predmetu su uspesno izmenjeni' : 'Problem pri izmeni podataka';
console.log(infoText);

console.log('\nIzmena podataka o ispitu:');
var ispitIzmena = {
    ocena: 10
}
uspesnost = sluzba.izmeniIspit('e100', 'p100', ispitIzmena);
infoText = uspesnost ? 'Podaci o ispitu su uspesno izmenjeni' : 'Problem pri izmeni podataka';
console.log(infoText);

// Pronalazenje (prema kriterijumu)
console.log('\nStudenti sa ocenom iznad prosecne:');
studenti = sluzba.pronadjiStudenteSaOcenomIznadZadate(4);
if (studenti.length) {
    console.log('Studenti sa ocenom vecom od prosecne:');
    for (i in studenti) {
        console.log(studenti[i].toString());
    }
} else {
    console.log('Nema studenata koji imaju vecu prosecnu ocenu od unete')
}

console.log('\nStudent sa najvisom prosecnom ocenom');
student = sluzba.pronadjiStudentaSaNajvisomProsecnomOcenom();
console.log('Student : ' + student);

console.log('\nStudenti sa uslovom za sledecu godinu');
studenti = sluzba.pronadjiZaUpisNaredneGodine();
if (studenti.length) {
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