### 가상 클래스(Abstraction)

가상클래스를 상속받은 자식클래스에서는 부모클래스에서 정의된 가상 함수를 꼭 구현해줘야함. 부모클래스에선 어떤 함수가 구현되어야 한다는 것만 명시.

```java
public abstract class Abstract_Car {
  public abstract void start();
  public abstract void stop();
}

public class GasCar extends Abstract_Car {
  @Override
  public void start() {
    System.out.println("start Gas Engine");
  }

  @Override
  public void stop() {
    System.out.println("stop Gas Engine");
  }
}
```