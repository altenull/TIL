import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  public static final int MAX = 2000000;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int F = sc.nextInt(); // 전체 층수
    int S = sc.nextInt(); // 현재 층
    int G = sc.nextInt(); // 가야하는 층
    int U = sc.nextInt(); // 한 번에 올라가는 층수
    int D = sc.nextInt(); // 한 번에 내려가는 층수

    int[] dist = new int[MAX];
    boolean[] isVisited = new boolean[MAX];

    dist[S] = 0;
    isVisited[S] = true;

    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(S);

    int[] buttons = { U, -D };

    while (!queue.isEmpty()) {
      int now = queue.remove();

      for ( int i = 0;  i < buttons.length;  i++ ) {
        int nextFloor = now + buttons[i];

        if ((nextFloor < 1) || (nextFloor > F) || isVisited[nextFloor]) {
          continue;
        } else {
          queue.add(nextFloor);
          dist[nextFloor] = dist[now] + 1;
          isVisited[nextFloor] = true;
        }
      }
    }
    
    if (isVisited[G]) {
      System.out.println(dist[G]);
    } else {
      System.out.println("use the stairs");
    }
  }
}