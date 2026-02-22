import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,E;
	static ArrayList<Node>[] list;
	static int INF = 2000000;
	static int u,v;
	static int answer;
	
	static class Node implements Comparable<Node>{
		int end,cost;
		
		Node(int end, int cost){
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		

		
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a,c));
		}
		
		st = new StringTokenizer(br.readLine());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		int[] from1 = dikstra(1);
		int[] from2 = dikstra(u);
		int[] from3 = dikstra(v);
		
		//INF 구간 체크해서 불가능이면 path를 INF로 만듦
		//INF채운 후 마지막 비교하면 도달 불가로 큰 수 출력 가능성으로 틀렸다고 나옴
		int path1 = INF;
		if(from1[u] < INF && from2[v] < INF && from3[N] < INF) {
		    path1 = from1[u] + from2[v] + from3[N];
		}

		int path2 = INF;
		if(from1[v] < INF && from3[u] < INF && from2[N] < INF) {
		    path2 = from1[v] + from3[u] + from2[N];
		}

		
		int answer = Math.min(path1, path2);

		if(answer >= INF) System.out.println("-1");
		else System.out.println(answer);
	}

	private static int[] dikstra(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0; 
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.cost != dist[cur.end]) continue;
			
			for(Node next : list[cur.end]) {
				int nd = cur.cost + next.cost;
				
				if(nd < dist[next.end]) {
					dist[next.end] = nd;
					pq.add(new Node(next.end, nd));
				}
			}
		}
		return dist;
		
	}

}
