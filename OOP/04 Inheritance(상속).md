# Inheritance(상속)

코드의 재사용성을 위해 존재. `Car` 클래스에 있는 **model**, **year**와 관련된 함수를 구현하지 않아도 사용가능.

```java
// Car 클래스가 부모 클래스
public class Benz extends Car {
  void printDescription() {
    System.out.println("this is a Benz car");
  }
}

public class Main {
  public static void main(String args[]) {
    Benz benzCar = new Benz();
    benzCar.setModeal("Benz-1991");
    benzCar.setYear(1991);
  }
}
```