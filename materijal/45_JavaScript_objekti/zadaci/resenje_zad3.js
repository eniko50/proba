var IspitKonacnaOcena = function(predmet, konacnaOcena) {
    this.predmet = predmet;
    this.konacnaOcena = konacnaOcena;

};

IspitKonacnaOcena.prototype.getKonacnaOcena = function () {
    return this.konacnaOcena;
}

var IspitUsmeniPismeni = function(predmet, bodoviUsmeni, bodoviPismeni) {
    this.predmet = predmet;
    this.bodoviUsmeni = bodoviUsmeni;
    this.bodoviPismeni = bodoviPismeni;
};

IspitUsmeniPismeni.prototype.getKonacnaOcena = function () {
    return pretvoriUOcenu(this.bodoviPismeni + this.bodoviUsmeni);
}

var IspitKolokvijumi = function(predmet, kolokvijumi) {
    this.kolokvijumi = kolokvijumi || [];
    this.predmet = predmet;
};

IspitKolokvijumi.prototype.getKonacnaOcena = function () {
    if (!this.kolokvijumi.length)
        return 0;
    var sum = 0;
    for (var k in this.kolokvijumi) {
        sum += this.kolokvijumi[k].bodovi;
    }
    return pretvoriUOcenu(sum);
}

IspitKolokvijumi.prototype.dodajKolokvijum = function(kolokvijum) {
    this.kolokvijumi.push(kolokvijum);
}

var Kolokvijum = function(id, datumPolaganja, bodovi) {
    this.id = id;
    this.datumPolaganja = datumPolaganja;
    this.bodovi = bodovi;
};

var Student = function(ime, prezime, godStudija, brIndeksa, polozeniIspiti) {
    this.ime = ime;
    this.prezime = prezime;
    this.godStudija = godStudija;
    this.brIndeksa = brIndeksa;
    this.polozeniIspiti = polozeniIspiti || [];
};

Student.prototype.prosecnaOcena = function() {
    if (!this.polozeniIspiti.length)
        return 0;

    var sum = 0;
    var polozeniIspiti = this.polozeniIspiti;
    for (var i in polozeniIspiti) {
        polozeniIspiti[i].ocena;
        sum += polozeniIspiti[i].getKonacnaOcena();
    }
    return sum / polozeniIspiti.length;
}

Student.prototype.dodajIspit = function(ispit) {
    this.polozeniIspiti.push(ispit)
}

var Predmet = function(sifra, naziv, espbPoeni) {
    this.sifra = sifra;
    this.naziv = naziv;
    this.espbPoeni = espbPoeni;
};

function pretvoriUOcenu(bodovi) {
    let ocena = 10;
    if (bodovi < 55) {
        ocena = 5;
    } else if (bodovi < 65) {
        ocena = 6;
    } else if (bodovi < 75) {
        ocena = 7;
    } else if (bodovi < 85) {
        ocena = 8;
    } else if (bodovi < 95) {
        ocena = 9;
    }
    return ocena;
}

var s1 = new Student('Mika', 'Mikic', 2, 'e100');
var p1 = new Predmet('p100', 'Matematika', 8);
var p2 = new Predmet('p101', 'Web', 7);
var p3 = new Predmet('p102', 'Osnove programiranja', 9);

var iup = new IspitUsmeniPismeni(p1, 50, 30);
var iko = new IspitKonacnaOcena(p2, 10);
var ik = new IspitKolokvijumi(p3);

var datumPolaganja1 = new Date(2017, 4, 12);
var datumPolaganja2 = new Date(2017, 5, 23);

ik.dodajKolokvijum(new Kolokvijum(datumPolaganja1, 40));
ik.dodajKolokvijum(new Kolokvijum(datumPolaganja2, 45));

s1.dodajIspit(iup);
s1.dodajIspit(iko);
s1.dodajIspit(ik);

console.log(s1.prosecnaOcena());