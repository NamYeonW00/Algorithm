import java.io.*;
import java.util.*;

public class Main{
  static int n;
  static int m;
  static ArrayList<Integer>[] arr;
  static boolean[] visited;
  static boolean found;

  static void dfs(int depth, int now) {
    if (depth == 5 || found) {
      found = true;
      return;
    }

    visited[now] = true;

    for (int i : arr[now]) {
      if (!visited[i])
        dfs(depth + 1, i);

      if (found)
        return;
    }

    visited[now] = false;
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      arr[i] = new ArrayList<Integer>();
    }
    
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[a].add(b);
      arr[b].add(a);
    }

    found = false;
    for (int i = 0; i < n; i++) {
      if (found)
        break;

      visited = new boolean[n];
      dfs(1, i);
    }

    if (found)
      System.out.println("1");
    else
      System.out.println("0");
  }
}