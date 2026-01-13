import java.util.Scanner;
class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		
		int[] arr = new int[11];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for (int i = 0; i < num; i++) {
			int n = input.nextInt();
			for (int j = 4; j <= n; j++)
				arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
			System.out.println(arr[n]);
		}
		
		input.close();
	}

}
