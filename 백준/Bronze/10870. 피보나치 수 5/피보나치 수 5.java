
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(fin(n));
	
	}
	
	public static int fin(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		int a = 0;
		int b = 1;
		
		for(int i = 2; i <= n; i++) {
			int next = a+b;
			a = b;
			b = next;
		}
		return b;
	}
}
