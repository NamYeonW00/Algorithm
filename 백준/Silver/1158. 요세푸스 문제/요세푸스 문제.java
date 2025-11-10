import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    Queue<Integer> q = new LinkedList<>();
    int[] answer = new int[n];

    for (int i = 1; i <= n; i++)
      q.offer(i);

    int count = 1;
    int index = 0;
    while(!q.isEmpty()) {
      if (count == k) {
        answer[index++] = q.poll();
        count = 1;
        continue;
      }
      int num = q.poll();
      q.offer(num);
      count++;
    }

    System.out.print("<");
    for (int i = 0; i < n - 1; i++) {
      System.out.print(answer[i] + ", "); 
    }
    System.out.println(answer[n -1] + ">");
  }
}