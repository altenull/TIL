import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  public static final int MAX = 2000000;

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();

    int F = Integer.parseInt(st.nextToken()); // 전체 엘리비에티 층수
    int S = Integer.parseInt(st.nextToken()); // 현재 층
    int G = Integer.parseInt(st.nextToken()); // 가야하는 층
    int U = Integer.parseInt(st.nextToken()); // Up 버튼
    int D = Integer.parseInt(st.nextToken()); // Down 버튼

    boolean[] check = new boolean[MAX];
    int[] dist = new int[MAX];

    check[S] = true; // check[n] : 어떤 n층이 방문한 층인지 아닌지 확인하는 check
    dist[S] = 0; // dist[n] : 어떤 n층에 최소 몇 번만에 가는지를 저장하는 dist

    Queue<Integer> q = new LinkedList<Integer>();
    q.add(S);

    while (!q.isEmpty()) {
      int now = q.remove();

      // U층만큼 올라감
      int next = now + U;
      if (next <= F) { // U층만큼 올라간 층이 전체 층 F보다 이하일 때
        if (check[next] == false) {
          q.add(next);
          check[next] = true;
          dist[next] = dist[now] + 1;
        }
      }

      // D층만큼 내려감
      next = now - D;
      if (next >= 1) { // D층만큼 내려간 층이 1층 이상일 때
        if (check[next] == false) {
          q.add(next);
          check[next] = true;
          dist[next] = dist[now] + 1;
        }
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    if (check[G]) { // G층으로 이동할 수 있을 때
      bw.write(dist[G] + "\n");
    } else { // G층으로 이동할 수 없을 때
      bw.write("use the stairs\n");
    }
    bw.flush();
    bw.close();
  }
}