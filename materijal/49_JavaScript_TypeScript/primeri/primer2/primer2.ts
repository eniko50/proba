interface Tacka2D{
	x: number;
	y: number;
	prikazi(): void;
}

class Tacka implements Tacka2D{
	public x: number;
	public y: number;
	constructor(x: number, y: number){
		this.x = x;
		this.y = y;
	}
	public prikazi(){
		console.log('(',this.x,',',this.y,')');
	}
}

let t1: Tacka2D = new Tacka(1,2);
t1.prikazi();