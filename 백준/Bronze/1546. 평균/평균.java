import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int sum = 0;
    int max = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int score = Integer.parseInt(st.nextToken());
      sum += score;
      if (max < score)
        max = score;
    }

    System.out.println((double)sum / max * 100 / N);
  }
}