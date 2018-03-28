import java.util.Scanner;

public class Main {
  static boolean nextPermutation(int[] a) {
    // a[i - 1] < a[i]를 만족하는 가장 큰 i를 찾는다.
    int i = a.length - 1;
    while (i > 0 && a[i - 1] >= a[i]) {
      i--;
    }

    // 마지막 순열
    if (i <= 0) {
      return false;
    }

    // j >= i이면서 a[j] > a[i - 1]을 만족하는 가장 큰 j를 찾는다.
    int j = a.length - 1;
    while (a[j] <= a[i - 1]) {
      j--;
    }

    // a[i - 1]과 a[j]를 swap
    int temp = a[i - 1];
    a[i - 1] = a[j];
    a[j] = temp;

    // a[i]부터 순열 뒤집기.
    j = a.length - 1;
    while (i < j) {
      temp = a[i];
      a[i] = a[j];
      a[j] = temp;
      i++;
      j--;
    }
    return true;
  }

  public static void main(String args[]) {
    // W[i][j]는 도시 i에서 도시 j로 가기 위한 비용
    // W[i][i]는 항상 0
    // 도시 i에서 도시 j로 갈 수 없는 경우에도 W[i][j] = 0
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int[][] W = new int[N][N];
    for ( int i = 0;  i < N;  i++ ) {
      for ( int j = 0;  j < N;  j++ ) {
        W[i][j] = sc.nextInt();
      }
    }

    int[] visitingOrder = new int[N];
    for ( int i = 0;  i < N;  i++ ) {
      visitingOrder[i] = i;
    }

    int minCost = Integer.MAX_VALUE;
    
    do {
      boolean ok = true;
      int sum = 0;
      for ( int i = 0;  i < (N - 1);  i++ ) {
        if (W[visitingOrder[i]][visitingOrder[i + 1]] == 0) {
          ok = false;
        } else {
          sum += W[visitingOrder[i]][visitingOrder[i + 1]];
        }
      }
      
      if (ok && W[visitingOrder[N - 1]][visitingOrder[0]] != 0) {
        sum += W[visitingOrder[N - 1]][visitingOrder[0]];
        if (sum < minCost) {
          minCost = sum;
        }
      }
    } while (nextPermutation(visitingOrder));

    System.out.println(minCost);
  }
}