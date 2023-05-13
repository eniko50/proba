n = 22
m = 33

while(m!=0){
	temp = m;
	m = n%m;
	n = temp;
}

console.log('NZD je:',n);