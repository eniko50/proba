var ispit = {
    ocena: function () {
        return 0;
    }
};

var Kolokvijum = function (spec) {
    var that = {
        id: spec.id,
        datum: spec.datum,
        bodovi: spec.bodovi
    };

    return that;
}

function bodoviUOcenu(bodovi) {
    if (bodovi < 55) {
        return 5;
    } else if (bodovi < 65) {
        return 6;
    } else if (bodovi < 75) {
        return 7;
    } else if (bodovi < 85) {
        return 8;
    } else if (bodovi < 95) {
        return 9;
    } else {
        return 10;
    }
}

var konacanIspit = Object.create(ispit);
konacanIspit.ocena = function () {
    return this.konacnaOcena;
};

var drugiTipIspit = Object.create(ispit);
drugiTipIspit.ocena = function () {
    return bodoviUOcenu(this.usmeni + this.pismeni);
};

var kolokvijumskiIspit = Object.create(ispit);
kolokvijumskiIspit.ocena = function () {
    var sum = 0;
    for (var i = 0; i < this.kolokvijumi.length; i++) {
        var kolokvijum = this.kolokvijumi[i];
        sum += kolokvijum.bodovi;
    }

    return bodoviUOcenu(sum);
};

var Student = function (spec) {
    var that = {
		ime: spec.ime,
        prezime: spec.prezime,
        indeks: spec.indeks,
        ispiti: spec.ispiti || []
    };
    
    that.prosecnaOcena = function() {
		if (!this.ispiti.length) {
			return 0;
		}

		sum = 0;

		for (var i = 0; i < this.ispiti.length; i++) {
            var ispit = this.ispiti[i];
			sum += ispit.ocena();
		}
	
		sum /= this.ispiti.length;
		return sum;
    };
    
    return that;
};

var s1 = Student({ime: "Studentko", prezime: "Studentkovic", indeks: 1});

var i1 = Object.create(konacanIspit);
i1.konacnaOcena = 10;

s1.ispiti.push(i1);

var i2 = Object.create(drugiTipIspit);
i2.usmeni = 30;
i2.pismeni = 60;

s1.ispiti.push(i2);

var i3 = Object.create(kolokvijumskiIspit);
var k1 = Kolokvijum({id: 1, datum: "sad", bodovi: 20});
var k2 = Kolokvijum({id: 1, datum: "onda", bodovi: 20});
var k3 = Kolokvijum({id: 1, datum: "onomad", bodovi: 20});
i3.kolokvijumi = [k1, k2, k3];

s1.ispiti.push(i3);

console.log(s1.prosecnaOcena());