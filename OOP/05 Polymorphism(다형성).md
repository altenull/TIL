# Polymorphism(다형성)

### 오버로딩(Overloading)

같은 이름의 함수를 여러개 정의하는 것. 파라미터의 개수를 다르게 하거나, 파라미터의 데이터 타입을 달리하여 구현해야함.

### 오버라이딩(Overriding)

부모 클래스를 상속 받은 자식 클래스 내에서 부모 클래스의 포함된 함수를 재정의 하는 것.

```java
public class Tesla extends Car {
  // 오버라이딩
  // 부모 클래스인 Car 클래스에 printDescription() 함수 이미 존재. 이 함수를 재정의함.
  void printDescription() {
    System.out.println("this is a electric car");
  }

  // 오버로딩
  // printDescription() 함수는 이미 Tesla 클래스내에 구현되어 있음. 파라미터를 달리하여 추가로 구현함.
  void printDescription(String param) {
    System.out.println("this is a electric car, year : " + super.getYear() + ", model : " + super.getModel() + ".");
  }
}
```