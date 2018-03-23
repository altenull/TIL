import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static boolean alphaCheck(String password) {
    int ja = 0; // 자음
    int mo = 0; // 모음

    for (char x : password.toCharArray()) {
      if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
        mo++;
      } else {
        ja++;
      }
    }
    // 암호에는 2개 이상의 자음과 1개 이상의 모음이 포함되어야함.
    return (ja >= 2) && (mo >= 1);
  }

  /*
    @param
    passwordGoalLength : 만들어야하는 암호 길이
    alpha : 사용할 수 있는 알파벳
    password : 현재까지 만든 암호
    i : 사용할지 말지 결정해야 하는 알파벳의 인덱스
  */
  public static void printPassword(int passwordGoalLength, String[] alpha, String password, int i) {
    if (password.length() == passwordGoalLength) {
      if (alphaCheck(password)) {
        System.out.println(password);
      }
      return;
    }

    if (i >= alpha.length) // 종료 조건
      return;

    // i번째 알파벳을 사용하는 경우
    printPassword(passwordGoalLength, alpha, password + alpha[i], i + 1);
    // i번째 알파벳을 사용하지 않는 경우
    printPassword(passwordGoalLength, alpha, password, i + 1);
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // C 개의 알파벳 중 L개를 사용해야함.
    StringTokenizer st = new StringTokenizer(br.readLine());
    int L = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    String[] alpha = br.readLine().split(" ");

    Arrays.sort(alpha);

    printPassword(L, alpha, "", 0);
  }
}