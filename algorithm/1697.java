import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  public static final int MAX = 1000000;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();

    int N = Integer.parseInt(st.nextToken()); // 수빈 위치 N
    int K = Integer.parseInt(st.nextToken()); // 동생 위치 K

    boolean[] check = new boolean[MAX]; // check[i] : i를 방문했는지 여부
    int[] dist = new int[MAX]; // dist[i] : i를 몇 번만에 방문했는지

    check[N] = true; // 맨 처음 수빈 위치는 방문함.
    dist[N] = 0; // 맨 처음 점은 제자리 이므로 0번만에 방문함.

    Queue<Integer> q = new LinkedList<Integer>();
    q.add(N);

    while (!q.isEmpty()) {
      int now = q.remove();

      if ((now - 1) >= 0) { // -1 이동했을 때,
        if (check[now - 1] == false) { // 방문 안한 곳이라면
          q.add(now - 1);
          check[now - 1] = true;
          dist[now - 1] = dist[now] + 1;
        }
      }
      if ((now + 1) < MAX) { // +1 이동했을 때,
        if (check[now + 1] == false) {
          q.add(now + 1);
          check[now + 1] = true;
          dist[now + 1] = dist[now] + 1;
        }
      }
      if ((now * 2) < MAX) { // *2 이동했을 때,
        if (check[now * 2] == false) {
          q.add(now * 2);
          check[now * 2] = true;
          dist[now * 2] = dist[now] + 1;
        }
      }
    }

    System.out.println(dist[K]);
  }
}