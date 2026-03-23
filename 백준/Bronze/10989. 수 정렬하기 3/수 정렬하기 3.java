import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10001];
        
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(br.readLine());
            arr[a] += 1;
        }

        for(int i = 1; i < arr.length; i++) {
        	if(arr[i] != 0) {
        		for(int j = 0; j < arr[i]; j++) {
        			sb.append(i).append("\n");
        		}
        	}
        }
        System.out.println(sb);
    }
}