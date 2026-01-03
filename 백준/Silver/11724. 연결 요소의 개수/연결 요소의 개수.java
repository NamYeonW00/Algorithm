import java.io.*;
import java.util.*;

public class Main{
  static ArrayList<Integer>[] arr;
  static boolean visited[];

  static void dfs(int n) {
    visited[n] = true;

    for (int i : arr[n]) {
      if (!visited[i]) {
        dfs(i);
      }
    }
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    arr = new ArrayList[n + 1];
    visited = new boolean[n + 1];

    for (int i = 1; i < n + 1; i++) {
      arr[i] = new ArrayList<Integer>();
    }
    
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken()); 

      arr[a].add(b);
      arr[b].add(a);
    }

    int count = 0;
    for (int i = 1; i < n + 1; i++) {
      if (!visited[i]) {
        count++;
        dfs(i);
      }
    }
    
    System.out.println(count);
  }
}