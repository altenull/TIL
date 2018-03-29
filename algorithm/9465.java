import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    while (T-- > 0) {
      int N = sc.nextInt();

      long[][] stickerArr = new long[2][N + 1];
      for ( int i = 0;  i < 2;  i++ ) {
        for ( int j = 1;  j <= N;  j++ ) {
          stickerArr[i][j] = sc.nextLong();
        }
      }

      // dp[n][l] : 2xn 스티커중에서 l상태 일때 최대 점수 합.
      // 상태 0 -> X  상태 1 -> X  상태 2 -> O
      //          X            O           X
      // (O : 스티커 뜯음 / X : 스티커 안 뜯음)
      long[][] dp = new long[N + 1][3];
      for ( int i = 1;  i <= N;  i++ ) {
        dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
        dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + stickerArr[1][i];
        dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + stickerArr[0][i];
      }

      long maxPoint = Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2]));
      System.out.println(maxPoint);
    }
  }
}