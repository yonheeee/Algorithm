import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] board;
	static int N;
	static int answer;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		board = new boolean[N][N];
		dfs(0);
		
		System.out.println(answer);
		
	}
	
	private static void dfs(int row) {
		if(row == N) {
			answer++;
			return;
		}
		
		for(int col = 0; col < N; col++) {
			if(checkRow(row) && checkCol(col) && checkDiag(row, col)) {
				board[row][col] = true;
				dfs(row+1);
				board[row][col] = false;
			}
		}
	}

	private static boolean checkDiag(int row, int col) {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j]) {
					if(Math.abs(row - i) == Math.abs(col - j)) return false; 
					break;
				}
			}
		}
		return true;
	}

	private static boolean checkCol(int col) {
		for(int i = 0; i < N; i++) {
			if(board[i][col]) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkRow(int row) {
		for(int i = 0; i < N; i++) {
			if(board[row][i]) {
				return false;
			}
		}
		return true;
	}

}
