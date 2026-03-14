
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
		
			int[] x = new int[M];
			int[] y = new int[M];
			int[] stone = new int[M];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				x[i] = Integer.parseInt(st.nextToken())-1;
				y[i] = Integer.parseInt(st.nextToken())-1;
				stone[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] map = new int[N][N];
			for(int i = 0; i< N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = 0;
				}
			}
			
			int[] dr = {-1,1,0,0,1,1,-1,-1};
			int[] dc = {0,0,-1,1,-1,1,-1,1};
			
			int mid1 = N / 2 -1;
			int mid2 = N / 2;
			//흑돌 1. 백돌 2
			map[mid1][mid1] = 2;
			map[mid2][mid1] = 1;
			map[mid1][mid2] = 1;
			map[mid2][mid2] = 2;
			
			for(int i = 0; i < M; i++) {
				int r = x[i];
				int c = y[i];
				int mystone = stone[i];
				
				map[r][c] = mystone;
				int enemy = (mystone == 1)? 2: 1;
				
				for(int d = 0; d < 8; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr >= N || nr < 0 || nc >= N || nc < 0 || map[nr][nc] != enemy)continue;
					
					while(check(nr,nc) && map[nr][nc] == enemy) {
						nr += dr[d];
						nc += dc[d];
					}
					
					if(check(nr, nc) && map[nr][nc] == mystone) {
						int tx = r + dr[d];
						int ty = c + dc[d];
						
						while(map[tx][ty] == enemy) {
							map[tx][ty] = mystone;
							tx += dr[d];
							ty += dc[d];
						}
					}
				}
			}
			int white = 0;
			int black = 0;
			
			for(int i = 0; i < N;i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1) {
						black++;
					} else if(map[i][j] == 2) {
						white++;
					}
				}
			}
			System.out.println("#"+tc+" "+black+" "+white);
									
		}
	}

	private static boolean check(int nr, int nc) {
		if(nr < N && nr >= 0 && nc < N && nc >= 0 ) {
			return true;
		}
		return false;
	}

}
