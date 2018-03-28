import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public static final int MAX = 1000000;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 수빈 위치 N
    int K = sc.nextInt(); // 동생 위치 K

    int[] dist = new int[MAX];
    boolean[] isVisited = new boolean[MAX];
    
    dist[N] = 0;
    isVisited[N] = true;

    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(N);
    
    while (!queue.isEmpty()) {
      int now = queue.poll();

      if ((now - 1) >= 0) {
        if (isVisited[now - 1] == false) {
          queue.add(now - 1);
          isVisited[now - 1] = true;
          dist[now - 1] = dist[now] + 1;
        }
      }

      if ((now + 1) < MAX) {
        if (isVisited[now + 1] == false) {
          queue.add(now + 1);
          isVisited[now + 1] = true;
          dist[now + 1] = dist[now] + 1;
        }
      }

      if ((now * 2) < MAX) {
        if (isVisited[now * 2] == false) {
          queue.add(now * 2);
          isVisited[now * 2] = true;
          dist[now * 2] = dist[now] + 1;
        }
      }
    }
    System.out.println(dist[K]);
  }
}