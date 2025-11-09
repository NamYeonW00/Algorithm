import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    Arrays.sort(arr);
    
    int x = sc.nextInt();

    int count = 0;
    int left = 0;
    int right = n - 1;
    while (left < right) {
      int sum = arr[left] + arr[right];
      if (x == sum) {
        count++;
        left++;
        right--;
      }
      else if (x > sum)
        left++;
      else
        right--;
    }
    
    System.out.println(count);
  }
}