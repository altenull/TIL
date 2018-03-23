# Encapsulation(캡슐화)

클래스의 보안제공. 다른 개발자들이 클래스안에 있는 멤버와 함수를 변경할 수 없게 해줌.
예를 들어, `camry.setYear()`, `camry.setModel()`를 사용은 할 수 있지만, `setYear()`와 `setModel()`을 수정할 수는 없다.

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