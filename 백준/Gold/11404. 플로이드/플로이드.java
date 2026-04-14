/*
 * 플로이드 워샬 공부
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] dist;
	static final int INF = 1000000000;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		n = Integer.parseInt(br.readLine()); //노드수
		m = Integer.parseInt(br.readLine()); //간선수
		
		dist = new int[n+1][n+1];
		
		//dist는 최소 길이를 넣는 배열
		//만약 i == j라는 건 자기 자신인 거니까 0
		//다른 것들은 모르니까 INF 초기화
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) dist[i][j] = 0;
				else dist[i][j] = INF;
			}
		}
		
		//a -> b 가는 비용 c
		//여러 간선이 있을 수 있음 -> 최솟값 넣음
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			dist[a][b] = Math.min(dist[a][b], c);
		}
		
		//만약에 i -> j 보다
		//i -> k -> j가 더 짧다면 갱신
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(dist[i][j] == INF)System.out.print(0 +" ");
				else System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}

