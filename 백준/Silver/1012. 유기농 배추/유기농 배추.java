import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M,N,K;
	static int x;
	static int y;
	static int[][] farm;
	static boolean[][] visited;
	static int count;
	static class Node{
		int r,c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //가로
			N = Integer.parseInt(st.nextToken()); //세로
			K = Integer.parseInt(st.nextToken()); 
			
			visited = new boolean[N][M];
			farm = new int[N][M];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				farm[y][x]= 1;
				//0으로 자동 초기화
			}
			count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(farm[i][j] == 1 && !visited[i][j]) {
						bfs(i,j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	private static void bfs(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dy[d];
				int nc = cur.c + dx[d];
				
				if(nr >= N || nc >= M || nr <0 || nc < 0)continue;
				if(visited[nr][nc]) continue;
				if(farm[nr][nc] == 0) continue;
				
				q.add(new Node(nr,nc));
				visited[nr][nc] = true; 
			}
		}
	}

}
