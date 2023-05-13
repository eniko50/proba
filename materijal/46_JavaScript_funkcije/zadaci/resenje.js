function findIndex(array, comparator, fromIndex) {
    var i = fromIndex || 0;
    for (; i < array.length; i++) {
        if (comparator(array[i])) {
            return i;
        }
    }
    return -1;
}

function fromPairs(pairs) {
    var retVal = {};
    var prop, value;
    for (var i = 0; i < pairs.length; i++) {
        if (pairs[i].length !== 2) {
            throw 'Invalid array range';
        }
        prop = pairs[i][0];
        value = pairs[i][1];
        retVal[prop] = value;
    }
    return retVal;
}

function elementOf(array, element, comparator) {
    for (var i = 0; i < array.length; i++) {
        if(comparator(array[i],element)){
            return true;
        }
    }
    return false;
}

function unionWith(arrays, comparator) {
    var allValues = [];
    var retVal = [];
    for (var i = 0; i < arrays.length; i++) {
        allValues=allValues.concat(arrays[i]);
    }
    for (var i = allValues.length - 1; i >= 0; i--) {
        if(!elementOf(retVal,allValues[i],comparator)){
            retVal.push(allValues[i]);
        }
    }
    return retVal;
}

function elementOfAll(arrays, element, comparator){
    for (var i = 0; i < arrays.length; i++) {
        if(!elementOf(arrays[i], element, comparator)){
            return false;
        }
    }
    return true;
}

function intersection(arrays, comparator) {
    var union = unionWith(arrays, comparator);
    var retVal = [];
    for (var i = 0; i < union.length; i++) {
        if(elementOfAll(arrays, union[i], comparator)){
            retVal.push(union[i]);
        }
    }
    return retVal;
}

function pullAllWith(array, values, comparator) {
    for (var i = 0; i < values.length; i++) {
        for (var j = array.length - 1; j >= 0; j--) {
            if (comparator(array[j], values[i])) {
                array.splice(j, 1);
            }
        }
    }
    return array;
}

function zip(arrays) {
    var retVal = [];
    var maxIdx = getIdxOfMaxLength(arrays);
    for (var i = 0; i < arrays[maxIdx].length; i++) {
        var subArray = [];
        for (var j = 0; j < arrays.length; j++) {
            subArray.push(arrays[j][i]);
        }
        retVal.push(subArray);
    }
    return retVal;
}

function zipWith(arrays, iteratee) {
    var retVal = [];
    var maxIdx = getIdxOfMaxLength(arrays);
    for (var i = 0; i < arrays[maxIdx].length; i++) {
        var params = [];
        for (var j = 0; j < arrays.length; j++) {
            params.push(arrays[j][i]);
        }
        //iteratee.apply primeni funkciju iteratee na niz parametara prosledjen
        //kao poslednji parametar
        retVal.push(iteratee.apply(null, params));
    }
    return retVal;
}

function forEach(collection, iteratee) {
    for (var i in collection) {
        iteratee(collection[i], i);
    }
    return collection;
}

function filter(collection, comparator) {
    var retVal = [];
    for (var i = 0; i < collection.length; i++) {
        if (comparator(collection[i])) {
            retVal.push(collection[i]);
        }
    }
    return retVal;
}

function map(collection, iteratee) {
    var retVal = [];
    for (var i in collection) {
        retVal.push(iteratee(collection[i], i));
    }
    return retVal;
}

function reduce(array, iteratee) {
    var accum = array[0];
    for (var i = 1; i < array.length; i++) {
        accum = iteratee(accum, array[i], i);
    }
    return accum;
}

function getIdxOfMaxLength(arrays) {
    var maxIdx = 0;
    for (var i = 1; i < arrays.length; i++) {
        if (arrays[i].length > arrays[maxIdx].length) {
            maxIdx = i;
        }
    }
    return maxIdx;
}

var users = [
    { 'user': 'barney', 'active': false },
    { 'user': 'fred', 'active': false },
    { 'user': 'pebbles', 'active': true }
];

var users1 = [
    { 'user': 'wilma', 'active': false },
    { 'user': 'fred', 'active': false },
    { 'user': 'joe', 'active': true }
];

var users2 = [
    { 'user': 'barney', 'active': false },
    { 'user': 'fred', 'active': false },
    { 'user': 'joe', 'active': true }
];

console.log(findIndex(users, function(o) { return o.user == 'barney'; }));

console.log(fromPairs([
    ['a', 1],
    ['b', 2]
]));

console.log(unionWith([users,users1,users2],function(o1,o2){
    return o1.user===o2.user && o1.active===o2.active;
}));

console.log(intersection([users,users1,users2],function(o1,o2){
    return o1.user===o2.user && o1.active===o2.active;
}));

var zipVal = zip([['a','b'],[1,2],[true,false]]);
console.log(zipVal);

var zipWithVal = zipWith([[1, 2], [3, 4]], function(a, b) { return a + b });
console.log(zipWithVal);

forEach([1, 2], function(value) {
     console.log(value);
});

forEach({ 'a': 1, 'b': 2 }, function(value, key) {
     console.log(key);
});

users = [
    { 'user': 'barney', 'age': 36, 'active': true },
    { 'user': 'fred', 'age': 40, 'active': false }
];

console.log(filter(users, function(o) { return !o.active; }));

function square(n) {
    return n * n;
}

console.log(map([4, 8], square));

console.log(reduce([1, 2], function(sum, n) {
    return sum + n;
}));