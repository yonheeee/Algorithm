import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] sel;
	static int min;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		sel = new int[N];
		min = Integer.MAX_VALUE;
		perm(0);
	}
	
	private static void perm(int idx) {
		if(idx == N) {
			for(int i = 0; i < N; i++) {
				System.out.print(sel[i]);
			}
			System.exit(0);
		}
		
		for(int i = 1; i <= 3; i++) {
			
			sel[idx] = i;
			if(Check(idx)) {
				perm(idx+1);
			}
			
		}
	}

	private static boolean Check(int idx) {//idx는 현재까지 만든 idx수
		//지금까지 만든 idx의 절반 길이만큼(idx+1)/2
		for(int i = 1; i <= (idx+1)/2 ; i++) {//배열의 길이
			boolean same = true;
			for(int j = 0; j < i; j++) {//배열 길이 안에서 몇번쨰
				if(sel[idx-j] != sel[idx-i-j]) {
					same = false;
					break;
				}
			}
			if(same) return false;
		}
		return true;
	}


}

