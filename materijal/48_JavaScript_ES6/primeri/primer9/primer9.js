"use strict";

var _marked = [idMaker].map(regeneratorRuntime.mark);

function idMaker() {
  var i;
  return regeneratorRuntime.wrap(function idMaker$(_context) {
    while (1) {
      switch (_context.prev = _context.next) {
        case 0:
          i = 0;

        case 1:
          if (!true) {
            _context.next = 6;
            break;
          }

          _context.next = 4;
          return i++;

        case 4:
          _context.next = 1;
          break;

        case 6:
        case "end":
          return _context.stop();
      }
    }
  }, _marked[0], this);
}

var gen = idMaker();
var _iteratorNormalCompletion = true;
var _didIteratorError = false;
var _iteratorError = undefined;

try {
  for (var _iterator = gen[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
    var id = _step.value;

    console.log(id);
    if (id == 15) {
      break;
    }
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
