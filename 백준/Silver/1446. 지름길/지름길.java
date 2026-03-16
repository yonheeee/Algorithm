import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, D;
    static final int INF = 100000;

    static class Node implements Comparable<Node> {
        int to, w;

        Node(int to, int w){
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }

    static List<Node> list[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        list = new ArrayList[D+1];
        for(int i = 0; i <= D; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < D; i++) {
            list[i].add(new Node(i + 1, 1));
        }
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(to > D) continue;

            list[from].add(new Node(to, w));
        }

        int ans = dijkstra();
        System.out.println(ans);
        
    }

    public static int dijkstra() {
        int[] dist = new int[D+1];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.to] < now.w) continue;

            for(Node next : list[now.to]){
                if(dist[next.to] > dist[now.to] + next.w) {
                    dist[next.to] = dist[now.to] + next.w;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        return dist[D];
    }
}