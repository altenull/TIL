import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();

    int ABC = A * B * C;

    int[] counter = new int[10];

    for ( int i = 0;  i < 10;  i++ ) {
      counter[i] = 0;
    }

    while (true) {
      int checkValue = ABC % 10;
      ABC = ABC / 10;

      counter[checkValue]++;
      if (ABC == 0) {
        break;
      }
    }

    for ( int i = 0;  i < 10;  i++ ) {
      System.out.println(counter[i]);
    }
  }
}