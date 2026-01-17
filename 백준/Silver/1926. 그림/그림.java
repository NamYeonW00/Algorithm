import java.io.*;
import java.util.*;

public class Main{
  static int n;
  static int m;
  static int[][] paper;
  static boolean[][] visited;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static int bfs(int i, int j) {
    Queue<int[]> queue = new LinkedList<>();

    visited[i][j] = true;
    queue.add(new int[] {i, j});

    int area = 1;
    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      
      for (int k = 0; k < 4; k++) {
        int x = now[0] + dx[k];
        int y = now[1] + dy[k];

        if (x >= 0 && y >= 0 && x < n && y < m) {
          if (paper[x][y] == 1 && !visited[x][y]) {
            visited[x][y] = true;
            queue.add(new int[] {x, y});
            area++;
          }
        }
      }
    }

    return area;
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    paper = new int[n][m];
    visited = new boolean[n][m];
    
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int count = 0;
    int max = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (paper[i][j] == 1 && !visited[i][j]) {
          int area = bfs(i, j);
          if (max < area)
            max = area;
          count++;
        }
      }
    }
    
    System.out.println(count);
    System.out.println(max);
  }
}