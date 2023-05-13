import Osoba from './osoba.js';

class Student extends Osoba {
    static counter = 100;

    constructor(ime, prezime, polozeniIspiti) {
        super(ime, prezime);
        this.polozeniIspiti = polozeniIspiti || [];
        this.brojIndeksa = `e${Student.counter++}`;
    }

    toString() {
        return `Student: $ { this.id } $ { super.toString() }, $ { this.brojIndeksa }`;
    }

    dodajIspit(ispit) {
        this.polozeniIspiti.push(ispit);
    }

    obrisiIspit(sifraPredmeta) {
        const idx = this.indexOfIspit(sifraPredmeta);
        if (idx !== -1) {
            this.polozeniIspiti.splice(idx, 1);
        }
    }

    izmeniIspit(sifraPredmeta, ocena) {
        const idx = this.indexOfIspit(sifraPredmeta);
        if (idx !== -1) {
            this.polozeniIspiti[idx].ocena = ocena;
        }
    }

    indexOfIspit(sifraPredmeta) {
        return this.polozeniIspiti.findIndex(i => i.predmet.sifra === sifraPredmeta);
    }

    prosecnaOcena() {
        if (!this.polozeniIspiti.length) {
            return 0;
        }

        let sum = this.polozeniIspiti.reduce((accum, val) => accum + val.ocena, 0);
        return sum / this.polozeniIspiti.length;
    }

    ukupnoEspbPoena() {
        return this.polozeniIspiti.reduce((accum, val) => accum + val.predmet.espbPoeni, 0);
    }
}

export default Student;