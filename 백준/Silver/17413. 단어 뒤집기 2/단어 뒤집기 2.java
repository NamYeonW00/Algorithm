import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringBuilder sb = new StringBuilder();

    Stack<Character> stack = new Stack<>();
    boolean tag = false;
    for(int i = 0 ; i < str.length(); i++) {
      char c = str.charAt(i);

      if (c == ' ') {
        while(!stack.isEmpty()) {
          sb.append(stack.pop());
        }
        sb.append(c);
        continue;
      }
      
      if (c == '<') {
        while(!stack.isEmpty()) {
          sb.append(stack.pop());
        }
        sb.append(c);
        tag = true;
      }
      else if (c == '>') {
        sb.append(c);
        tag = false;
      }
      else {
        if (tag)
          sb.append(c);
        else {
          stack.push(c);
        }
      }
    }

    while(!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    System.out.println(sb.toString());
  }
}