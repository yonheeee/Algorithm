import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/* 
 * x * M 행렬, 0은 이동가능 1은 이동 불가
 * 1,1에서 N,M, 시작과 끝나는 칸 포함 셈, 한 개의 벽 부술 수 있음
 * 붉가능 -1
 * */
public class Main {
    static int N,M;
    static int[][] map;
    
    static class Node{
    	int r,c,cnt,wall;
    	
    	Node(int r, int c,int wall, int cnt){
    		this.r = r;
    		this.c = c;
    		this.cnt = cnt;
    		this.wall = wall;
    	}
    }
    
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());; 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
        	String line = br.readLine();
        	for(int j = 0; j < M; j++) {
        		map[i][j] = line.charAt(j) - '0';
        	}
        }
        
        int ans = bfs();
        System.out.println(ans);
	}

	private static int bfs() {
		//r,c,wall
		boolean[][][] visited = new boolean[N][M][2];
		Queue<Node> q = new ArrayDeque<>();
		
		q.add(new Node(0,0,0,1));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.r == N-1 && cur.c == M-1) return cur.cnt;
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr >= N || nr < 0 || nc >= M || nc < 0)continue;
				
				if(map[nr][nc] == 0 && !visited[nr][nc][cur.wall]) {
					visited[nr][nc][cur.wall] = true;
					q.add(new Node(nr,nc,cur.wall,cur.cnt+1));
				}
				
				if(cur.wall == 0 && map[nr][nc] == 1 && !visited[nr][nc][1]) {
					visited[nr][nc][1] = true;
					q.add(new Node(nr,nc,1,cur.cnt+1));
				}
		
			}
		}
		
		return -1;
	}
        
}