import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);

    String N = sc.next();

    int[] count = new int[10];
    
    for (int i = 0; i < N.length(); i++) {
      int num = N.charAt(i) - '0';
      count[num]++;
    }

    count[6] = (count[6] + count[9] + 1) / 2;
    count[9] = 0;

    int max = count[0];
    for (int i = 1; i < count.length; i++) {
      if (max < count[i])
        max = count[i];
    }

    System.out.println(max);
  }
}