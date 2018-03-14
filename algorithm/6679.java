class Main {
  public static void main(String args[]) {
    for ( int i = 1000;  i < 10000;  i++ ) {
      int x = i;
      int y = i;
      int z = i;
      int ten = 0;
      int twelve = 0;
      int sixteen = 0;

      while (true) {
        ten += x % 10;
        x = x / 10;
        if (x == 0) {
          break;
        }
      }
      
      while (true) {
        twelve += y % 12;
        y = y / 12;
        if (y == 0) {
          break;
        }
      }

      while (true) {
        sixteen += z % 16;
        z = z / 16;
        if (z == 0) {
          break;
        }
      }

      if ((ten == twelve) && (twelve == sixteen)) {
        System.out.println(i);
      }
    }
  }
}