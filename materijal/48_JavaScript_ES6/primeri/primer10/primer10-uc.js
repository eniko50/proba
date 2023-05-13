// import {default as foo, bar, baz} from './dummyModule';
import foo, {bar, baz} from './dummyModule';
console.log('foo:',foo);
console.log('bar:',bar);
console.log('baz:',baz());

import * as dummy from './dummyModule';
console.log('default:',dummy.default);
console.log('baz:',baz());
console.log(dummy)