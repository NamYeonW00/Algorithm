import java.io.*;
import java.util.*;

public class Main{
  static int n;
  static int[][] g;
  static boolean[] visited;
  
  static int dfs(int i, int j) {
    if (g[i][j] == 1)
      return 1;

    visited[i] = true;

    for (int k = 0; k < n; k++) {
      if (g[i][k] == 1 && !visited[k])
        if (dfs(k, j) == 1)
          return 1;
    }

    return 0;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    g = new int[n][n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        g[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        visited = new boolean[n];
        System.out.print(dfs(i, j) + " ");
      }
      System.out.println();
    }
  }
}