/*
 * 선 플레이어 홀수, 후 플레이어 짝수
 * 점 선으로 이어, 사이클 완성 되면 종료
 * 사이클 완성되면 몇 번째 차례에서 완성 되었는지, 사이클 x 0
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	
	static int[] parents;
	
	private static int find(int a) {
		if(parents[a] == a)return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb) return false;
		
		parents[pb] = pa;
		return true;
	}
	
	
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parents = new int[n];
		for(int i = 0; i < n; i++) {
			parents[i] = i;
		}
		
		for(int i = 0; i < m ;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(!union(a,b)) {
				System.out.println(i+1);
				return;
			}
		}
		
		System.out.println('0');
	
		
		
	}

}
