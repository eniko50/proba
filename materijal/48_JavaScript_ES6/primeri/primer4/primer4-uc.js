var [a,b,c] = [1,2,3,4,5];
console.log(a, b, c);

var {x:x1,z:z1} = {x:1,y:2,z:3};
console.log(x1, z1);

var [,,c,,e] = [1,2,3,4,5];
console.log(c,e);

var [a,b,...c] = [1,2,3,4,5];
console.log(c);

var [a=11,b=22,c=33] = [1,2];
console.log(a, b, c);

var {x:x1=11,z:z1=22,w:w1=44} = {x:1,y:2,z:3};
console.log(x1, z1, w1);
