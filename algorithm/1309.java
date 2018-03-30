import java.util.Scanner;

public class Main {
  static final int mod = 9901;
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int[][] dp = new int[N + 1][3];
    
    dp[1][0] = 1;
    dp[1][1] = 1;
    dp[1][2] = 1;

    for ( int i = 2;  i <= N;  i++ ) {
      dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
      dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
      dp[i][2] = dp[i - 1][0] + dp[i - 1][1];
      dp[i][0] %= mod;
      dp[i][1] %= mod;
      dp[i][2] %= mod;
    }

    int ans = dp[N][0] + dp[N][1] + dp[N][2];
    ans %= mod;

    System.out.println(ans);
  }
}