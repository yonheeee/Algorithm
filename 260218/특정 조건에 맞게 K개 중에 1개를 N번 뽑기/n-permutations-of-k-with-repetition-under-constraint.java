

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//중복 O, 같은 숫자 3번은 제외
public class Main {
	static int K,N;
	static int sel[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken()); //1~K이하의 숫자
		N = Integer.parseInt(st.nextToken()); //N개의 숫자
		
		sel = new int[N];
		dfs(0);
	}

	private static void dfs(int idx) {
		if(idx == N) {
			for(int i = 0; i < N; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= K; i++) {
			
			if(idx >= 2 && sel[idx-1] == i && sel[idx-2] == i) continue;
			sel[idx] = i;
			dfs(idx+1);
		}
		
	}
	
	

}
