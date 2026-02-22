import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[][] info = new int[N][2];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      info[i][0] = Integer.parseInt(st.nextToken());
      info[i][1] = Integer.parseInt(st.nextToken());
    }

    int[] count = new int[N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i != j && info[i][0] < info[j][0] && info[i][1] < info[j][1]) {
          count[i]++;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      System.out.print((count[i] + 1) + " ");
    }
  }
}