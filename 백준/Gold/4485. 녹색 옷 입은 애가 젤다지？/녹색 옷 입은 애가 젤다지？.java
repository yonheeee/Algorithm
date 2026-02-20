import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int money;
	static int[][] map;
	static int[][] best;
	static final int INF = Integer.MAX_VALUE;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Node implements Comparable<Node>{
		int r,c, cost;
		Node(int r, int c, int cost){
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			map = new int[N][N];
			best = new int[N][N];
			for(int i = 0; i < N; i++) {
				Arrays.fill(best[i], INF);
			}
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dikstra();
			System.out.println("Problem "+tc+": "+best[N-1][N-1]);
			tc++;
		}
	}
		
	private static void dikstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		best[0][0] = map[0][0];
		pq.add(new Node(0, 0, best[0][0]));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(cur.cost != best[cur.r][cur.c]) continue;
			
			for(int d = 0; d < 4;d++) {
				int nr = cur.r + dx[d];
				int nc = cur.c + dy[d];
				
				if(nr >= N || nc >= N||nr < 0|| nc < 0)continue;
				int nextcost = cur.cost + map[nr][nc];
				if(nextcost < best[nr][nc]) {
					best[nr][nc] = nextcost;
					pq.offer(new Node(nr, nc, nextcost));
				}
			}
		}
		
		
	}

}
