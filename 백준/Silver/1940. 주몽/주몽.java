import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int first = 0;
    int second = N - 1;
    int count = 0;
    while (first < second) {
      int sum = arr[first] + arr[second];
      if (sum == M) {
        count++;
        first++;
      }
      else if (sum < M) {
        first++;
      }
      else {
        second--;
      }
    }

    System.out.println(count);
  }
}