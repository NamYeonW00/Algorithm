import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minusPq = new PriorityQueue<>();
    int zero = 0;
    int one = 0;
    int sum = 0;

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      
      if (num == 0)
        zero++;
      else if (num == 1)
        one++;
      else if (num > 0)
        plusPq.add(num);
      else
        minusPq.add(num);
    }

    while (plusPq.size() > 1) {
      int first = plusPq.poll();
      int second = plusPq.poll();
      sum += first * second;
    }

    if (!plusPq.isEmpty())
      sum += plusPq.poll();

    while (minusPq.size() > 1) {
      int first = minusPq.poll();
      int second = minusPq.poll();
      sum += first * second;
    }

    if (!minusPq.isEmpty() && zero == 0)
      sum += minusPq.poll();

    sum += one;

    System.out.println(sum);
  }
}