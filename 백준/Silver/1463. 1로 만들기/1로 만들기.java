
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/* 연산을 사용하는 횟수의 최솟값 Math.min
 * 1 -> 3 -> 2순서
 * */
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		int[] dp = new int[X+1];
		dp[1] = 0;
		
		for(int i = 2; i <= X; i++) {
			dp[i] = dp[i-1] + 1;
			
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i/3] + 1 , dp[i]);
			}
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i/2] + 1 , dp[i]);
			}
		}
		System.out.println(dp[X]);
	}
}
