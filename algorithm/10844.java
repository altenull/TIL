import java.util.Scanner;

public class Main {
  public static long mod = 1000000000L;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 길이가 N인 계단 수 구하기

    // dp[n][l] : n자리 숫자 중 마지막 자리가 l인 계단수의 개수
    //            마지막 자리 l은 0부터 9까지 올 수 있음(총 10개)
    long[][] dp = new long[N + 1][10];

    // 1자리 계단수는 1부터 9까지 가능함(0으로 시작하는 수는 없어서 1부터 루프)
    for ( int j = 1;  j <= 9;  j++ ) {
      dp[1][j] = 1;
    }

    // 1자리인 것은 위에 for문에서 구함.
    for ( int i = 2;  i <= N;  i++ ) {
      for ( int j = 0;  j <= 9;  j++ ) {
        dp[i][j] = 0;

        if ((j - 1) >= 0) {
          dp[i][j] += dp[i - 1][j - 1];
        }

        if ((j + 1) <= 9) {
          dp[i][j] += dp[i - 1][j + 1];
        }

        dp[i][j] %= mod;
      }
    }

    long totalStairNum = 0;
    for ( int j = 0;  j <= 9;  j++ ) {
      totalStairNum += dp[N][j];
    }

    totalStairNum %= mod;
    System.out.println(totalStairNum);
  }
}