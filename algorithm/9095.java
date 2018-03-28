import java.util.Scanner;

public class Main {
  static int getCaseNum(int n) {
    if (n <= 2) {
      return n;
    } else if (n == 3) {
      return 4;
    }

    return getCaseNum(n - 1) + getCaseNum(n - 2) + getCaseNum(n - 3);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    
    while (T-- > 0) {
      int n = sc.nextInt();
      System.out.println(getCaseNum(n));
    }
  }
}