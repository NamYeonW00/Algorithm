import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> q = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      int data = Integer.parseInt(br.readLine());
      q.add(data);
    }

    int sum = 0;
    while (q.size() > 1) {
      int data1 = q.poll();
      int data2 = q.poll();

      sum += data1 + data2;
      q.add(data1 + data2);
    }

    System.out.println(sum);
  }
}