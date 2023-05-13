// Destrukturiranje parametara
var foo = function({rec, broj}) {
	console.log(rec);
}

foo({rec: 'asd', broj: 123})
// Ispise 'asd'

var bar = function([a,b]) {
	console.log(a, b);
}

bar([3,5])
// Ispise 3, 5