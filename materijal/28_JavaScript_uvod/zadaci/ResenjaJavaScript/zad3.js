n = 120;

for (var i = 1; i <= n; i++) {
	jeProst = true;
	for (var j = 2; j <= i/2; j++) {
		if (i%j===0) {
			jeProst = false;
		}
	}
	if(jeProst){
		console.log(i);
	}
}

