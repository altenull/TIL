import java.util.Scanner;

public class Main {
  // minCase[n] : n을 1로 만드는 데 필요한 최소 연산 횟수
  static int[] minCase;

  static int getMinCase(int N) {
    if (N == 1) {
      return 0;
    }

    if (minCase[N] > 0) { // 이미 어떤 N에 대한 최솟값이 존재한다면? 더 이상 계산을 할 필요가 없음.
      return minCase[N];
    }

    minCase[N] = getMinCase(N - 1) + 1;

    if ((N % 2) == 0) { // 2로 나눠질 때
      minCase[N] = Math.min(minCase[N], getMinCase(N / 2) + 1);
    }

    if ((N % 3) == 0) { // 3으로 나눠질 때
      minCase[N] = Math.min(minCase[N], getMinCase(N / 3) + 1);
    }

    return minCase[N];
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    minCase = new int[N + 1];
    System.out.println(getMinCase(N));
  }
}