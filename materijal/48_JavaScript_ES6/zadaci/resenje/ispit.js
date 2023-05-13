class PolozeniIspit {
    constructor(predmet, ocena) {
        this.predmet = predmet;
        this.ocena = ocena;
    }
}


//3. zadatak
class Ispit {
    constructor(predmet) {
        this.predmet = predmet;
    }
}

class IspitKonacnaOcena extends Ispit {
    constructor(predmet, konacnaOcena) {
        super(predmet);
        this.konacnaOcena = konacnaOcena;
    }

    get ocena() {
        return this.konacnaOcena;
    }
}


class IspitUsmeniPismeni extends Ispit {
    constructor(predmet, bodoviUsmeni, bodoviPismeni) {
        super(predmet);
        this.bodoviUsmeni = bodoviUsmeni;
        this.bodoviPismeni = bodoviPismeni;
    }

    get ocena() {
        const ukupnoBodova = this.bodoviUsmeni + this.bodoviPismeni;
        return pretvoriUOcenu(ukupnoBodova);
    }
}

class IspitKolokvijumi extends Ispit {
    constructor(predmet, kolokvijumi = []) {
        super(predmet);
        this.kolokvijumi = kolokvijumi;
    }

    get ocena() {
        const ukupnoBodova = this.kolokvijumi.reduce((accum, val) => accum + val.bodovi, 0);
        return pretvoriUOcenu(ukupnoBodova);
    }

    dodajKolokvijum(kolokvijum) {
        this.kolokvijumi.push(kolokvijum);
    }
}

class Kolokvijum {
    static counter = 0;

    constructor(datumPolaganja, bodovi) {
        this.datumPolaganja = datumPolaganja;
        this.bodovi = bodovi;
        this.id = Kolokvijum.counter++;
    }
}

let pretvoriUOcenu = bodovi => {
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

export {
    PolozeniIspit,
    IspitKonacnaOcena,
    IspitUsmeniPismeni,
    IspitKolokvijumi,
    Kolokvijum
};