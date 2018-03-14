import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int E = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int e = 1;
    int s = 1;
    int m = 1;

    for ( int i = 1;  ;  i++ ) {
      if ((E == e) && (S == s) && (M == m)) {
        System.out.println(i);
        break;
      }
      e++;
      s++;
      m++;

      // 16 * 29 * 20 = 대략 12000이니까 모두 다 해보는 방법으로 함.
      if (e == 16) {
        e = 1;
      }
      if (s == 29) {
        s = 1;
      }
      if (m == 20) {
        m = 1;
      }
    }
  }
}