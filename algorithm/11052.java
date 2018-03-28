import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 붕어빵 개수

    int[] P = new int[N + 1]; // P[n] : 붕어빵 n개로 일어진 세트 메뉴 가격
    for ( int i = 1;  i <= N;  i++ ) {
      P[i] = sc.nextInt();
    }

    int[] maxBenefit = new int[N + 1];

    for ( int i = 1;  i <= N;  i++ ) {
      for ( int j = 1;  j <= i;  j++ ) {
        maxBenefit[i] = Math.max(maxBenefit[i], P[j] + maxBenefit[i - j]);
      }
    }

    System.out.println(maxBenefit[N]);
  }
}