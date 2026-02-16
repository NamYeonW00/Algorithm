import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer  st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] S = new int[N + 1];
    S[0] = 0;
    st = new StringTokenizer(br.readLine());
    for (int k = 0; k < N; k++) {
      int num = Integer.parseInt(st.nextToken());
      S[k + 1] = S[k] + num;
    }
    
    for (int k = 0; k < M; k++) {
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      System.out.println(S[j] - S[i - 1]);
    }
  }
}