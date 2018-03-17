import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Queue<Integer> q = new LinkedList<Integer>();
    int lastValue = 0; // Queue는 FIFO임. 그래서 마지막 값을 저장하기 위한 변수를 만들어 줌.

    while (N-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      if (command.equals("push")) {
        int inputValue = Integer.parseInt(st.nextToken());
        lastValue = inputValue;
        q.offer(inputValue);
      } else if (command.equals("pop")) {
        if (q.isEmpty()) {
          System.out.println("-1");
        } else {
          System.out.println(q.poll());
        }
      } else if (command.equals("size")) {
        System.out.println(q.size());
      } else if (command.equals("empty")) {
        if (q.isEmpty()) {
          System.out.println("1");
        } else {
          System.out.println("0");
        }
      } else if (command.equals("front")) {
        if (q.isEmpty()) {
          System.out.println("-1");
        } else {
          System.out.println(q.peek());
        }
      } else if (command.equals("back")) {
        if (q.isEmpty()) {
          System.out.println("-1");
        } else {
          System.out.println(lastValue);
        }
      }
    }
  }
}