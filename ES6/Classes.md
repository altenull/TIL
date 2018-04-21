# Classes

ES6 이전에는 **prototype**으로 클래스처럼 사용함.

```javascript
function Person(name, age, gender) {
  this.name = name;
  this.age = age;
  this.gender = gender;
}

Person.prototype.incrementAge = function() {
  return this.age +=;
};
```

**ES6 클래스를 사용하면?**

```javascript
class Person {
  constructor(name, age, gender) {
    this.anem = name;
    this.age = age;
    this.gender = gender;
  }

  incrementAge() {
    this.age += 1;
  }
}
```

**extends(상속)도 가능!**

```javascript
class Personal extends Person {
  constructor(name, age, gender, occupation, hobby) {
    super(name, age, gender);
    this.occupation = occupation;
    this.hobby = hobby;
  }

  incrementAge() {
    super.incrementAge();
    this age += 20;
    console.log(this.age);
  }
}
```