import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	/*
	 * MST프림(프림은 음수도 가능)
	 * 모든 그래프를 연결하는 최소의 값
	 * 모든 것을 최소로 연결
	 * minEdge : 정점에서 정점을 붙일 수 있는 최소 비용
	 * picked : 정점 수 증가
	 * 
	 * 무방향 그래프 
	 * */
	
	static int V,E;
	static int A,B,C;
	
	static class Edge implements Comparable<Edge>{
		int to,w;
		
		Edge(int to,int w){
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	
	static int INF = Integer.MAX_VALUE;
	static ArrayList<Edge>[] adj;
	static int[] minEdge;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		minEdge = new int[V+1];
		Arrays.fill(minEdge, INF);
		visited = new boolean[V+1];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			adj[A].add(new Edge(B, C));
			adj[B].add(new Edge(A,C));
		}
		
		long answer = isPrime();
		System.out.println(answer);
		
	}

	private static long isPrime() {
		 PriorityQueue<Edge> pq = new PriorityQueue<>();
		 minEdge[1] = 0;
		 pq.offer(new Edge(1, 0));

		 long total = 0;
		 int picked = 0;
		 
		 while(!pq.isEmpty() && picked < V) {
			 Edge cur = pq.poll();
			 
			 if(visited[cur.to])continue;
			 visited[cur.to] = true;
			 
			 total += cur.w;
			 picked++;
			 
			 for(Edge next : adj[cur.to]) {
				 if(!visited[next.to] && next.w < minEdge[next.to] ) {
					 minEdge[next.to] = next.w;
					 pq.offer(new Edge(next.to,next.w));
				 }
			 }
			 
		 }
		 return total;
		
	}

}
