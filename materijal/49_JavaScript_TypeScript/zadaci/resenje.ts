interface Izvodjac {
     id: number;

    odgovara(upit: string): boolean;
    tip(): string;
    name(): string;
}

class Autor implements Izvodjac {

    constructor(
        public id: number,
        public ime: string,
        public prezime: string
    ) {
    }

    public odgovara(upit: string): boolean {
        return this.ime.indexOf(upit) >= 0 || this.prezime.indexOf(upit) >= 0;
    }

    public tip(): string {
        return "AUTOR";
    }

    public name(): string {
        return `${this.ime} ${this.prezime}`;
    }
}

class Bend implements Izvodjac {
    constructor(
        public id: number,
        public naziv: string
    ) {
    }

    public odgovara(upit: string): boolean {
        return this.naziv.indexOf(upit) >= 0;
    }
    
    public tip(): string {
        return "BEND";
    }

    public name(): string {
        return this.naziv;
    }
}

class Izdavac {
    constructor(
        public id: number,
        public naziv: string
    ) {
    }
}

class Zanr {
   constructor(
        public id: number,
        public naziv: string
    ) {
    }

    public odgovara(upit: string): boolean {
        return this.naziv.indexOf(upit) >= 0;
    }
}

class Pravac {
    constructor(
        public id: number,
        public naziv: string
    ) {
    }

    public odgovara(upit: string): boolean {
        return this.naziv.indexOf(upit) >= 0;
    }
}

interface Artikal {
    id: number;
    cena: number;
    tip(): string;
    izmeniPrema(artikal: Artikal);
    pripadaAutoru(upit: string): boolean;
    pripadaZanruIliPravcu(upit: string): boolean;
    name(): string;
}

class Knjiga implements Artikal {
    constructor(public id: number,
        public isbn: string,
        public naslov: string,
        public autori: Autor[],
        public godinaIzdanja: string,
        public cena: number,
        public izdavac: Izdavac,
        public zanr: Zanr
    ) {
    }

    public tip(): string {
        return 'KNJIGA';
    }

    public izmeniPrema(artikal: Artikal) {
        if (artikal.tip() != this.tip()) {
            return;
        }

        let knjiga = artikal as Knjiga;
        this.naslov = knjiga.naslov;
        this.autori = knjiga.autori;
        this.godinaIzdanja = knjiga.godinaIzdanja;
        this.cena = knjiga.cena;
        this.izdavac = knjiga.izdavac;
        this.zanr = knjiga.zanr;
    }
    
    public pripadaAutoru(upit: string): boolean {
        return this.autori.map(autor => autor.odgovara(upit)).reduce((a, b) => a || b);
    }

    public pripadaZanruIliPravcu(upit: string): boolean {
        return this.zanr.odgovara(upit);
    }

    public name(): string {
        return this.naslov;
    }
}

class Album implements Artikal {
    constructor(
        public id: number,
        public naslov: string,
        public izvodjaci: Izvodjac[],
        public godinaIzdanja: string,
        public cena: number,
        public izdavac: Izdavac,
        public pravac: Pravac
    ) {
    }


    public tip(): string {
        return 'ALBUM';
    }

    public izmeniPrema(artikal: Artikal) {
        if (artikal.tip() != this.tip()) {
            return;
        }

        let album = artikal as Album;
        this.naslov = album.naslov;
        this.izvodjaci = album.izvodjaci;
        this.godinaIzdanja = album.godinaIzdanja;
        this.cena = album.cena;
        this.izdavac = album.izdavac;
        this.pravac = album.pravac;
    }

    public pripadaAutoru(upit: string): boolean {
        return this.izvodjaci.map(izvodjac => izvodjac.odgovara(upit)).reduce((a, b) => a || b);
    }

    public pripadaZanruIliPravcu(upit: string): boolean {
        return this.pravac.odgovara(upit);
    }

    public name(): string {
        return this.naslov;
    }
}

class SkolskiPribor implements Artikal {
    constructor(
        public id: number,
        public naziv: string,
        public cena: number
    ) {
    }

    public tip(): string {
        return 'SKOLSKI_PRIBOR';
    }

