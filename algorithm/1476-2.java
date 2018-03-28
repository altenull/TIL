import java.util.Scanner;

class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int E = sc.nextInt();
    int S = sc.nextInt();
    int M = sc.nextInt();
    int e = 1;
    int s = 1;
    int m = 1;

    int year = 1;
    while (true) {
      if ((E == e) && (S == s) && (M == m)) {
        System.out.println(year);
        break;
      }
      e++;
      s++;
      m++;
      if (e == 16) {
        e = 1;
      }
      if (s == 29) {
        s = 1;
      }
      if (m == 20) {
        m = 1;
      }
      year++;
    }
  }
}