import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] lec = new int[n];
    int start = 0;
    int end = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      lec[i] = Integer.parseInt(st.nextToken());
      if (start < lec[i]) {
        start = lec[i];
      }
      end += lec[i];
    }

    while (start <= end) {
      int mid = (start + end) / 2;
      int sum = 0;
      int count = 0;

      for (int i = 0; i < n; i++) {
        if (sum + lec[i] > mid) {
          count++;
          sum = 0;
        }
        sum += lec[i];
      }

      if (sum != 0)
        count++;

      if (count > m)
        start = mid + 1;
      else
        end = mid - 1;
    }

    System.out.println(start);
  }
}