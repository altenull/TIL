import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
  static boolean nextPermutation(int[] a) {
    // a[i - 1] < a[i]를 만족하는 가장 큰 i를 찾는다.
    int i = a.length - 1;
    while (i > 0 && a[i - 1] >= a[i]) {
      i--;
    }

    // 마지막 순열
    if (i <= 0) {
      return false;
    }

    // j >= i이면서 a[j] > a[i - 1]을 만족하는 가장 큰 j를 찾는다.
    int j = a.length - 1;
    while (a[j] <= a[i - 1]) {
      j--;
    }

    // a[i - 1]과 a[j]를 swap
    int temp = a[i - 1];
    a[i - 1] = a[j];
    a[j] = temp;

    // a[i]부터 순열 뒤집기.
    j = a.length - 1;
    while (i < j) {
      temp = a[i];
      a[i] = a[j];
      a[j] = temp;
      i++;
      j--;
    }
    return true;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int W[][] = new int[N][N];

    // W[i][j] 는 도시 i에서 j로 가기 위한 비용이며, for문에서 모든 비용을 입력받고 저장.
    for ( int i = 0;  i < N;  i++ ) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for ( int j = 0;  j < N;  j++ ) {
        W[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    br.close();

    // 도시를 방문하는 순서를 저장하는 route. 처음 순서(0 -> 1 -> ... -> (N-1))
    int route[] = new int[N];
    for ( int i = 0;  i < N;  i++ ) {
      route[i] = i;
    }

    int ans = Integer.MAX_VALUE;

    do {
      boolean ok = true;
      int sum = 0;
      for ( int i = 0;  i < N - 1;  i++ ) {
        if (W[route[i]][route[i + 1]] == 0) { // i 도시에서 i+1 도시로 가는 비용이 0이라면, 즉 갈 수 없음.
          ok = false;
        } else {
          sum += W[route[i]][route[i + 1]];
        }
      }
      if (ok && W[route[N - 1]][route[0]] != 0) { // 마지막 도시에서 처음도시로 가는 비용이 0이 아니라면, 즉 갈 수 있음.
        sum += W[route[N - 1]][route[0]];
        if (ans > sum) {
          ans = sum;
        }
      }
    } while (nextPermutation(route));

    System.out.println(ans);
  }
}