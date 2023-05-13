function dodajPozdrav(target: any) {
  target.prototype.pozdrav = function () {
    console.log('Zdravo');
  }
}

@dodajPozdrav
class Osoba{

  public ime: string;
  public prezime: string;

  constructor(ime : string, prezime : string) { 
    this.ime = ime;
    this.prezime = prezime;
  }

}

let pera = new Osoba('Pera','Peric');
pera.pozdrav();