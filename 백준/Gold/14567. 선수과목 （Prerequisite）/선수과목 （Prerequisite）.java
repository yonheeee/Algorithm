
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	
	static ArrayList<Integer>[] subject;
	static int[] indegree;
	static int[] arr;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		subject = new ArrayList[N+1];
		indegree = new int[N+1];
		arr = new int[N+1];
		
		for(int i = 1; i < N+1; i++) {
			subject[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			subject[a].add(b);
			indegree[b]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
	
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
				arr[i] = 1;
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();

			
			for(int next : subject[cur]) {
				arr[next] = Math.max(arr[next], arr[cur]+1);
				
				indegree[next]--;
				if(indegree[next]== 0)
					q.offer(next);
			}
		}
		
		StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) 
        	sb.append(arr[i]).append(" ");
        System.out.println(sb);
	}

}
