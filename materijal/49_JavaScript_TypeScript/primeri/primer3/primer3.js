var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
function dodajPozdrav(target) {
    target.prototype.pozdrav = function () {
        console.log('Zdravo');
    };
}
var Osoba = (function () {
    function Osoba(ime, prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }
    Osoba = __decorate([
        dodajPozdrav
    ], Osoba);
    return Osoba;
}());
var pera = new Osoba('Pera', 'Peric');
pera.pozdrav();
