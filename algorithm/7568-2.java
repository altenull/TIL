import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    Person[] people = new Person[N];

    for ( int i = 0;  i < N;  i++ ) {
      people[i] = new Person(sc.nextInt(), sc.nextInt());
    }

    for (Person p1 : people) {
      for (Person p2 : people) {
        if ((p1.weight < p2.weight) && (p1.height < p2.height)) {
          p1.rank++;
        }
      }
    }

    for (Person person : people) {
      System.out.print(person.rank + " ");
    }
  }

  public static class Person {
    int weight;
    int height;
    int rank;
  
    public Person(int paramWeight, int paramHeight) {
      this.weight = paramWeight;
      this.height = paramHeight;
      this.rank = 1;
    }
  }
}