/*
 * 둘레로만 다님(시계 방향 or 반시계 중) 최단거리
 * 첫째 수는 상점이 위치한 방향
 * 1은 불로 북쪽, 2는 남쪽, 3은 서쪽, 4는 동쪽
 * 둘째 수는 블록의 북쪽 또는 남쪽에 위치한 왼쪽 경계로부터의 거리
 * 상점이 블록의 동쪽 또는 서쪽에 위치한 경우 블록 위쪽로 부터의 거리
 * (동근 상점 꼭짓점 될 수X)
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int W, H;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		int[] positions = new int[n+1]; 
		
		for(int i = 0; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			positions[i] = getLinearDistance(dir, dist);
		}
		
		int donggeun = positions[n];  
		int total = 0;
		int circum = 2 * (W + H); 
		
		for(int i = 0; i < n; i++) {
			int path1 = Math.abs(donggeun - positions[i]);
			int path2 = circum - path1;
			total += Math.min(path1, path2);
		}
		System.out.println(total);
	}


	private static int getLinearDistance(int dir, int dist) {
		if(dir == 1) return dist; 
		if(dir == 4) return W + dist; 
		if(dir == 2) return W + H + (W - dist); 
		if(dir == 3) return W + H + W + (H - dist); 
		return 0;
	}
}
