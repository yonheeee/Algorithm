/*
 * 바이러스 처음 모두 비활성
 * M개 활성 상태 변경
 * 0은 빈칸, 1은 벽, 2는 비활성 바이러스
 * 모든 바이러스 퍼지는 최소시간, 퍼뜨릴 수 없는 경우 -1
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] ground;
	static int answer;
	static class Node{
		int r,c,v;
		
		Node(int r, int c,int v){
			this.r = r;
			this.c = c;
			this.v = v;
		}
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static ArrayList<Node> virus = new ArrayList<>();
	static int[] sel;
	static int min;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ground = new int[N][N];
		boolean empty = false; 
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N;j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
				if(ground[i][j] == 2) {
					virus.add(new Node(i, j,2));
				}
				if(ground[i][j] == 0) empty = true; 
			}
		}
		//0안 경우가 없었음
		if(!empty) {  
			System.out.println(0);
			return;
		}
		
		sel = new int[M];
		min = -1;
		active(0,0);
		System.out.println(min);
	}
	
	//-1 return
	//최대값 -1이 아니면 min값이 -1이면 초기화
	//-1이 아니라면 둘 중 작은거
	private static void active(int idx, int start) {
		if(idx == M) {
			int answer = bfs(sel);
			if(answer == -1) {
				return;
			}
			if(min == -1) {
				min = answer-2;
			}else {
				min = Math.min(min, answer-2);
			}
			
			return;
		}
		
		for(int i = start; i < virus.size(); i++) {
			sel[idx] = i;
			active(idx+1, i+1);
		}
	}
	
	private static int bfs(int[] sel) {
		Queue<Node> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		int[][] tground = new int[N][N];
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0;  j < N; j++) {
				tground[i][j] = ground[i][j];

			}
		}
		
		for(int i = 0; i < sel.length; i++) {
			q.add(new Node(virus.get(sel[i]).r, virus.get(sel[i]).c, virus.get(sel[i]).v));
			visited[virus.get(sel[i]).r][virus.get(sel[i]).c] = true;
		}
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			tground[cur.r][cur.c] = cur.v;
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr >= N || nr < 0 || nc >= N || nc < 0)continue;
				if(tground[nr][nc] == 1 || visited[nr][nc])continue;
			
				q.add(new Node(nr,nc,cur.v+1));
				visited[nr][nc] = true;
			}
		}
	
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(ground[i][j] == 0 && tground[i][j] == 0) {
					return -1;
				}
				
				if(ground[i][j] == 0 && tground[i][j] > max) {
					max = tground[i][j];
				}
			
			}
		}
		if (max == Integer.MIN_VALUE) return 2;
		return max;
	}

}
