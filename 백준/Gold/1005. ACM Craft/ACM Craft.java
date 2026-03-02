
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] D = new int[N+1]; 
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
			}
			
			ArrayList<Integer>[] adj = new ArrayList[N+1];
			for(int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}
			int[] indegree = new int[N+1];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				adj[a].add(b);
				indegree[b]++;
			}
			
			int W = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];

			Queue<Integer> q = new ArrayDeque<>();
			
			for(int i = 1; i <= N; i++) {
				if(indegree[i] == 0) {
					q.offer(i);
					arr[i] = D[i];
				}
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for(int next : adj[cur]) {
					//다음 노드는 현재시간 + 다음으로 완성될 시간
					arr[next] = Math.max(arr[next], arr[cur] + D[next]);
					
					indegree[next]--;
					if(indegree[next] == 0) {
						q.offer(next);
					}
				}
			}
		
			
			System.out.println(arr[W]);
		}
	}

}
