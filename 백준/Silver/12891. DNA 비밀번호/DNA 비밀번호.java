import java.io.*;
import java.util.*;

public class Main{
  static int[] count;
  static int[] rule;
  
  static void add(char c) {
    if (c == 'A') {
      count[0]++;
    }
    else if (c == 'C') {
      count[1]++;
    }
    else if (c == 'G') {
      count[2]++;
    }
    else {
      count[3]++;
    }

    return;
  }

  static void remove(char c) {
    if (c == 'A') {
      count[0]--;
    }
    else if (c == 'C') {
      count[1]--;
    }
    else if (c == 'G') {
      count[2]--;
    }
    else {
      count[3]--;
    }

    return;
  }

  static boolean check() {
    for (int i = 0; i < 4; i++) {
      if (rule[i] > count[i]) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int S = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    String line = br.readLine();
    char[] password = new char[S]; 
    for (int i = 0; i < S; i++) {
      password[i] = line.charAt(i);
    }

    st = new StringTokenizer(br.readLine());
    rule = new int[4];
    for (int i = 0; i < 4; i++) {
      rule[i] = Integer.parseInt(st.nextToken());
    }

    int startIdx = 0;
    int lastIdx = P - 1;
    int answer = 0;

    count = new int[4];
    for (int i = startIdx; i <= lastIdx; i++) {
      add(password[i]);
    }
    
    startIdx++;
    lastIdx++;
    
    if (check()) {
      answer++;
    }
    
    while (lastIdx < S) {
      add(password[lastIdx]);
      remove(password[startIdx - 1]);

      if (check()) {
        answer++;
      }

      startIdx++;
      lastIdx++;
    }

    System.out.println(answer);
  }
}