import java.util.*;

public class Main {
  static int[] A;
  static int N;
  
  static boolean search(int target) {
    int start = 0;
    int end = N - 1;
    
    while (start <= end) {
      int mid = (start + end) / 2;

      if (A[mid] == target)
        return true;
      else if (A[mid] < target)
        start = mid + 1;
      else
        end = mid - 1;
    }

    return false;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    N = sc.nextInt();
    A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }

    Arrays.sort(A);
    
    int M = sc.nextInt();
    int[] nums = new int[M];
    for (int i = 0; i < M; i++) {
      nums[i] = sc.nextInt();
    }

    for (int i = 0; i < M; i++) {
      if (search(nums[i]))
        System.out.println("1");
      else
        System.out.println("0");
    }
  }
}