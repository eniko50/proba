
// 1
var c = 5;
var f = c * 1.8 + 32;
console.log(f);

// 2
var p = 15;
var nijeProst = false;
for (var i = 2; i < p/2; i++) {
    if (p % i === 0) {
        nijeProst = true;
        break;
    }
}
console.log(nijeProst ? "Broj nije prost" : "Broj je prost");

// 10

var studenti = [
	{
		ime: "Petar",
		prezime: "Petrovic",
		godinaStudija: 3,
		brojIndeksa: "1234",
		polozeniIspiti: [
		    {
		        ocena: 7,
		        predmet: {
		            sifra: "1",
		            naziv: "Matematika",
		            espb: 8
		        }
		    },
		    {
		        ocena: 9,
		        predmet: {
		            sifra: "2",
		            naziv: "JavaScript",
		            espb: 2
		        }
		    }
		]
	},
	{
		ime: "Petar",
		prezime: "Petrovic",
		godinaStudija: 3,
		brojIndeksa: "1234",
		polozeniIspiti: [
		    {
		        ocena: 7,
		        predmet: {
		            sifra: "1",
		            naziv: "Matematika",
		            espb: 8
		        }
		    },
		    {
		        ocena: 9,
		        predmet: {
		            sifra: "2",
		            naziv: "JavaScript",
		            espb: 2
		        }
		    }
		]
	}
];

function dodajStudenta(studenti, student) {

}


var noviStudent = {
	ime: "Marko",
	prezime: "Markovic",
	brojIndeksa: "7654",
	godinaStudija: 1,
	polozeniIspiti: []
}

dodajStudenta(studenti, noviStudent);




