import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
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

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    int inputArr[] = new int[N];
    
    StringTokenizer st = new StringTokenizer(br.readLine());

    for ( int i = 0;  i < N;  i++ ) {
      inputArr[i] = Integer.parseInt(st.nextToken());
    }

    if (nextPermutation(inputArr)) {
      for ( int i = 0;  i < N;  i++ ) {
        bw.write(inputArr[i] + " ");
      }
      bw.write("\n");
    } else {
      bw.write("-1\n");
    }
    bw.flush();
    bw.close();
  }
}