    public izmeniPrema(artikal: Artikal) {
        if (artikal.tip() != this.tip()) {
            return;
        }

        let pribor = artikal as SkolskiPribor;
        this.naziv = pribor.naziv;
        this.cena = pribor.cena;
    }

    public pripadaAutoru(upit: string): boolean {
        return false;
    }

    public pripadaZanruIliPravcu(upit: string): boolean {
        return false;
    }

    public name(): string {
        return this.naziv;
    }
}

class Aplikacija {
    public autori: Autor[] = [];
    public bendovi: Bend[] = [];
    public izdavaci: Izdavac[] = [];
    public zanrovi: Zanr[] = [];
    public pravci: Pravac[] = [];

    public artikli: Artikal[] = [];

    public dodajArtikal(artikal: Artikal) {
        this.artikli.push(artikal);
    }

    public obrisiArtikal(artikal: Artikal) {
        let idx = this.artikli.indexOf(artikal);
        if (idx > -1) {
            this.artikli.splice(idx, 1);
        }
    }

    private nadjiPoTpiuIIdentifikatoru(tip: string, id: number): Artikal {
        for (let artikal of this.artikli) {
            if (artikal.id === id && artikal.tip() === tip) {
                return artikal;
            }
        }

        return undefined;
    }

    public izmeniArtikal(artikal: Artikal) {
        let postojeciArtikal = this.nadjiPoTpiuIIdentifikatoru(artikal.tip(), artikal.id);
        if (postojeciArtikal) {
            postojeciArtikal.izmeniPrema(artikal);
        }
    }

    public nadjiPoVrsti(vrsta: string): Artikal[] {
        return this.artikli.filter(artikal => artikal.tip() == vrsta);
    }

    public pretragaPoAutorima(upit: string): Artikal[] {
        return this.artikli.filter(artikal => artikal.pripadaAutoru(upit));
    }

    public pretragaPoZanruIliPravcu(upit: string): Artikal[] {
        return this.artikli.filter(artikal => artikal.pripadaZanruIliPravcu(upit));
    }

    public pretragaSkolskogPribora(upit: string): Artikal[] {
        let filter = function(artikal: Artikal): boolean {
            if (artikal.tip() !== 'SKOLSKI_PRIBOR') {
                return false;
            }

            let pribor = artikal as SkolskiPribor;
            return pribor.naziv.indexOf(upit) >= 0;
        }

        return this.artikli.filter(filter);
    }

    public pretragaAutoraPoZanru(upit: string): Autor[] {
        let filterKnjiga = function(artikal: Artikal): Knjiga {
            if (artikal.tip() !== 'KNJIGA') {
                return undefined;
            }

            let knjiga = artikal as Knjiga;
            return knjiga;
        }

        let autoriZanra = this.artikli.map(filterKnjiga)
            .filter(knjiga => !!knjiga)
            .filter(knjiga => knjiga.pripadaZanruIliPravcu(upit))
            .map(knjiga => knjiga.autori)
            .reduce((total, current) => total.concat(current), []);

        return this.autori.filter(autor => autoriZanra.filter(autorZanra => autorZanra.id === autor.id).length != 0);   
    }
    
    public pretragaPoPravcu(upit: string): Izvodjac[] {
        let filterAlbuma = function(artikal: Artikal): Album {
            if (artikal.tip() !== 'ALBUM') {
                return undefined;
            }

            let album = artikal as Album;
            return album;
        }

        let izvodjaciPravca = this.artikli.map(filterAlbuma)
            .filter(album => !!album)
            .filter(album => album.pripadaZanruIliPravcu(upit))
            .map(album => album.izvodjaci)
            .reduce((total, current) => total.concat(current), []);

                       // Ovako nije javljao gresku... 
        let sviIzvodjaci: Izvodjac[] = [].concat(this.autori).concat(this.bendovi);

        return sviIzvodjaci.filter(izvodjac => izvodjaciPravca.filter(izvodjacPravca => izvodjacPravca.id === izvodjac.id && izvodjacPravca.tip() === izvodjac.tip()).length != 0);
    }

