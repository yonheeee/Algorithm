
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 1은 집, 2는 치킨집
	 * 최대 M개 고르고
	 * 도시의 치킨 거리 가장 작은(집에서 치킨집 거리)
	 * 
	 * M개 골랐을 때 치킨거리 최솟값
	 * 1의 모든 좌표는 2를 가야함
	 * 순열(중복 없이 2를 뽑음)
	 * idx == M
	 * 그 거리 구함
	 * 거리의 최소
	 *  
	 * */
	
	static int N,M;
	static int[][] ground;
	static boolean[] visited;
	
	static class Node{
		int x,y;
		Node(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Node> chicken = new ArrayList<>();
	static ArrayList<Node> home = new ArrayList<>();
	static int[] sel;
	static int ans;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		ground = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(ground[i][j] == 2) {
					chicken.add(new Node(i,j));
				}
				
				if(ground[i][j] == 1) {
					home.add(new Node(i,j));
				}
			}
		}
		sel = new int[M];
		ans = Integer.MAX_VALUE;
		visited = new boolean[chicken.size()];
		dfs(0,sel,0);
		System.out.println(ans);
		
	}

	private static void dfs(int idx,int[] sel,int start) {
		if(idx == M) {

			int sum = 0;
			for(int i = 0;  i < home.size(); i++) {//집의 모든 좌표
				
			
				int dist = 0;//집마다 dist 갱신
				int min = Integer.MAX_VALUE; //집마다 min 갱신
				
				Node house = home.get(i); //집의 좌표를 얻어냄
				int hx = house.x; 
				int hy = house.y;
				
				for(int j= 0; j < sel.length; j++) {
					Node chic = chicken.get(sel[j]); //sel의 인덱스 순서의 치킨집
					int cx = chic.x;
					int cy = chic.y;
					
					dist = Math.abs(cx - hx) + Math.abs(cy - hy);
					min = Math.min(min, dist);
					//치킨집과 집 거리마다 min 갱신
					
				}
				sum += min;
			}
			ans = Math.min(ans, sum);
			return;
		}
		
		for(int i = start; i < chicken.size(); i++) {
			if(visited[i])continue;
			
			sel[idx] = i;
			visited[i] = true;
			
			dfs(idx+1,sel,i+1);
			visited[i] = false;
		}
		
		
	}
}