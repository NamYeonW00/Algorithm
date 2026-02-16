import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] A = new int[N + 1][N + 1];
    for (int i = 1; i < N + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < N + 1; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] S = new int[N + 1][N + 1];
    for (int i = 1; i < N + 1; i++) {
      for (int j = 1; j < N + 1; j++) {
        S[i][j] = S[i][j - 1] + S[i - 1][j] - S[i - 1][j - 1] + A[i][j];
      }
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      System.out.println(S[x2][y2] - S[x2][y1 - 1] - S[x1 - 1][y2] + S[x1 - 1][y1 - 1]);
    }    
  }
}