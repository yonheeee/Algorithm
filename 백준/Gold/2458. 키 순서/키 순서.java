
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	//플로이드 워샬

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] graph = new boolean[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = true;
		}
		
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(graph[i][k] && graph[k][j]) {
						graph[i][j] = true;
					}
				}
			}
		}
		
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			int count = 0;
			for(int j = 1; j <= N; j++) {
				if(i == j)continue;
				if(graph[i][j] || graph[j][i])count++;
				
			}
			if(count == N-1)ans++;
		}
		
		System.out.println(ans);
	}

}
