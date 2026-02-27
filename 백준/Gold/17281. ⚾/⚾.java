

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] ground;
	static int[] sel;
	static boolean[] visited;
	static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		ground = new int[N][9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[9];
		sel = new int[9];
		ans = 0;

		sel[3] = 1;
		visited[0] = true;
		perm(0);

		System.out.println(ans);

	}

	private static void perm(int idx) {
		if (idx == 9) {
			check(sel);
			return;
		}

		if (idx == 3) {
			perm(idx + 1);
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue;

			sel[idx] = arr[i];
			visited[i] = true;

			perm(idx + 1);
			visited[i] = false;
		}

	}

	private static void check(int[] sel) {
		int count = 0;
		int hitter = 0;
		
		for(int i = 0; i < N; i++) {
			int out = 0;
			boolean base1 = false, base2 = false, base3 = false;
			
				while(out < 3) {
					int hit = ground[i][sel[hitter]-1];
					
					if(hit==0) {
						out++;
					}
					else if(hit == 1) {
						if(base3) { count++; base3 = false; }
						if(base2) { base3 = true; base2 = false; }
						if(base1) { base2 = true; base1 = false; }
						base1 = true;
					}
					else if(hit == 2) {
						if(base3) { count++; base3 = false; }
						if(base2) { count++; base2 = false; }
						if(base1) { base3 = true; base1 = false; }
						base2 = true;
					}
					else if(hit == 3) {
						if(base3) { count++; base3 = false; }
						if(base2) { count++; base2 = false; }
						if(base1) { count++; base1 = false; }
						base3 = true;
					}
					else { 
						if(base3) { count++; base3 = false; }
						if(base2) { count++; base2 = false; }
						if(base1) { count++; base1 = false; }
						count++; 
					}
					
					hitter++;
					if(hitter == 9) hitter = 0;
				}
				
			}
			ans = Math.max(count,ans);
			
		}
}
