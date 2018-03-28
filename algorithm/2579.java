import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); // 올라가야하는 계단 수 n
    int[] stairPoints = new int[n + 1];
    
    for ( int i = 1;  i <= n;  i++ ) {
      stairPoints[i] = sc.nextInt();
    }

    // dp[n] : n번째 계단까지 오르는데 획득할 수 있는 최대 점수
    int[] dp = new int[n + 1];
    dp[1] = stairPoints[1];
    dp[2] = stairPoints[1] + stairPoints[2];

    for ( int i = 3;  i <= n;  i++ ) {
      // 1. n번째 계단보다 한 칸 이전 계단을 밟은 경우
      // -> 이전 이전 계단은 못 밟음.
      // 2. n번째 계단보다 두 칸 이전 계단을 밟은 경우
      // -> 이전 계단은 못 밟음.
      dp[i] = Math.max(dp[i - 3] + stairPoints[i - 1] + stairPoints[i]
                      ,dp[i - 2] + stairPoints[i]);
    }

    System.out.println(dp[n]);
  }
}