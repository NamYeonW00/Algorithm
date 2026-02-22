import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[11];
    int count = 0;
    
    for (int i = 1; i < 11; i++) {
      arr[i] = -1;
    }
    
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int cow = Integer.parseInt(st.nextToken());
      int now = Integer.parseInt(st.nextToken());

      if (arr[cow] != -1 && arr[cow] != now) {
        count++;
      }
      arr[cow] = now;
    }

    System.out.println(count);
  }
}