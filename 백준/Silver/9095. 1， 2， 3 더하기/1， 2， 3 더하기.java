import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[n+1];
			
			if(n == 1) {
				System.out.println("1");
				continue;
			}
			
			if(n == 2) {
				System.out.println("2");
				continue;
			}
			
			if(n == 3) {
				System.out.println("4");
				continue;
			}
			
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for(int i = 4; i <= n; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3]; 
			}
			
			System.out.println(dp[n]);
		}
    }
}