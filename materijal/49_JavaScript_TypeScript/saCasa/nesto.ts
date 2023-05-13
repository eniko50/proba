const a: number = 5;
const pera: string = 'Pera Petrovic';

function saberi(a: number, b: number) : number {
    return a + b;
}

const str = `zovem se ${pera}`;

var tekst: any = 'tekst';
tekst = 5;

function ispisi() {

}


interface Tacka {
    x: number;
    readonly y: number;
    zaPrikaz?: boolean;
    // //proizvoljan broj polja tipa string ili broj
    [naziv: string]: string | number | boolean | Function;
    prikazi(poruka: string):void;
}
let t1: Tacka = { x:100, y:200, z:400, u:'[1,2,3]',
    prikazi:function (p:string) {
         console.log(p,this.x,this.y);
    }
};
