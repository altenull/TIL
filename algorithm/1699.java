import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    // dp[n] : n을 제곱수들의 합으로 표현할 때에 그 항의 최소 개수.
    int[] dp = new int[N + 1];

    for ( int i = 1;  i <= N;  i++ ) {
      dp[i] = i;
      for ( int j = 1;  (j * j) <= i;  j++ ) {
        if (dp[i] > (dp[i - (j * j)] + 1)) {
          dp[i] = dp[i - (j * j)] + 1;
        }
      }
    }

    System.out.println(dp[N]);
  }
}