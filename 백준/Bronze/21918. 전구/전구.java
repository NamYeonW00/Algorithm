import java.io.*;
import java.util.*;

public class Main{
  static int[] light;
  
  static void command1(int i, int x) {
    light[i - 1] = x;
  }

  static void command2(int l, int r) {
    for(int i = l - 1; i < r; i++) {
      if (light[i] == 0) {
        light[i] = 1;
      }
      else {
        light[i] = 0;
      }
    }
  }

  static void command3(int l, int r) {
    for(int i = l - 1; i < r; i++) {
      light[i] = 0;
    }
  }

  static void command4(int l, int r) {
    for(int i = l - 1; i < r; i++) {
      light[i] = 1;
    }
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    light = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      light[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (a == 1) {
        command1(b, c);
      }
      else if (a == 2) {
        command2(b, c);
      }
      else if (a == 3) {
        command3(b, c);
      }
      else {
        command4(b, c);
      }
    }

    for (int i = 0; i < N; i++) {
      System.out.print(light[i] + " ");
    }
  }
}