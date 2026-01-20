import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String str = br.readLine();
    String[] arr = str.split("\\.", -1);
    String answer = "";

    for (int i = 0; i < arr.length; i++) {
      int len = arr[i].length();
      
      while (len >= 4) {
        answer += "AAAA";
        len -= 4;
      }
      
      while (len >= 2) {
        answer += "BB";
        len -= 2;
      }
      
      if (len == 1) {
        System.out.println("-1");
        return;
      }

      if (i != arr.length - 1) {
        answer += ".";
      }
    }

    System.out.println(answer);
  }
}