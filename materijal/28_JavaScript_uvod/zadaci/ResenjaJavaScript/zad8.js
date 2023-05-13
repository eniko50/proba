godina = 1600;
prestupna = false;

if(godina % 100 === 0){
	if(godina % 400 === 0){
		prestupna = true;
	}
}
else if(godina % 4 === 0){
	prestupna = true;
}
// ternarni operator je u JavaScriptu isti kao u Javi
console.log('Godina',godina,prestupna?'je':'nije','prestupna');
