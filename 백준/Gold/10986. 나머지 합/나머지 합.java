import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] S = new int[N + 1];
    S[0] = 0;
    int[] count = new int[M];
    count[0] = 1;
    
    st = new StringTokenizer(br.readLine());
    for(int i = 1; i < N + 1; i++) {
      int num = Integer.parseInt(st.nextToken());
      S[i] = (S[i - 1] + num) % M;
      count[S[i]]++;
    }

    long answer = 0;
    for (int i = 0; i < M; i++) {
      long k = count[i];
      answer += k * (k - 1) / 2;
    }

    System.out.println(answer);
  }
}