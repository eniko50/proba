var studira = true;
console.log(studira);
var godinaStudija = 2;
console.log(godinaStudija);
var ime = 'Pera Peric';
console.log('Zovem se ' + ime + ' i upisan sam na ' + godinaStudija + '. godinu studija');
var ocene = [8, 9, 8];
for (var _i = 0, ocene_1 = ocene; _i < ocene_1.length; _i++) {
    var ocena = ocene_1[_i];
    console.log(ocena);
}
var student = ['Pera', 'Peric', true, 2, [8, 9, 8]];
for (var _a = 0, student_1 = student; _a < student_1.length; _a++) {
    var podatak = student_1[_a];
    console.log(podatak);
}
var Smer;
(function (Smer) {
    Smer[Smer["Racunarstvo"] = 0] = "Racunarstvo";
    Smer[Smer["Masinstvo"] = 1] = "Masinstvo";
    Smer[Smer["Saobracaj"] = 2] = "Saobracaj";
})(Smer || (Smer = {}));
;
var smerStudija = Smer.Masinstvo;
console.log(smerStudija);
var a = 'tekst';
a = 55;
a = [1, 2, 3, 'cetiri'];
function obavestenje() {
    alert('Vasa prijava za ispit je obradjena!');
}
obavestenje();
var u = undefined;
var n = null;
function greska(poruka) {
    throw new Error(poruka);
}
var t1 = { x: 100, y: 200, z: 400, u: '[1,2,3]', prikazi: function (p) {
        console.log(p, this.x, this.y);
    } };
var f = function (lista, term) {
    return lista.filter(function (item) {
        return item.indexOf(term) != -1;
    });
};
console.log(f(['foo', 'bar', 'baz'], 'ba'));
