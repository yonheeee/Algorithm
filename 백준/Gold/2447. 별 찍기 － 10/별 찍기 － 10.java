
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	static char[][] star;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		star = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				star[i][j] = '*';
			}
		}

		star(0, 0, n);

		StringBuilder sb = new StringBuilder(n * (n + 1));
        for (int i = 0; i < n; i++) {
            sb.append(star[i]); 
            sb.append('\n');
        }
        System.out.print(sb);

	}

	private static void star(int x,int y, int n) {
		if(n == 1) return;
		
		int block = n /3;
		
		for(int i = x + block; i < x + 2*block; i++) {
			for(int j = y + block; j < y +2*block; j++) {
				star[i][j] = ' ';
			}
		}
		
		for(int dx = 0; dx <3 ; dx++) {
			for(int dy = 0; dy <3; dy++) {
				if(dx == 1 && dy == 1)continue;
				star(x + dx * block, y +dy*block,block);
			}
		}
	}
}
