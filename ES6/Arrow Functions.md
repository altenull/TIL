# Arrow Functions

- Arrows(화살표) 함수는 => 문법을 사용하는 축약형 함수
- 익명함수를 간단하게 표현
- 표현식의 결과 값을 반환하는 표현식 본문(expression bodies) 지원
- 상태 블록 본문(statement block bodies) 지원

### 작성 방법

``` javascript
const 함수명 = (파라미터) => {내용};
```

### 기존 function과 비교

``` javascript
// 기존 function
var add = function(a, b) {
  return a + b;
};

// arrow function
const add = (a, b) => a + b;

const addWithBlock = (a, b) => {
  return a + b;
};
```

### 배열에서의 arrow function

``` javascript
// {} 감싸지 않았을 때
const arrayTimesTwo = [1, 2, 3].map((item ,index) => item * 2);

console.log(arrayTimesTwo); // [2, 4, 6]

// {} 감쌌을 때
const arrayTimesTwoWithBlock = [1, 2, 3].map((item, index) => {
  return item * 2;
});

console.log(arrayTimesTwoWithBlock) // [2, 4, 6]

// 객체 배열로 만들기
const pairs = [1, 2, 3].map(item => ({origin: item, result: item * 2}));

console.log(pairs); // [{origin: 1, result: 2},
                    //  {origin: 2, result: 4},
                    //  {origin: 3, result: 6}]
```

### Default parameter

매개변수에 기본 값을 주어 인자를 전달하지 않는 경우를 대비할 수 있음

``` javascript
const printDishes = (mainDish = 'Rice', drink = 'Coke') => {
  console.log(`${mainDish} and ${drink}`);
}

printDishes('Pasta', 'Beer');    // 'Pasta and Beer'
printDishes(undefined, 'Juice'); // 'Rice and Juice'
printDishes(null, 'Juice');      // 'null and Juice'
printDishes('Pizza')             // 'Pizza and Coke'
printDishes();                   // 'Rice and Coke'
```