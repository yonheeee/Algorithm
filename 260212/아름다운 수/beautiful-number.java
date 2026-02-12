
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int answer;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		//1은 1, 2는 22,3은 333
		boolean[] sel = new boolean[N];
		answer = 0;
		Num(0);
		System.out.println(answer);

	}
	
	private static void Num(int idx) {
		if(idx == N) {//자리수가 차는 것이 마디
			answer++;
			return;
		}
		
		for(int i = 1; i <= 3; i++) {
			if(idx + i <= N) {
				Num(idx+i);
			}
		}
		//자리수 남은 것을 확인하는 것을 가지
		
	}

}
