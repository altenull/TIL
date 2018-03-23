import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // N개의 수열
    int M = sc.nextInt(); // 합이 M이 되어야 함.

    int[] intArr = new int[N + 1];

    for ( int i = 0;  i < N;  i++ ) {
      intArr[i] = sc.nextInt();
    }

    int left = 0;
    int right = 0;
    int sum = intArr[0];
    int ans = 0;

    while (left <= right && right < N) {
      if (sum < M) {
        right++;
        sum += intArr[right];
      } else if (sum == M) {
        ans++;
        right++;
        sum += intArr[right];
      } else if (sum > M) {
        sum -= intArr[left];
        left++;
        if (left > right && left < N) {
          right = left;
          sum = intArr[left];
        }
      }
    }

    System.out.println(ans);
  }
}