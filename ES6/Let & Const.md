# let & const

1. 함수스코프를 가지는 var와 달리, let과 const는 블록스코프이다.
2. let은 선언과 동시에 초기화 하지 않아도 되며, 값을 변경할 수 있음.
3. const는 선언과 동시에 초기화 하여야 하며, 값을 변경할 수 없음.
4. 다만, const에 할당된 객체나 배열의 요소를 변경하는 것은 가능.(다시 대입하는 것만 불가능)

**let**
``` javascript
let count = 10;
count = 12; // 12

let city;
city = '서울'; // "서울"
```

**const**
``` javascript
const count = 10;
count = 12; // Uncaught TypeError: Assignment to constant variable.

const city; // Uncaught SyntaxError: Missing initializer in const declaration
```

``` javascript
const countArray = [10, 12, 30];
countArray[0] = 50; // [50, 12, 30]

const city = {
  name: '서울'
};

city.name = '베를린'; // { name: '베를린'}
```

### Hoisting(호이스팅)

- Hoist란? 끌어올리기
- Hoisting 되는 것은? Declaration(선언)
- 자바스크립트 엔진 구동시 Declaration을 가장 최우선으로 해석

**using var**
``` javascript
var snack = '홈런볼';

function getFood(food) {
    if (food) {
        var snack = '새우깡';
        return snack;
    }
    return snack;
}

getFood(false); // undefined
getFood(true);  // 새우깡
```

위의 getFood()에서 snack 변수는 Hoisting 되어서 다음과 같이 동작

``` javascript
function getFood(food) {
    var snack; // 이렇게 해석됨!
    if (food) {
        snack = '새우깡';
        return snack;
    }
    return snack;
}
```

**using let**

let 키워드로 변수를 생성하면 scope이 block 단위로 제한됨.

``` javascript
let snack = '홈런볼';

function getFood(food) {
    if (food) {
        let snack = '새우깡';
        return snack;
    }
    return snack;
}

getFood(false); // 홈런볼
getFood(true);  // 새우깡
```