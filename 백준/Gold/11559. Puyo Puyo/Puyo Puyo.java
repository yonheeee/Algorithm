/*
 * 아래로 떨어짐
 * 4개 이상의 같은 색의 뿌요 한꺼번에 없어짐(1 연쇄적)
 *
 * BFS (주변에 같은 것 있는지 확인)
 * 중력
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int ROW = 12;
	static int COL = 6;
	static int count;
	static boolean[][] visited;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Node{
		int r,c;
		
		Node(int r, int c){
			this.r = r;
			this.c = c;
			
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new char[ROW][COL];
		for(int i = 0; i < ROW; i++) {
			String s = br.readLine();
			for(int j = 0; j < COL; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		count = 0;
		simulate();
		System.out.println(count);
		
	}

	private static void simulate() {
		while(true) {
			visited = new boolean[ROW][COL];
			
			boolean boom = false;
			for(int i = 0; i < ROW; i++) {
				for(int j = 0; j < COL; j++) {
					if(map[i][j] != '.' && !visited[i][j]) {
						if (bfs(i, j)) {
                            boom = true;
                        }
					}
				}
			}
			
			if(!boom)break;
			count++;
			gravity();
		}
		
		
		
	}

	private static void gravity() {
		for(int c = 0; c < COL; c++) {
			Queue<Character> q = new ArrayDeque<>();
			
			for(int r = ROW - 1; r >= 0; r--) {
				if(map[r][c] != '.') {
					q.add(map[r][c]);
					map[r][c] = '.';
				}
			}
			
			int idx = ROW -1;
			while(!q.isEmpty()) {
				map[idx--][c] = q.poll();
			}
		}
		
	}

	private static boolean bfs(int r, int c) {
		Queue<Node> q = new ArrayDeque<>();
		ArrayList<Node> list = new ArrayList<>();
		
		q.add(new Node(r,c));
		visited[r][c] = true;
		list.add(new Node(r,c));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr >= ROW || nr < 0 || nc >= COL || nc < 0|| visited[nr][nc])continue;
				
				if(map[cur.r][cur.c] == map[nr][nc]) {
					q.add(new Node(nr,nc));
					list.add(new Node(nr,nc));
					visited[nr][nc] = true;
				}
			}
		}
		if(list.size() >= 4) {
			for(int i = 0; i < list.size(); i++) {
				map[list.get(i).r][list.get(i).c] = '.';
			}
			return true;
		}
		return false;
	}
}
