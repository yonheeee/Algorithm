
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] ladder;
	static int N = 100;

	static int sr,sc;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			
            br.readLine();      
    		sr = sc = -1; 
            ladder = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				 for(int j = 0; j < N; j++) {
					 ladder[i][j] = Integer.parseInt(st.nextToken());
					 if(ladder[i][j] == 2) {sr = i; sc = j;}
				 }
				 
			}
			
			while(sr > 0) {
				if((sc - 1) >= 0 && ladder[sr][sc-1] == 1) {
					while((sc - 1) >= 0 && ladder[sr][sc-1] == 1) {
						sc--;
					}
					sr--;
				}
				else if((sc + 1) < N && ladder[sr][sc+1] == 1) {
					while((sc + 1) <N && ladder[sr][sc+1] == 1) {
						sc++;
					}
					sr--;
				}
				else {
					sr--;
				}
			}
			
			System.out.println("#"+tc+" "+sc);
			
		}

	}

}
