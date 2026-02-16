import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String num = br.readLine();
    char[] numArr = num.toCharArray();

    int sum = 0;
    for (char c : numArr) {
      sum += c - '0';
    }
    
    System.out.println(sum);
  }
}