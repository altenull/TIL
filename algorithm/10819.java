import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
  public static boolean nextPermutation(int[] a) {
    int i = a.length - 1;
    while (i > 0 && a[i - 1] >= a[i]) {
      i -= 1;
    }

    // 마지막 순열
    if (i <= 0) {
      return false;
    }

    int j = a.length - 1;
    while (a[j] <= a[i - 1]) {
      j--;
    }

    int temp = a[i - 1];
    a[i - 1] = a[j];
    a[j] = temp;

    j = a.length-1;
    while (i < j) {
      temp = a[i];
      a[i] = a[j];
      a[j] = temp;
      i--;
      j--;
    }

    return true;
  }

  public static int calculate(int a[]) {
    int sum = 0;
    for ( int i = 1;  i < a.length;  i++ ) {
      int result = a[i] - a[i - 1];
      sum += Math.abs(a[i] = a[i - 1]);
    }
    return sum;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int a[] = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for ( int i = 0;  i < n;  i++ ) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    br.close();

    Arrays.sort(a);
    int ans = 0;

    do {
        int temp = calculate(a);
        ans = Math.max(ans, temp);
    } while(nextPermutation(a));

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(ans);
    bw.flush();
    bw.close();
  }
}