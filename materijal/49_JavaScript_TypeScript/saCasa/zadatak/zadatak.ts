interface Artikal {
    id: number;
    cena: number;
}

class Knjiga implements Artikal {
    constructor(
        public id: number,
        public cena: number,
        public isbn: string,
        public naslov: string,
        public autori: Autor[],
        public godinaIzdanja: number,
        public izdavac: Izdavac,
        public zanr: Zanr
    ) {
    }
}

class Album implements Artikal {
    constructor(
        public id: number,
        public cena: number,
        public naslov: string,
        public izvodjaci: Izvodjac[],
        public godinaIzdanja: number,
        public izdavac: Izdavac,
        public pravac: Pravac
    ) {
    }
}

class SkolskiPribor implements Artikal {
    constructor(
        public id: number,
        public cena: number,
        public naziv: string
    ) {
    }
}

interface Izvodjac {
    id: number;
}

class Autor implements Izvodjac {
    constructor(
        public id: number,
        public ime: string,
        public prezime: string 
    ) {
    }
}

class Bend implements Izvodjac {
    constructor(
        public id: number,
        public naziv: string
    ) {
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
}

class Pravac {
    constructor(
        public id: number,
        public naziv: string
    ) {
    }
}

class Aplikacija {
    public artikli: Artikal[] = [];
    
    public izvodjaci: Izvodjac[] = [];
    public izdavaci: Izdavac[] = [];
    public autori: Autor[] = [];
    public zanrovi: Zanr[] = [];
    public pravci: Pravac[] = [];

    public dodajArtikal(artikal: Artikal) {
        this.artikli.push(artikal);
    }

    public obrisiArtikal(id: number) {
        // const i = this.nadjiArtikal(id);
        // this.artikli.splice(i, 1);

        this.artikli = this.artikli.filter(artikal => artikal.id !== id);
        // this.artikli = this.artikli.filter(function (artikal) {
        //     return artikal.id !== id;
        // });
    }

}