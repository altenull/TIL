# interface VS type

### 작성규칙

interface
```javascript
interface Person {
  name: string,
  age: number
}
```

type
```javascript
type Person = {
  name: string,
  age: number
}
```

### interface와 type 차이점

interface는 `extends`, `implements` 절에서 사용될 수 있다. 하지만 type은 사용될 수 없다.