# let & const

1. let과 const는 block scope이다.
2. let은 선언과 동시에 초기화 하지 않아도 되며, 값을 변경할 수 있음.
3. const는 선언과 동시에 초기화 하여야 하며, 값을 변경할 수 없음.

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