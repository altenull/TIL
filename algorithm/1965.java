import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] boxSizes = new int[n + 1];

    for ( int i = 1;  i <= n;  i++ ) {
      boxSizes[i] = sc.nextInt();
    }

    int[] dp = new int[n + 1];
    int ans = 0;

    for ( int i = 1;  i <= n;  i++ ) {
      dp[i] = 1;
      for ( int j = 1;  j < i;  j++ ) {
        if ((boxSizes[j] < boxSizes[i]) && (dp[i] < dp[j] + 1)) {
          dp[i] = dp[j] + 1;
        }
      }
      if (ans < dp[i])
        ans = dp[i];
    }

    System.out.println(ans);
  }
}