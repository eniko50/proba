let studira: boolean = true;
console.log(studira);

let godinaStudija: number = 2;
console.log(godinaStudija);

let ime: string = 'Pera Peric';
console.log('Zovem se '+ime+' i upisan sam na '+godinaStudija+'. godinu studija');

let ocene: number[] = [8,9,8];
for(let ocena of ocene){
	console.log(ocena);
}

let student: [string, string, boolean, number, number[]] = ['Pera', 'Peric', true, 2, [8,9,8]];
for(let podatak of student){
	console.log(podatak);
}

enum Smer{ Racunarstvo, Masinstvo, Saobracaj };
let smerStudija: Smer = Smer.Masinstvo;
console.log(smerStudija);

let a: any = 'tekst';
a = 55;
a = [1,2,3,'cetiri'];

function obavestenje(): void{
	alert('Vasa prijava za ispit je obradjena!');
}

obavestenje();

let u: undefined = undefined;
let n: null = null;

function greska(poruka: string): never {
    throw new Error(poruka);
}

interface Tacka {
    x: number;
    readonly y: number;
    zaPrikaz?: boolean;
    // //proizvoljan broj polja tipa string ili broj
    [naziv: string]: string | number | boolean | Function;
    prikazi(poruka: string):void;
}

let t1:Tacka = { x:100, y:200, z:400, u:'[1,2,3]', prikazi:function (p:string) {
	console.log(p,this.x,this.y);
} };

interface Filtriranje {
  (originalnaLista: string[], podstring: string): string[];
}

let f: Filtriranje = function (lista: string[], term: string) {
    return lista.filter(function (item) {
        return item.indexOf(term)!=-1;
    });
}

console.log(f(['foo', 'bar', 'baz'], 'ba'));

interface Tacka3D extends Tacka {
    z: number;
}