    // Recimo da su slicni ako su bar jednu knjigu/pesmu zajedno napisali.
    public pronadjiSlicneIzvodjace(inicijalniIzvodjac: Izvodjac): Izvodjac[] {
        let izvodjaciIsti = function(i1: Izvodjac, i2: Izvodjac) {
            return i1.tip() === i2.tip() && i1.id === i2.id;
        }

        let izdvojiIzvodjace = function(artikal: Artikal): Izvodjac[] {
            if (artikal.tip() === 'KNJIGA') {
                return (artikal as Knjiga).autori;
            } else if (artikal.tip() === 'ALBUM') {
                return (artikal as Album).izvodjaci;
            } else {
                return [];
            }
        }

        let sadrziIzvodjaca = function(artikal: Artikal, izvodjac: Izvodjac): boolean {
            if (artikal.tip() === 'KNJIGA') {
                return (artikal as Knjiga).autori.filter(i => izvodjaciIsti(i, izvodjac)).length != 0;
            } else if (artikal.tip() === 'ALBUM') {
                return (artikal as Album).izvodjaci.filter(i => izvodjaciIsti(i, izvodjac)).length != 0;
            } else {
                return false;
            }
        }

        let slicniIzvodjaci = this.artikli.filter(artikal => sadrziIzvodjaca(artikal, inicijalniIzvodjac))
            .map(izdvojiIzvodjace)
            .reduce((total, current) => total.concat(current), []);

        let sviIzvodjaci: Izvodjac[] = [].concat(this.autori).concat(this.bendovi);

        return sviIzvodjaci.filter(izvodjac => slicniIzvodjaci.filter(i => izvodjaciIsti(izvodjac, i)).length != 0 && izvodjac.id != inicijalniIzvodjac.id);
    }

    public pronadjiSlicneArtikle(inicijalniArtikal: Artikal): Artikal[] {
        let potencijalni = this.nadjiPoVrsti(inicijalniArtikal.tip());

        if (inicijalniArtikal.tip() === 'KNJIGA') {
            let inicijalniZanr = (inicijalniArtikal as Knjiga).zanr;
            return potencijalni.map(k => k as Knjiga).filter(knjiga => knjiga.zanr.id === inicijalniZanr.id && knjiga.id !== inicijalniArtikal.id);
        } else if (inicijalniArtikal.tip() === 'ALBUM') {
            let inicijalniPravac = (inicijalniArtikal as Album).pravac;
            return potencijalni.map(a => a as Album).filter(album => album.pravac.id === inicijalniPravac.id && album.id !== inicijalniArtikal.id);
        } else {
            return [];
        }
    }

}

let aplikacija = new Aplikacija()

let autor1 = new Autor(1, "Gordon", "Ramsay");
let autor2 = new Autor(2, "Douglas", "Adams");
let autor3 = new Autor(3, "Arthur", "Clarke");
let autor4 = new Autor(4, "Kuvar", "Kuvarić");
aplikacija.autori = [autor1, autor2, autor3, autor4];

let bend1 = new Bend(4, "The Killers");
let bend2 = new Bend(5, "The Who");
let bend3 = new Bend(6, "Queen");
aplikacija.bendovi = [bend1, bend2, bend3];

let izdavac1 = new Izdavac(1, "Izdavačko");
let izdavac2 = new Izdavac(2, "Muzički izdavač");
aplikacija.izdavaci = [izdavac1, izdavac2];

let zanr1 = new Zanr(1, "Sajns fikšn");
let zanr2 = new Zanr(2, "Kuking");
let zanr3 = new Zanr(3, "Edvenčr");
aplikacija.zanrovi = [zanr1, zanr2, zanr3];

let pravac1 = new Pravac(1, "One"); // One direction xe xe xe
let pravac2 = new Pravac(2, "Kamen");
aplikacija.pravci = [pravac1, pravac2];

let knjiga1 = new Knjiga(1, "1", "The Hitchhiker's Guide to the Galaxy", [autor2], "1979", 1000, izdavac1, zanr1);
let knjiga2 = new Knjiga(2, "2", "2001: A Space Odyssey", [autor3], "1968", 1092, izdavac1, zanr1);
let knjiga3 = new Knjiga(3, "3", "Kuvanje", [autor4, autor1], "2000", 123, izdavac1, zanr2);

