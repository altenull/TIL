# Class(클래스)

오브젝트의 템플릿이며 데이터 필드와 메소드 필드를 보유

```java
class Car {
  private String model;
  private int year;

  public string getModel() { return model; }
  public int getYear() { return year; }

  public void setModel(String model) { this.model = model; }
  public void getYear(int year) { this.year = year; }

  void printDescription() {
    System.out.println("this is a car");
  }
}
```