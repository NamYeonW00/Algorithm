import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class Main{
  static List<int[]>[] graph;
  static boolean[] visited;
  static int farNode;

  static int bfs(int from) {
    Queue<Integer> queue = new LinkedList<>();
    visited = new boolean[graph.length];
    int[] dist = new int[graph.length];
    
    queue.add(from);
    visited[from] = true;

    int maxDist = 0;
    farNode = from;
    
    while(!queue.isEmpty()) {
      int cur = queue.poll();
      
      for (int[] next : graph[cur]) {
        int to = next[0];
        int weight = next[1];

        if (!visited[to]) {
          visited[to] = true;
          dist[to] = dist[cur] + weight;
          queue.add(to);
          
          if (dist[to] > maxDist) {
            maxDist = dist[to];
            farNode = to;
          }
        }
      }
    }

    return maxDist;
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int V = Integer.parseInt(br.readLine());
    
    graph = new ArrayList[V + 1];
    for (int i = 1; i <= V; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < V; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());

      while (true) {
        int to = Integer.parseInt(st.nextToken());
        if (to == -1)
          break;
        int weight = Integer.parseInt(st.nextToken());
        graph[from].add(new int[]{to, weight});
      }
    }

    bfs(1);
    int answer = bfs(farNode);

    System.out.println(answer);
  }
}