import java.io.*;
import java.util.*;

public class Main{
  static int n;
  
  static void dfs(int num, int len) {
    if (len == n) {
      System.out.println(num);
      return;
    }

    for (int i = 1; i <= 9; i++) {
      if (i % 2 == 0)
        continue;
      
      if (isPrime(num * 10 + i))
        dfs(num * 10 + i, len + 1);
    }
  }

  static boolean isPrime (int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0)
        return false;
    }

    return true;
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    dfs(2, 1);
    dfs(3, 1);
    dfs(5, 1);
    dfs(7, 1);
  }
}