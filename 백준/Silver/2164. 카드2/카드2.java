import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      queue.add(i);
    }

    int last = 0;
    while (!queue.isEmpty()) {
      last = queue.poll();
      if (!queue.isEmpty()) {
        queue.add(queue.poll());
      }
    }

    System.out.println(last);
  }
}