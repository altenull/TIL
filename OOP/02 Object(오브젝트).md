# Object(오브젝트)

클래스의 인스턴스. `new` 키워드를 써서 `Car`라는 클래스를 통하여 **camry**라는 오브젝트를 생성함. 이때, 오브젝트가 메모리에 할당됨. 오브젝트가 생성되고 나면 오브젝트의 함수 사용가능.

```java
public class YourProgram {
  public static void main(String args[]) {
    Car camry = new Car();
    camry.setModel("camry");
    camry.setYear(2009);

    Benz modelX = new Benz();
    modelX.setModel("benz-2018");
    modelX.setYear(2018);

    camry.printDescription();
    modelX.printDescriptino();
  }
}
```