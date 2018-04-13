# Strings

### .includes()

- 어떠한 문자열에 찾고자 하는 문자열이 포함되어 있는지 확인

``` javascript
// 기존 방법
var string = 'food';
var subString = 'foo';

console.log(string.indexOf(subString) > -1);

// using includes()
var string = 'taxi';
var subString = 'tax';

string.includes(subString); // true
'taxi'.includes('tax'); // true
```

### .repeat()

- 문자열을 반복함

``` javascript
// 기존 방법
function repeat() {
  var strings = [];
  var string = 'Hello'
  var count = 3;
  while(strings.length < count) {
      strings.push(string);
  }
  return strings.join('');
}
// while문 한 번 돌면? ['Hello']
// while문 두 번 돌면? ['Hello', 'Hello']
// while문 세 번 돌면? ['Hello', 'Hello', 'Hello']
// 결과는? 'HelloHelloHello'

// using repeat()
'Hello'.repeat(3); // 결과는? 'HelloHelloHello'
```

### Template Literals

- 문법적으로 더 편하게 string을 생성할 수 있게 함.
- `(Grave accent)를 사용. 흔히, 백틱(backtick)이라고 부름

**String에 특수 문자 사용시**
``` javascript
// 기존
var text = "He is \"altenull\".";

// ES6
let text = `He is "altenull"`;
```

**interpolation에서**
``` javascript
// 기존
var name = 'Meow';
var age = '5';

console.log('My cat is named' + name + 'and is ' + age + 'years old.');

// ES6
const name = 'Katie';
const age = '11';

console.log(`My cat is named ${name} and is ${age} years old.`);
```

**new line을 다룰 때**
``` javascript
// 기존
var text = (
  'cat\n' +
  'dog\n' +
  'nickelodeon'
);

var text = [
  'cat',
  'dog',
  'nickelodeon'
].join('\n');

// ES6
let text = ( `cat
dog
nickelodeon`
);
```