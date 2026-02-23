import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int count = 0;
    for (int i = 0; i < N; i++) {
      int num = arr[i];
      int first = 0;
      int second = N - 1;
      while (first < second) {
        int sum = arr[first] + arr[second];
        if (sum == num) {
          if (first == i) {
            first++;
          }
          else if (second == i) {
            second--;
          }
          else {
            count++;
            break;
          }
        }
        else if (sum < num) {
          first++;
        }
        else {
          second--;
        }
      }
    }

    System.out.println(count);
  }
}