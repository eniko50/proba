izmerenaBrzina = 135;
granica = 50;

razlika = izmerenaBrzina - granica;

if(razlika>0){
	kazna = 5000 + razlika*500;
	if(izmerenaBrzina>120){
		kazna += 10000;
	}
	console.log('Vasa kazna je:',kazna);
}
else{
	console.log('Dogovorili smo se');
}