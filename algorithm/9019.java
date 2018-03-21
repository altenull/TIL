import java.util.*;

public class Main {
  public static final int MAX = 10001;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    
    while (t-- > 0) {
      int A = sc.nextInt();
      int B = sc.nextInt();
      
      boolean[] check = new boolean[MAX];
      int[] dist = new int[MAX];
      char[] word = new char[MAX];
      int[] from = new int[MAX];

      check[A] = true;
      dist[A] = 0;
      from[A] = -1;

      Queue<Integer> q = new LinkedList<Integer>();
      q.add(A);

      while (!q.isEmpty()) {
        int now = q.remove();

        // D 연산
        // 곱하기 2
        int next = (now * 2) % 10000;
        if (check[next] == false) {
          q.add(next);
          check[next] = true;
          dist[next] = dist[now] + 1;
          from[next] = now;
          word[next] = 'D';
        }

        // S 연산
        // 빼기 1
        next = now - 1;
        if (next == -1) {
          next = 9999;
        }
        if (check[next] == false) {
          q.add(next);
          check[next] = true;
          dist[next] = dist[now] + 1;
          from[next] = now;
          word[next] = 'S';
        }

        // L 연산
        // 1234 -> 2341
        next = (now % 1000) * 10 + now / 1000;
        if (check[next] == false) {
          q.add(next);
          check[next] = true;
          dist[next] = dist[now] + 1;
          from[next] = now;
          word[next] = 'L';
        }
        
        // R 연산
        // 1234 -> 4123
        next = (now / 10) + (now % 10) * 1000;
        if (check[next] == false) {
          q.add(next);
          check[next] = true;
          dist[next] = dist[now] + 1;
          from[next] = now;
          word[next] = 'R';
        }
      }

      // A가 10이고 B가 19라면?
      // 10 -> 20 -> 19
      //    D      S

      // 아래 while문에서는 B에서부터 거꾸로 트래킹함.

      // 19는 어디서부터 만들어졌나? from[19] -> 20
      // 19는 무슨 연산으로 만들어졌나? word[19] -> S
      // ans -> S
      // 20은 어디서부터 만들어졌나? from[20] -> 10
      // 20은 무슨 연산으로 만들어졌나? word[20] -> D
      // ans -> SD
      StringBuilder ans = new StringBuilder();
      while (B != A) {
        ans.append(word[B]);
        B = from[B];
      }

      // 출력할 때
      // ans -> DS
      System.out.println(ans.reverse());
    }
  }
}