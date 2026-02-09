
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static ArrayList<Integer>[] adj;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 수(양방향)
		V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

		adj = new ArrayList[N + 1];// 상자 만들기
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		}
		
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();

		visited = new boolean[N+1];
		bfs(V);
		System.out.println();
	}
	
	private static void dfs(int cur) {
		visited[cur] = true;
		System.out.print(cur +" ");
		
		for(int next : adj[cur]) {
			if(!visited[next]) 
				dfs(next);
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur+" ");
			
			for(int next : adj[cur]) {
				if(visited[next]) continue;
				visited[next] = true;
				q.add(next);
			}
		}
	
	}
}
