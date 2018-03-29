import java.util.Scanner;

public class Main {
  public static final int mod = 10007;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // N자리 오르막 수 구하기

    //dp [n][l] : n자리 수에서 마지막 숫자가 l인 오르막 수의 개수
    //           (수는 0으로 시작할 수 있음)
    int[][] dp = new int[N + 1][10];

    for ( int j = 0;  j <= 9;  j++ ) {
      dp[1][j] = 1;
    }

    for ( int i = 2;  i <= N;  i++ ) {
      for ( int j = 0;  j <= 9;  j++ ) {
        dp[i][j] = 0;
        for ( int k = 0;  k <= j;  k++ ) {
          dp[i][j] += dp[i - 1][k];
          dp[i][j] %= mod;
        }
      }
    }

    int totalIncreaseNum = 0;
    for ( int j = 0;  j <= 9;  j++ ) {
      totalIncreaseNum += dp[N][j];
    }
    totalIncreaseNum %= mod;

    System.out.println(totalIncreaseNum);
  }
}