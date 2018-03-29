import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // N짜리 수열
    int S = sc.nextInt(); // 연속된 수들의 부분합 중에 그 합이 S 이상이 되어야 함

    // 수열 입력받기
    int[] intArr = new int[N + 1];
    for ( int i = 0;  i < N;  i++ ) {
      intArr[i] = sc.nextInt();
    }

    int left = 0;
    int right = 0;
    int sum = intArr[0];
    int minLength = N + 1;

    while ((left <= right) && (right < N)) {
      if (sum < S) {
        right++;
        sum += intArr[right];
      } else if (sum == S) {
        minLength = Math.min(minLength, (right - left + 1));
        right++;
        sum += intArr[right];
      } else if (sum > S) {
        minLength = Math.min(minLength, (right - left + 1));
        sum -= intArr[left];
        left++;
      }
    }

    // 만일 부분 수열의 합이 S이상으로 만드는 것이 불가능하다면 0 출력
    if (minLength > N) {
      minLength = 0;
    }

    System.out.println(minLength);
  }
}