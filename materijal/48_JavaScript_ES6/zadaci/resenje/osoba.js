class Osoba {
    constructor(ime, prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    toString() {
        return `${this.ime} ${this.prezime}`;
    }
}

export default Osoba;