let album1 = new Album(4, "Wonderful wonderful", [bend1], "2017", 1234, izdavac2, pravac2);
let album2 = new Album(5, "Queen album", [bend3], "1967", 513, izdavac2, pravac2);
let album3 = new Album(6, "The what", [bend2], "2003", 1823, izdavac2, pravac1);

let skolskiPribor1 = new SkolskiPribor(7, "Sveska", 20);
let skolskiPribor2 = new SkolskiPribor(8, "Pljoska", 790);
aplikacija.artikli = [knjiga1, knjiga2, knjiga3, album1, album2, album3, skolskiPribor1, skolskiPribor2];

console.log();
console.log("Dodavanje artikla");
console.log(`Duzina niza pre dodavanja ${aplikacija.artikli.length}`);
let skolskiPribor3 = new SkolskiPribor(9, "Peraton'ca", 136);
aplikacija.dodajArtikal(skolskiPribor3);
console.log(`Duzina niza posle dodavanja ${aplikacija.artikli.length}`);

console.log();
console.log("Izmena artikla");
skolskiPribor3.cena = 12333333;
aplikacija.izmeniArtikal(skolskiPribor3);
console.log(`izmenjena cena: ${aplikacija.artikli[aplikacija.artikli.length - 1].cena}`);

console.log();
console.log("Brisanje artikla");
console.log(`Duzina niza pre brisanja ${aplikacija.artikli.length}`);
aplikacija.obrisiArtikal(skolskiPribor3);
console.log(`Duzina niza posle brisanja ${aplikacija.artikli.length}`);

console.log();
console.log("Trazenje knjiga (treba biti 3)");
console.log(`Broj knjiga: ${aplikacija.nadjiPoVrsti('KNJIGA').map(a => a.name())}`);

console.log();
console.log("Trazenje albuma (treba biti 3)");
console.log(`Broj albuma: ${aplikacija.nadjiPoVrsti('ALBUM').map(a => a.name())}`);

console.log();
console.log("Trazenje skolskog pribora (treba biti 2)");
console.log(`Broj skolskog pribora: ${aplikacija.nadjiPoVrsti('SKOLSKI_PRIBOR').map(a => a.name())}`);

console.log();
console.log("trazenje po nazivu autora ili benda");
let q1 = 'l';
let r1 = aplikacija.pretragaPoAutorima(q1);
console.log(`Pronadjeni naslovi: ${r1.map(a => a.name())}`);

console.log();
console.log("trazenje po nazivu zanra ili pravca");
let q2 = 'a';
let r2 = aplikacija.pretragaPoZanruIliPravcu(q2);
console.log(`Pronadjeni naslovi: ${r2.map(a => a.name())}`);

console.log();
console.log("trazenje po nazivu skolskog pribora");
let q3 = 've';
let r3 = aplikacija.pretragaSkolskogPribora(q3);
console.log(`Pronadjeni naslovi: ${r3.map(a => a.name())}`);

console.log();
console.log("trazenje autora po zanru");
let q4 = 'fik';
let r4 = aplikacija.pretragaAutoraPoZanru(q4);
console.log(`Pronadjeni autori: ${r4.map(autor => autor.name())}`);

console.log();
console.log("trazenje izvodjaca po pravcu");
let q5 = 'a';
let r5 = aplikacija.pretragaPoPravcu(q5);
console.log(`Pronadjeni izvodjaci: ${r5.map(autor => autor.name())}`);

console.log();
console.log("Trazenje slicnih izvodjaca/autora");
let inicijalni = autor1;
let slicni = aplikacija.pronadjiSlicneIzvodjace(inicijalni);
console.log(`Pronadjeni slicni izvodjaci/autori: ${slicni.map(i => i.name())}`);

console.log();
console.log("Trazenje slicnih artikala");
let inicijalniArtikal1 = knjiga1;
let slicni1 = aplikacija.pronadjiSlicneArtikle(inicijalniArtikal1);
console.log(`Pronadjeni slicni artikli: ${slicni1.map(a => a.name())}`);