var Ispit = function (spec) {
    if (spec) {
        this.predmet = spec.predmet;
    }
};

var Kolokvijum = function (spec) {
    if (spec) {
        this.id = spec.id;
        this.datum = spec.datum;
        this.bodovi = spec.bodovi;
    }
};

Ispit.prototype.ocena = function () {
    return 0;
};

function bodoviUOcenu(bodovi) {
    if (bodovi < 55) {
        return 5;
    } else if (bodovi < 65) {
        return 6;
    } else if (bodovi < 75) {
        return 7;
    } else if (bodovi < 85) {
        return 8;
    } else if (bodovi < 95) {
        return 9;
    } else {
        return 10;
    }
}

var KonacanIspit = function (spec) {
    this.constructor.apply(this, [spec]);
    this.konacnaOcena = spec.konacnaOcena;
};

KonacanIspit.prototype = new Ispit();

KonacanIspit.prototype.ocena = function () {
    return this.konacnaOcena;
};

var DrugiTipIspit = function (spec) {
    this.constructor.apply(this, [spec]);
    this.usmeni = spec.usmeni;
    this.pismeni = spec.pismeni;
};

DrugiTipIspit.prototype = new Ispit();

DrugiTipIspit.prototype.ocena = function () {
    return bodoviUOcenu(this.usmeni + this.pismeni);
};

var KolokvijumskiIspit = function (spec) {
    this.constructor.apply(this, [spec]);
    this.kolokvijumi = spec.kolokvijumi || [];
};

KolokvijumskiIspit.prototype = new Ispit();

KolokvijumskiIspit.prototype.ocena = function () {
    var sum = 0;
    for (var i = 0; i < this.kolokvijumi.length; i++) {
        var kolokvijum = this.kolokvijumi[i];
        sum += kolokvijum.bodovi;
    }

    return bodoviUOcenu(sum);
};

var Student = function (spec) {
    this.ispiti = [];
    if (spec) {
        this.ime = spec.ime;
        this.prezime = spec.prezime;
        this.indeks = spec.indeks;
        this.ispiti = spec.ispiti || [];
    }
};

Student.prototype.prosecnaOcena = function () {
    if (!this.ispiti.length) {
        return 0;
    }

    sum = 0;

    for (var i = 0; i < this.ispiti.length; i++) {
        var ispit = this.ispiti[i];
        sum += ispit.ocena();
    }

    sum /= this.ispiti.length;
    return sum;
};

var s1 = new Student({ime: "Studentko", prezime: "Studentkovic", indeks: 1});

s1.ispiti.push(new KonacanIspit({konacnaOcena: 10, predmet: "Web"}));
s1.ispiti.push(new DrugiTipIspit({usmeni: 30, pismeni: 60, predmet: "Analiza"}));

var k1 = new Kolokvijum({id: 1, datum: "sad", bodovi: 20});
var k2 = new Kolokvijum({id: 1, datum: "onda", bodovi: 20});
var k3 = new Kolokvijum({id: 1, datum: "onomad", bodovi: 20});

s1.ispiti.push(new KolokvijumskiIspit({predmet: "OS", kolokvijumi: [k1, k2, k3]}));

console.log(s1.prosecnaOcena());
