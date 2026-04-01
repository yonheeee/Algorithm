import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] a;
    static long[] dist;

    static class Node implements Comparable<Node> {
        int to;
        long cost;

        Node(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            adj[from].add(new Node(to, cost));
            adj[to].add(new Node(from, cost));
        }

        long ans = dijkstra();
        if (ans == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    private static long dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0] = 0;
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.to] < cur.cost) continue;

            for (Node next : adj[cur.to]) {
                if (next.to != N - 1 && a[next.to] == 1) continue;

                long nextCost = dist[cur.to] + next.cost;
                if (dist[next.to] > nextCost) {
                    dist[next.to] = nextCost;
                    pq.add(new Node(next.to, nextCost));
                }
            }
        }
        return dist[N - 1];
    }
}