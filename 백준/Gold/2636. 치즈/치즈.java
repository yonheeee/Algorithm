/* 백준 2636 치즈
 * 치즈에는 하나 이상의 구멍, 한 시간 지나면 녹아 없어짐
 * 녹는데 걸리는 시간, 녹기 한 시간전 남아있는 치즈 조각 칸의 수
 * 가장자리(0에 맞닫아 있는 1)
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H,W;
	static int[][] map;
	
	static class Node{
		int r, c;
		
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] visited;
	static ArrayList<Node> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
	

        map = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;  //시간
        int lastcnt = 0;  //사라지기 전 치즈수

        while(true){
            //남아있는 치즈수 세기
            int cheese = countCheese();
            
            if(cheese == 0) break;
            
            //마지막 전에 치즈 수가 lastcnt에 들어감
            lastcnt = cheese;
            bfs(0,0);
            time++;
            
        }

        System.out.println(time);
        System.out.println(lastcnt);
		
	}

    //남은 치즈 수 세기
    private static int countCheese(){
        int cnt = 0;

        for(int i = 0; i < H ; i++){
            for(int j = 0; j < W; j++){
                if(map[i][j] == 1){
                    cnt++;
                }
            }
        }

        return cnt;
    }

	//모두 녹아서 없어진 시간, 모두 녹기 전 남아있는 치즈 수
	private static void bfs(int r, int c) {
		Queue<Node> q = new ArrayDeque<>();
        visited = new boolean[H][W];
		list = new ArrayList<>(); 

		q.add(new Node(r,c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr >= H || nr < 0 || nc >= W || nc < 0)continue;
				if(visited[nr][nc])continue;
			
                //바깐 공기면 계속 탐색
				if(map[nr][nc] == 0) {
					visited[nr][nc] = true;
                    q.add(new Node(nr, nc));
				}

                //바깥 공기와 맞닿은 치즈면 이번 시간에 녹일 목록에 추가
                else if(map[nr][nc] == 1){
                    visited[nr][nc] = true;
                    list.add(new Node(nr, nc));
                }
			}
		}

        //한번에 없애야함
        for(int i = 0; i < list.size(); i++){
            Node cur = list.get(i);
            map[cur.r][cur.c] = 0;
        }
	}
}
