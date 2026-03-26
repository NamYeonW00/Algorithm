import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    int start = 1;
    int end = k;
    int answer = 0;
    while (start <= end) {
      int mid = (start + end) / 2;
      int count = 0;
      
      for (int i = 1; i <= n; i++) {
        count += Math.min(mid / i, n);
      }

      if (count >= k) {
        answer = mid;
        end = mid - 1;
      }
      else {
        start = mid + 1;
      }
    }
    System.out.println(answer);
  }
}