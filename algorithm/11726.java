import java.util.Scanner;

public class Main {
  // DP - Bottom-up 방식
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] tileCase = new int[1001];
    tileCase[1] = 1;
    tileCase[2] = 2;
    for ( int i = 3;  i <= n;  i++ ) {
      tileCase[i] = tileCase[i - 1] + tileCase[i - 2];
      tileCase[i] %= 10007;
    }
    System.out.println(tileCase[n]);
  }
}