"use strict";

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

var Fib = _defineProperty({}, Symbol.iterator, function () {

  var n1 = 1,
      n2 = 1;

  return {
    next: function next() {
      var current = n2;
      n2 = n1;
      n1 = n1 + current;
      return { value: current, done: false };
    },
    return: function _return(v) {
      console.log("Fibonacci sequence abandoned.");
      return { value: v, done: true };
    }
  };
});

var _iteratorNormalCompletion = true;
var _didIteratorError = false;
var _iteratorError = undefined;

try {
  for (var _iterator = Fib[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
    var v = _step.value;

    console.log(v);
    if (v > 50) break;
  }
} catch (err) {
  _didIteratorError = true;
  _iteratorError = err;
} finally {
  try {
    if (!_iteratorNormalCompletion && _iterator.return) {
      _iterator.return();
    }
  } finally {
    if (_didIteratorError) {
      throw _iteratorError;
    }
  }
}
