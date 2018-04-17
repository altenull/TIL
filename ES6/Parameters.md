# Parameters

**Default Parameters**

파라미터에 디폴트값을 할당 할 수 있음.

``` javascript
function addTwoNumbers(x = 0, y = 0) {
  return x + y;
}
```

**Rest Parameters**

spread 연산자(...) 사용

``` javascript
function logArguments(...args) {
  for (let arg of args) {
    console.log(arg);
  }
}
```

**Spread Operator**

```javascript
Math.max(...[-1, 100, 9001, -32]); // 9001
```

```javascript
let cities = ['서울', '베를린'];
let places = ['마드리드', ...cities, '런던']; // ['마드리드', '서울', '베를린', '런던'];
```