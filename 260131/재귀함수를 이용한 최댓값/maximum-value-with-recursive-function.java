import java.util.Scanner;
public class Main {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = MAXIMUM(n - 1);
        System.out.println(result);
    }

    private static int MAXIMUM(int idx) {
        if (idx == 0) {
            return arr[0];
        }

        int prevMax = MAXIMUM(idx - 1);

        return Math.max(prevMax, arr[idx]);
    }

    

}