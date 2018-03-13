import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.util.StringTokenizer;

class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int S = 0;
    int M = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (M-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      if (command.equals("add")) {
        int x = Integer.parseInt(st.nextToken()) - 1;
        S = (S | (1 << x));
      } else if (command.equals("remove")) {
        int x = Integer.parseInt(st.nextToken()) - 1;
        S = (S & ~(1 << x));
      } else if (command.equals("check")) {
        int x = Integer.parseInt(st.nextToken()) - 1;
        int res = (S & (1 << x));
        if (res != 0) {
          sb.append("1\n");
        } else {
          sb.append("0\n");
        }
      } else if (command.equals("toggle")) {
        int x = Integer.parseInt(st.nextToken()) - 1;
        S = (S ^ (1 << x));
      } else if (command.equals("all")) {
        S = ((1 << 20) - 1);
      } else if (command.equals("empty")) {
        S = 0;
      }
    }
    System.out.println(sb);
  }
}