var Tacka = (function () {
    function Tacka(x, y) {
        this.x = x;
        this.y = y;
    }
    Tacka.prototype.prikazi = function () {
        console.log('(', this.x, ',', this.y, ')');
    };
    return Tacka;
}());
var t1 = new Tacka(1, 2);
t1.prikazi();
