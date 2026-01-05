import java.io.*;
import java.util.*;

public class Main{
  static int n;
  static int m;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;

  static void dfs(int now) {
    visited[now] = true;
    System.out.print(now + " ");

    for (int next : graph[now]) {
      if (!visited[next]) {
        dfs(next);
      }
    }

    return;
  }

  static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    visited[start] = true;
    q.add(start);

    while(!q.isEmpty()) {
      int now = q.poll();
      System.out.print(now + " ");

      for (int next : graph[now]) {
        if (!visited[next]) {
          visited[next] = true;
          q.add(next);
        }
      }
    }
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());

    graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a].add(b);
      graph[b].add(a);
    }

    for (int i = 1; i <= n; i++) {
      Collections.sort(graph[i]);
    }
        
    visited = new boolean[n + 1];
    dfs(v);
    System.out.println();

    visited = new boolean[n + 1];
    bfs(v);
  }
}