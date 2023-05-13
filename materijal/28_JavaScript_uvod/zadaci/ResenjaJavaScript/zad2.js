x = 60;
jeProst = true;
for (i = 2; i < x / 2; i++) {
	if(x%i===0){
		console.log('broj nije prost');
		jeProst = false;
		break;
	}
}
if(jeProst){
	console.log('broj je prost');
}