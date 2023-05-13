m = 80;
h = 1.8;

bmi = m / (h*2);

if(bmi<18.5){
	console.log('pothranjenost');
}
else if(bmi<25){
	console.log('idealna telesna tezina');
}
else if(bmi<30){
	console.log('preterana telesna tezina');
}
else{
	console.log('gojaznost');
}