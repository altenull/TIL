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