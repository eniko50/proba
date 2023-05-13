class StudentskaSluzba {
    constructor(studenti = [], predmeti = []) {
        this.studenti = studenti;
        this.predmeti = predmeti
    }

    dodajPredmet(predmet) {
        this.predmeti.push(predmet);
    }

    dodajStudenta(student) {
        this.studenti.push(student);
    }

    dodajIspit(brojIndeksa, ispit) {
        const idx = SluzbaUtil.indexOfStudent(this.studenti, brojIndeksa);
        if (idx !== -1) {
            this.studenti[idx].dodajIspit(ispit);
        }
    }

    pronadjiStudenta(brojIndeksa) {
        const idx = SluzbaUtil.indexOfStudent(this.studenti, brojIndeksa);
        if (idx !== -1) {
            return this.studenti[idx];
        }
    }

    pronadjiPredmet(sifraPredmeta) {
        const idx = SluzbaUtil.indexOfPredmet(this.predmeti, sifraPredmeta);
        if (idx !== -1) {
            return this.predmeti[idx];
        }
    }

    pronadjiIspit(brojIndeksa, sifraPredmeta) {
        const idx = SluzbaUtil.indexOfStudent(this.studenti, brojIndeksa);
        if (idx !== -1) {
            const ispitIdx = this.studenti[idx].indexOfIspit(sifraPredmeta);
            if (ispitIdx !== -1) {
                return this.studenti[idx].polozeniIspiti[ispitIdx];
            }
        }
    }

    obrisiStudenta(brojIndeksa) {
        const idx = SluzbaUtil.indexOfStudent(this.studenti, brojIndeksa);
        if (idx !== -1) {
            this.studenti.splice(idx, 1);
        }
    }

    obrisiPredmet(sifraPredmeta) {
        const idx = SluzbaUtil.indexOfPredmet(this.predmeti, sifraPredmeta);
        if (idx !== -1) {
            this.predmeti.splice(idx, 1);
            this.studenti.forEach(s => this.obrisiIspit(s.brojIndeksa, sifraPredmeta));
        }
    }

    obrisiIspit(brojIndeksa, sifraPredmeta) {
        const idx = SluzbaUtil.indexOfStudent(this.studenti, brojIndeksa);
        if (idx !== -1) {
            this.studenti[idx].obrisiIspit(sifraPredmeta);
        }
    }

    izmeniStudenta(brojIndeksa, { ime, prezime }) {
        const idx = SluzbaUtil.indexOfStudent(this.studenti, brojIndeksa);
        if (idx !== -1) {
            this.studenti[idx].ime = ime;
            this.studenti[idx].prezime = prezime;
        }
    }

    izmeniPredmet(sifraPredmeta, { naziv, espbPoeni }) {
        const idx = SluzbaUtil.indexOfPredmet(this.predmeti, sifraPredmeta);
        if (idx !== -1) {
            this.predmeti[idx].naziv = naziv;
            this.predmeti[idx].espbPoeni = espbPoeni;
        }
    }

    izmeniIspit(brojIndeksa, sifraPredmeta, { ocena }) {
        const idx = SluzbaUtil.indexOfStudent(this.studenti, brojIndeksa);
        if (idx !== -1) {
            this.studenti[idx].izmeniIspit(sifraPredmeta);
        }
    }

    pronadjiStudenteSaOcenomVecomOd(ocena) {
        let studenti = this.studenti.filter(s => s.prosecnaOcena() > ocena);
        return studenti;
    }

    pronadjiStudentaSaNajvecomProsecnomOcenom() {
        let prosecneOcene = this.studenti.map(s => s.prosecnaOcena());
        let maxIdx = prosecneOcene.indexOf(Math.max(...prosecneOcene));
        return this.studenti[maxIdx];
    }

    sortirajPoProsecnojOceni() {
        return this.studenti.sort(s => s.prosecnaOcena());
    }

    pronadjiStudenteZaUpisNaredneGodine() {
        return this.studenti.filter(s => s.ukupnoEspbPoena() > 60);
    }
}

class SluzbaUtil {
    constructor() {}

    static indexOfStudent(studenti, brojIndeksa) {
        return studenti.findIndex(s => s.brojIndeksa === brojIndeksa);
    }

    static indexOfPredmet(predmeti, sifraPredmeta) {
        return predmeti.findIndex(p => p.sifra === sifraPredmeta);
    }

    static indexOfIspit(polozeniIspiti, sifraPredmeta) {
        return polozeniIspiti.findIndex(i => i.predmet.sifra === sifraPredmeta);
    }
}

export default StudentskaSluzba;