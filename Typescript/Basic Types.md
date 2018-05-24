# Basic Types

### boolean

```typescript
let isDone: boolean = false;
```

### number

> 타입스크립트는 10진수 및 16진수, ES6에 도입된 2진수 및 8진수 문자 지원함.

```typescript
let decimal: number = 6;
let hex: number = 0xf00d;
let binary: number = 0b1010;
let octal: number = 0o744;
```

### string

> 큰 따옴표(") 또는 작은 따옴표(') 사용

```typescript
let color: string = "yellow";
color = 'green';
```

> template literals 사용 가능

```typescript
let fullName: string = `heonyoung Kim`;
let age: number = 26;
let sentence: string = `Hello, my name is ${fullName}.

I'll be ${age + 1} years old next year.`;
```

### array

> 배열은 두 가지 방법 중 하나로 작성될 수 있음

```typescript
let list: number[] = [1, 2, 3];
let list: Array<number> = [1, 2, 3];
```

### tuple

> 튜플 타입은 고정된 개수의 요소 타입을 알고 있지만 반드시 같을 필요는 없는 배열을 표현

```typescript
// 튜플 타입 선언
let x: [string, number];
// 초기화
x = ["hello", 10]; // 가능
// 부정확한 초기화
x = [10, "hello"]; // 불가능
```

### enum

```typescript
enum Color {Red, Gree, Blue}
let c: Color = Color.Green;
```

기본적으로 enums는 0부터 시작하는 자신의 멤버 번호를 매기기 시작

멤버 중 하나의 값을 수동으로 설정하여 이를 변경할 수 있음

예를 들어 위의 예제를 0 대신 1로 시작할 수 있음

```typescript
enum Color {Red = 1, Green, Blue}
let c: Color = Color.Green;
```

또는 열거 형의 모든 값을 수동으로 설정

```typescript
enum Color {Red = 1, Green = 2, Blue = 4}
let c: Color = Color.Green;
```

enum의 편리한 기능은 숫자 값에서 enum의 해당 값 이름으로 이동할 수 있다는 것

예를 들어, 값 2를 가지고 있지만 위의 Color enum에서 매핑된 값이 무엇인지 확실하지 않은 경우에 그에 상응하는 이름을 찾을 수 있음

```typescript
enum Color {Red = 1, Green, Blue}
let colorName: string = Color[2];

console.log(colorName); // Red가 0이 아닌 1이므로 2는 'Green'임
```

### any

타입 검사를 선택하지 않고, 그 값이 컴파일-타임 검사를 통과하도록 하고 싶을 때 사용

```typescript
let notSure: any = 4;
notSure = '문자열일 수도 있다.';
notSure = false; // 좋아요, 확실한 boolean
```

### void

void는 any와 정반대이지만 조금 비슷, 어떠한 타입의 부재도 전혀 없음.

리턴 값이 없는 함수의 반환 타입으로 볼 수 있음

```typescript
function warnUser(): void {
  alert('this is my warning message');
}
```

void 타입의 변수 선언은 undefined 또는 null만 할당할 수 있으므로 유용하지 않습니다.

```typescript
let unusable: void = undefined;
```

### type assertions(타입 단언)

Type assetions은 컴파일러에게 '내가 하고 있는 일을 안다'라고 말하는 방법

Type assetions은 특별한 검사나 데이터를 재구성하지는 않음

런타임에 영향 미치치 않으며, 컴파일러에서만 사용

> Type assertions 사용 방법 1 : 'angle-bracket'(꺾쇠괄호)

```typescript
let someValue: any = 'this is a string';

let strLength: number = (<string>someValue).length;
```

> Type assertions 사용 방법 2 : 'as'

```typescript
let someValue: any = 'this is a string';

let strLength: number = (someValue as string).length;
```

**Typescript를 JSX와 함께 사용할 때는 **as(방법2)**만 허용됨!