import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int H = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());

    int[][] sky = new int[H][W];

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        sky[i][j] = -1;
      }
    }

    for (int i = 0; i < H; i++) {
      String line = br.readLine();
      for (int j = 0; j < W; j++) {
        char cloud = line.charAt(j);
        if (cloud == 'c') {
          sky[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < H; i++) {
      int count = 0;
      for (int j = 0; j < W; j++) {
        if (sky[i][j] == 0) {
          count = 1;
        }
        else if (count != 0) {
          sky[i][j] = count++;
        }
      }
    }

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        System.out.print(sky[i][j] + " ");
      }
      System.out.println();
    }
  }
}