import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();

    StringBuilder sb = new StringBuilder();

    for ( int i = 0;  i < N;  i++ ) {
      int input = sc.nextInt();
      if (input < X) {
        sb.append(input + " ");
      }
    }

    System.out.println(sb.toString());
  }
}