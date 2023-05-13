var osoba = function (spec) {
    var that = {};
    if (spec) {
        that.ime = spec.ime;
        that.prezime = spec.prezime;
    }

    return that;
}

var student = function (spec) {
    var that = osoba(spec);
    student.brojac = student.hasOwnProperty('brojac') ?
        (student.brojac + 1) : 1;
    that.indeks = student.brojac;
    that.ispiti = spec.ispiti || [];

    return that;
}

var predmet = function (spec) {
    var that = {};
    if (spec) {
        that.naziv = spec.naziv;
        that.sifra = spec.sifra;
        that.espb = spec.espb;
    }

    return that;
}

var ispit = function (spec) {
    var that = {};
    if (spec) {
        that.ocena = spec.ocena;
        that.predmet = spec.predmet;
    }

    return that;
}

var studentskaSluzba = function () {
    var that = {};
    var studenti = [];
    var predmeti = [];

    var nadjiIndexStudenta = function(brojIndeksa) {
        for (var i in studenti) {
            if (studenti[i].indeks === brojIndeksa) {
                return i;
            }
        }        

        return -1;
    }

    that.dodajStudenta = function (student) {
        if (nadjiIndexStudenta(student.indeks) !== -1) {
            return;
        }

        studenti.push(student);
    }

    return that;
}
