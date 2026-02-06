

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		int[] sel = new int[M];
		
		powerset(0,0,sel,arr);

	}
	
	private static void powerset(int start, int idx, int sel[],int arr[]) {
		if(idx == M) {
			for(int k = 0; k < M;k++) {
				System.out.print(sel[k]+" ");
			}System.out.println();
			return ;
		}
		
		for(int i = start; i < N; i++) {
			sel[idx] = arr[i];
			powerset(i,idx+1,sel,arr);
		}
	}

}
