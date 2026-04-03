import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
 
        char [][] chess = new char[N][M];
        for(int i = 0; i < N; i++) {
        	String line = br.readLine();
        	for(int j = 0; j < M; j++) {
        		chess[i][j] = line.charAt(j);
        	}
        }
        
        int min = Integer.MAX_VALUE;
        //B시작, W시작
        for(int x = 0; x <= N-8; x++) {
        	for(int y = 0; y <= M-8; y++) {
        		int countW = 0;
        		int countB = 0;
        		
        		for(int i = 0; i < 8; i++) {
        			for(int j = 0; j < 8; j++) {
        				if((i+j) % 2 == 0) {
        					if(chess[x+i][y+j] != 'W')countW++;
        					if(chess[x+i][y+j] != 'B')countB++;
        				}else {
        					if(chess[x+i][y+j] != 'B')countW++;
        					if(chess[x+i][y+j] != 'W')countB++;
        				}
        			}
        		}
        		min = Math.min(min, Math.min(countW, countB));
        	}
        }
        System.out.println(min);
    }
}