import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,H;
	static int[][][] box;
	
	static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};;
	
	static class Node{
		int x,y,z;
		Node(int z,int y,int x){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws Exception{
		//M,N과 쌓아 올려지는 상자수 H
		//익은 토마토에 인접한 상하좌우위아래 익음
		//상하좌우위아래
		//만약 1과 인접한 상화좌우위아래면 0은 -1로
		Queue<Node> q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[H][N][M];
		for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    box[z][y][x] = Integer.parseInt(st.nextToken());
                    if (box[z][y][x] == 1) {
                        q.add(new Node(z, y, x)); //익은 토마토들 전부 시작
                    }
                }
            }
        }
		
		bfs(q);
		
		int max = 1;
		for(int z = 0; z < H; z++) {
			for(int y = 0; y < N; y++) {
				for(int x = 0;x <M;x++) {
					 if (box[z][y][x] == 0) {
	                        System.out.println(-1);
	                        return;
	                    }
	                    max = Math.max(max, box[z][y][x]);
				}
			}
		}
		System.out.println(max - 1);

	}
	
	static void bfs(Queue<Node> q) {
		
		
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int d = 0; d < 6; d++) {
				int nz = cur.z + dz[d];
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				
				if(nz < 0 || ny < 0 || nx < 0 || nz >= H || ny >= N || nx >= M) continue;
				if(box[nz][ny][nx] != 0) continue;
				
				box[nz][ny][nx] = box[cur.z][cur.y][cur.x] + 1;
                q.add(new Node(nz, ny, nx));
				
			}
		}
		
	}

}
