import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();

    int A = Integer.parseInt(st.nextToken()); // A 스카이콩콩 힘
    int B = Integer.parseInt(st.nextToken()); // B 스카이콩콩 힘
    int N = Integer.parseInt(st.nextToken()); // 현재 위치 N
    int M = Integer.parseInt(st.nextToken()); // 목표 위치 M

    boolean[] check = new boolean[100001];
    int[] dist = new int[100001];

    check[N] = true;
    dist[N] = 0;

    Queue<Integer> q = new LinkedList<Integer>();
    q.add(N);

    while (!q.isEmpty()) {
      int now = q.remove();

      int[] nextArr = new int[]{1, -1, A, -A, B, -B, now * A, -now * A, now * B, -now * B};

      for ( int i = 0;  i < nextArr.length;  i++ ) {
        int next = 0;

        if (i <= 5) { // 1 ~ -B까지
          next = now + nextArr[i];
        } else { // now * A ~ -now * B까지
          next = nextArr[i];
        }

        if (next < 0 || next > 100000) { // next가 0 ~ 100000이 아니라면 패스
          continue;
        }

        if (check[next]) { // 방문한 곳이라도 패스
          continue;
        }

        q.add(next);
        check[next] = true;
        dist[next] = dist[now] + 1;
      }
    }
    System.out.println(dist[M]);
  }
}