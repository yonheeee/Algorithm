import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] block = new int[N];
        for (int i = 0; i < K; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            // A ~ B인 인덱스에 1을 추가
            // block[A] ~ block[B]
            // ++

            for(int j = A; j <= B; j++){
                block[j]++;
            }


        }
        int max = 0;
        for(int i = 0 ;i < N;i++){
            max = Math.max(block[i],max);
        }
        System.out.println(max);
        // Please write your code here.
    }
}