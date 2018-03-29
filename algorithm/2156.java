import java.util.Scanner;

public class Main {
  static int getMax(int a, int b, int c) {
    if (b > c) {
      if (a > b)
        return a;
      else
        return b;
    } else {
      if (a > c)
        return a;
      else
        return c;
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] wine = new int[n + 1];

    // 포도주 양 입력
    for ( int i = 1;  i <= n;  i++ ) {
      wine[i] = sc.nextInt();
    }

    // dp[n] : n개의 포도주 중 마실 수 있는 최대 포도주 양
    int[] dp = new int[n + 1];
    dp[1] = wine[1];
    if (n >= 2) {
      dp[2] = wine[1] + wine[2];
    }

    for ( int i = 3;  i <= n;  i++ ) {
      dp[i] = getMax(dp[i - 1], (dp[i - 3] + wine[i - 1] + wine[i]), (dp[i - 2] + wine[i]));
    }

    System.out.println(dp[n]);
  }
}