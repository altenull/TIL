import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Person[] people = new Person[N];

    // 입력
    for ( int i = 0;  i < N;  i++ ) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    br.close();

    // for문을 돌면서 p1보다 덩치가 큰 p2가 있을 때 rank 1 증가
    for (Person p1 : people) {
      for (Person p2 : people) {
        if (p1.weight < p2.weight && p1.height < p2.height) {
          p1.rank++;
        }
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (Person p : people) {
      bw.write(p.rank + " ");
    }
    bw.flush();
    bw.close();
  }

  public static class Person {
    private int weight;
    private int height;
    private int rank;

    // Person 생성자
    public Person(int weight, int height) {
      this.weight = weight;
      this.height = height;
      this.rank = 1;
    }
  }
}