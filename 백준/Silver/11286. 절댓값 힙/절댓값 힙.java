import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
      int first = Math.abs(o1);
      int second = Math.abs(o2);

      int cmp = Integer.compare(first, second);
      if (cmp != 0)
        return cmp;

      return Integer.compare(o1, o2);
    });

    for (int i = 0; i < N; i++) {
      int request = Integer.parseInt(br.readLine());

      if (request == 0) {
        if (pq.isEmpty()) {
          System.out.println("0");
        }
        else {
          System.out.println(pq.poll());
        }
      }
      else {
        pq.add(request);
      }
    }
  }
}