import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    StringBuffer sb = new StringBuffer();
    Stack<Integer> stack = new Stack<>();
    int num = 1;
    for (int i = 0; i < n; i++) {
      if (arr[i] >= num) {
        while (arr[i] >= num) {
          stack.push(num++);
          sb.append("+\n");
        }
        stack.pop();
        sb.append("-\n");
      }
      else {
        if (arr[i] == stack.peek()) {
          stack.pop();
          sb.append("-\n");
        }
        else {
          System.out.println("NO");
          return;
        }
      }
    }

    System.out.print(sb.toString());
    return;
  }
}