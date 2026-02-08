
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dist;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Node{
		int x,y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		visited = new boolean[N][M];
		dist = new int[N][M];
		bfs(0,0);
		
		System.out.println(dist[N-1][M-1]);
	}
	
	
	
	private static void bfs(int sx,int sy) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(sx,sy));
		visited[sy][sx] = true;
		dist[sy][sx] = 1;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int d = 0; d <4;d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				
				if(visited[ny][nx] || map[ny][nx] == 0)continue;
			
				visited[ny][nx] = true;
				dist[ny][nx] = dist[cur.y][cur.x] + 1;
				q.add(new Node(nx,ny));
			}
		}
	}

}
