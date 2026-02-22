import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] count = new int[2];
    int[] score = new int[2];
    int lastTime = 0;
    
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int team = Integer.parseInt(st.nextToken());
      String[] time = st.nextToken().split(":");
      int curTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

      if (score[0] > score[1]) {
        count[0] += curTime - lastTime;
      }
      else if (score[0] < score[1]) {
        count[1] += curTime - lastTime;
      }
      
      score[team - 1]++;
      lastTime = curTime;
    }

    if (score[0] > score[1]) {
      count[0] += 48 * 60 - lastTime;
    }
    else if (score[0] < score[1]) {
      count[1] += 48 * 60 - lastTime;
    }

    for (int i = 0; i < 2; i++) {
      System.out.printf("%02d:%02d\n", count[i] / 60, count[i] % 60);
    }
  }
}