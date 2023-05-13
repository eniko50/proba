var Ispit = function(spec) {
    var that = {
        predmet: spec.predmet
    };

    that.ocena = function() {
        return 0;
    }

    return that;
};

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

var KonacanIspit = function(spec) {
    var that = Ispit(spec);

    that.konacnaOcena = spec.konacnaOcena;

    that.ocena = function() {
        return this.konacnaOcena;
    }

    return that;
};

var DrugiTipIspit = function (spec) {
    var that = Ispit(spec);

    that.usmeni = spec.usmeni;
    that.pismeni = spec.pismeni;

    that.ocena = function () {
        return bodoviUOcenu(this.usmeni + this.pismeni);
    }

    return that;
};

var Kolokvijum = function (spec) {
    var that = {
        id: spec.id,
        datum: spec.datum,
        bodovi: spec.bodovi
    };

    return that;
}

var KolokvijumskiIspit = function (spec) {
    var that = Ispit(spec);
    that.kolokvijumi = spec.kolokvijumi || [];

    that.ocena = function() {
        var sum = 0;
        for (var i = 0; i < this.kolokvijumi.length; i++) {
            var kolokvijum = this.kolokvijumi[i];
            sum += kolokvijum.bodovi;
        }

        return bodoviUOcenu(sum);
    }

    return that;
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

s1.ispiti.push(KonacanIspit({konacnaOcena: 10, predmet: "Web"}));
s1.ispiti.push(DrugiTipIspit({usmeni: 30, pismeni: 60, predmet: "Analiza"}));

var k1 = Kolokvijum({id: 1, datum: "sad", bodovi: 20});
var k2 = Kolokvijum({id: 1, datum: "onda", bodovi: 20});
var k3 = Kolokvijum({id: 1, datum: "onomad", bodovi: 20});

s1.ispiti.push(KolokvijumskiIspit({predmet: "OS", kolokvijumi: [k1, k2, k3]}));

console.log(s1.prosecnaOcena());