import Student from './student.js';
import Predmet from './predmet.js';
import {
    PolozeniIspit,
    IspitKonacnaOcena,
    IspitUsmeniPismeni,
    IspitKolokvijumi,
    Kolokvijum
} from './ispit.js';
import StudentskaSluzba from './studentskaSluzba.js';


let sluzba = new StudentskaSluzba();

let s1 = new Student('Zika', 'Zikic');
let s2 = new Student('Mika', 'Mikic');
let s3 = new Student('Pera', 'Peric');

let p1 = new Predmet('p100', 'Web programiranje', 9);
let p2 = new Predmet('p101', 'Matematika', 8);
let p3 = new Predmet('p102', 'Algoritmi', 7);

let i1 = new PolozeniIspit(p1, 8);
let i2 = new PolozeniIspit(p1, 9);
let i3 = new PolozeniIspit(p1, 10);
let i4 = new PolozeniIspit(p2, 7);
let i5 = new PolozeniIspit(p2, 9);
let i6 = new PolozeniIspit(p2, 10);
let i7 = new PolozeniIspit(p3, 6);
let i8 = new PolozeniIspit(p3, 8);
let i9 = new PolozeniIspit(p3, 9);

sluzba.dodajStudenta(s1);
sluzba.dodajStudenta(s2);
sluzba.dodajStudenta(s3);

sluzba.dodajPredmet(p1);
sluzba.dodajPredmet(p2);
sluzba.dodajPredmet(p3);

sluzba.dodajIspit(s1.brojIndeksa, i1);
sluzba.dodajIspit(s1.brojIndeksa, i4);
sluzba.dodajIspit(s1.brojIndeksa, i7);
sluzba.dodajIspit(s2.brojIndeksa, i2);
sluzba.dodajIspit(s2.brojIndeksa, i5);
sluzba.dodajIspit(s2.brojIndeksa, i8);
sluzba.dodajIspit(s3.brojIndeksa, i3);
sluzba.dodajIspit(s3.brojIndeksa, i6);
sluzba.dodajIspit(s3.brojIndeksa, i9);

console.log(sluzba.pronadjiStudenta('e100'));
console.log(sluzba.pronadjiPredmet('p100'));
console.log(sluzba.pronadjiIspit('e100', 'p100'));

sluzba.obrisiStudenta('e100');
sluzba.obrisiPredmet('p100');
sluzba.obrisiIspit('e101', 'p101');

sluzba.izmeniStudenta('e101', { ime: 'Zikoslav', prezime: 'Zikic' });
sluzba.izmeniPredmet('p101', { naziv: 'Algebra', espbPoeni: 7 });
sluzba.izmeniIspit('e101', 'p101', { ocena: 10 });

console.log('Sa ocenom iznad:', sluzba.pronadjiStudenteSaOcenomVecomOd(8));
console.log(sluzba.pronadjiStudentaSaNajvecomProsecnomOcenom(8));
console.log(sluzba.pronadjiStudenteZaUpisNaredneGodine());
console.log(sluzba.sortirajPoProsecnojOceni());

//3. zadatak
let s4 = new Student('Steva', 'Stevic');
let iup = new IspitUsmeniPismeni(p1, 50, 30);
let iko = new IspitKonacnaOcena(p2, 9);
let ik = new IspitKolokvijumi(p3);

const datumPolaganja1 = new Date(2017, 4, 12);
const datumPolaganja2 = new Date(2017, 5, 23);

ik.dodajKolokvijum(new Kolokvijum(datumPolaganja1, 40));
ik.dodajKolokvijum(new Kolokvijum(datumPolaganja2, 45));

s4.dodajIspit(iup);
s4.dodajIspit(iko);
s4.dodajIspit(ik);

console.log(s4.prosecnaOcena());