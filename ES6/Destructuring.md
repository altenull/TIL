# Destructuring

- Destructuring(비구조화)은 배열과 객체에 패턴 매칭을 통한 데이터 바인딩을 제공함.
- 할당 실패에 유연하며, 실패 시 **undefined**가 자동으로 할당됨.
- 즉, 배열이나 객체를 선언과 동시에 해제하여 값을 할당하는 것.

**배열에서**

``` javascript
// 기존
var array = [1, 2, 3, 4];
var a = arr[0]; // 1
var b = arr[1]; // 2
var c = arr[2]; // 3
var d = arr[3]; // 4

// ES6
let [a, b, , d] = [1, 2, 3, 4];
console.log(a); // 1
console.log(b); // 2
console.log(d); // 4
```

**객체에서**

``` javascript
// 기존
var object = {
  name: 'altenull',
  birth: {
    year: 1991
  }
};

var name = object.name; // 'altenull'
var birthYear = object.birth.year; // 1991

// ES6
const object = {
  name: 'altenull',
  birth: {
    year: 1991,
    month: 12
  }
};

const {
  name,
  birth: {
    year
  },
  temp
} = object;
console.log(name); // 'altenull'
console.log(year); // 1991
console.log(temp); // undefined
```

**매개변수에서**
``` javascript
const destructuringWithParameter = ({ value: x }) => {
  console.log(x);
};

const arg = { value: 5 };
destructuringWithParameter(arg); // 5
```