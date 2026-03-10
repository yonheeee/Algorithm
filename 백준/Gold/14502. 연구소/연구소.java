import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static int ans;

	static class Node{
		int r,c;
		
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int[] px = new int[3];
	static int[] py = new int[3];
	
	static ArrayList<Node> virus = new ArrayList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus.add(new Node(i,j));
				}
				
			}
		}
		ans = 0;
		check(0,0);
		System.out.println(ans);
	}

	private static void check(int idx, int depth) {
		if(depth == 3) {
			int[][] tmap = new int[N][M];
			int count = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					tmap[i][j] = map[i][j];
				}
			}
			
			for(int i = 0; i <depth; i++) {
					tmap[px[i]][py[i]] = 1;
			}
			
			bfs(tmap);	
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(tmap[i][j] == 0) {
						count++;
					}
				}
			}
			
			ans = Math.max(ans, count);
			return;
			
		}
		
		int total = N*M;
		if(total - idx < 3 - depth)return;
		
		for(int t = idx ; t < total; t++) {
			int cx = t / M;
			int cy = t % M;
			
			if(iswall(cx,cy)) continue;
		
			px[depth] = cx;
			py[depth] = cy;
			
			check(t+1,depth+1);
		}
		
	}

	private static boolean iswall(int cx, int cy) {
		if(map[cx][cy] != 0) {
			return true;
		}
		return false;
	}

	private static void bfs(int[][] tmap) {
		Queue<Node> q = new ArrayDeque<>();
		
		for(int i = 0; i < virus.size(); i++) {
			Node c = virus.get(i);
			q.add(new Node(c.r,c.c));

		}

		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr >= N || nr < 0 || nc >= M || nc < 0)continue;
				if(tmap[nr][nc] != 0)continue;
				
				tmap[nr][nc] = 2;
				q.add(new Node(nr,nc));
			}
		}

		
	}

}
