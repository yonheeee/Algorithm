
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //물건의 개수
		int K = Integer.parseInt(st.nextToken()); //무게
		
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		int[][] dp = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken()); 
		}
		
		
		for(int i = 1; i <= N; i++) {
			for(int w = 1; w <= K; w++) {
				if(weight[i] <= w) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight[i]] + value[i]);
				}else {
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}
}
