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

    boolean[] visit = new boolean[MAX];
    int[] dist = new int[MAX];

    visit[S] = true; // visit[n] : 어떤 n층이 방문한 층인지 아닌지 확인하는 visit
    dist[S] = 0; // dist[n] : 어떤 n층에 최소 몇 번만에 가는지를 저장하는 dist

    Queue<Integer> q = new LinkedList<Integer>();
    q.add(S);

    while (!q.isEmpty()) {
      int now = q.remove();
      int[] nextArr = { U, -D };

      for ( int i = 0;  i < nextArr.length;  i++ ) {
        int next = now + nextArr[i];

        // next가 1층 미만이거나, F층보다 크거나, 이미 방문한 곳이라면 패스.
        // 그렇지 않다면, 다음 작업 진행
        if (next < 1 || next > F || visit[next]) {
          continue;
        } else {
          q.add(next);
          visit[next] = true;
          dist[next] = dist[now] + 1;
        }
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    if (visit[G]) { // G층으로 이동할 수 있을 때
      bw.write(dist[G] + "\n");
    } else { // G층으로 이동할 수 없을 때
      bw.write("use the stairs\n");
    }
    bw.flush();
    bw.close();
  }
}