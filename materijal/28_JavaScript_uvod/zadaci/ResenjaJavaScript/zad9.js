datum = '29/02/1900';

dan = Number(datum.split('/')[0])
mesec = Number(datum.split('/')[1])
godina = Number(datum.split('/')[2])

validan = true;

if(mesec < 1 || mesec > 12 || dan < 0 || dan > 31){
	validan = false;
}
else if(mesec == 4 || mesec == 6  || mesec == 9 || mesec == 11){
	if(dan > 30){
		validan = false;
	}
}
else if(mesec == 2){

	prestupna = false;
	if(godina % 100 === 0){
		if(godina % 400 === 0){
			prestupna = true;
		}
	}
	else if(godina % 4 === 0){
		prestupna = true;
	}

	if(prestupna && dan > 29){
		validan = false;
	}
	else if(!prestupna && dan > 28){
		validan = false;
	}
}

console.log('datum',validan?'je':'nije','validan');