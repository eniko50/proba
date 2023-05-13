function* idMaker() {
    var i = 0;
    while(true)
        yield i++;
}

var gen = idMaker();
for(let id of gen){
  console.log(id);
  if(id==15){
    break;
  }
}