import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N + 1];
    
    for ( int i = 0;  i < N;  i++ ) {
      A[i] = sc.nextInt();
    }

    // dp[n] : n까지 수열 중 가장 큰 증가하는 부분 수열의 합
    int[] dp = new int[N];

    for ( int i = 0;  i < N;  i++ ) {
      dp[i] = A[i];
      for ( int j = 0;  j < i;  j++ ) {
        if (A[j] < A[i] && dp[i] < dp[j] + A[i]) {
          dp[i] = dp[j] + A[i];
        }
      }
    }

    int ans = dp[0];
    for ( int i = 1;  i < N;  i++ ) {
      ans = Math.max(ans, dp[i]);
    }

    System.out.println(ans);
  }
}