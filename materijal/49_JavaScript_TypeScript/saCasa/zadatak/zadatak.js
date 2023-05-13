var Knjiga = /** @class */ (function () {
    function Knjiga(id, cena, isbn, naslov, autori, godinaIzdanja, izdavac, zanr) {
        this.id = id;
        this.cena = cena;
        this.isbn = isbn;
        this.naslov = naslov;
        this.autori = autori;
        this.godinaIzdanja = godinaIzdanja;
        this.izdavac = izdavac;
        this.zanr = zanr;
    }
    return Knjiga;
}());
var Album = /** @class */ (function () {
    function Album(id, cena, naslov, izvodjaci, godinaIzdanja, izdavac, pravac) {
        this.id = id;
        this.cena = cena;
        this.naslov = naslov;
        this.izvodjaci = izvodjaci;
        this.godinaIzdanja = godinaIzdanja;
        this.izdavac = izdavac;
        this.pravac = pravac;
    }
    return Album;
}());
var SkolskiPribor = /** @class */ (function () {
    function SkolskiPribor(id, cena, naziv) {
        this.id = id;
        this.cena = cena;
        this.naziv = naziv;
    }
    return SkolskiPribor;
}());
var Autor = /** @class */ (function () {
    function Autor(id, ime, prezime) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
    }
    return Autor;
}());
var Bend = /** @class */ (function () {
    function Bend(id, naziv) {
        this.id = id;
        this.naziv = naziv;
    }
    return Bend;
}());
var Izdavac = /** @class */ (function () {
    function Izdavac(id, naziv) {
        this.id = id;
        this.naziv = naziv;
    }
    return Izdavac;
}());
var Zanr = /** @class */ (function () {
    function Zanr(id, naziv) {
        this.id = id;
        this.naziv = naziv;
    }
    return Zanr;
}());
var Pravac = /** @class */ (function () {
    function Pravac(id, naziv) {
        this.id = id;
        this.naziv = naziv;
    }
    return Pravac;
}());
var Aplikacija = /** @class */ (function () {
    function Aplikacija() {
        this.artikli = [];
        this.izvodjaci = [];
        this.izdavaci = [];
        this.autori = [];
        this.zanrovi = [];
        this.pravci = [];
    }
    Aplikacija.prototype.dodajArtikal = function (artikal) {
        this.artikli.push(artikal);
    };
    Aplikacija.prototype.obrisiArtikal = function (id) {
        // const i = this.nadjiArtikal(id);
        // this.artikli.splice(i, 1);
        this.artikli = this.artikli.filter(function (artikal) { return artikal.id !== id; });
        // this.artikli = this.artikli.filter(function (artikal) {
        //     return artikal.id !== id;
        // });
    };
    return Aplikacija;
}());
