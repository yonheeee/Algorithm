
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int N = 16;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	static int bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (visited[nx][ny])
					continue;
				if (map[nx][ny] == 1)
					continue;

				if (map[nx][ny] == 3)
					return 1;
				
				visited[nx][ny] = true;
				q.add(new Node(nx, ny));
			}

		}
		return 0;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine().trim());

			int r = -1;
			int c = -1;

			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				String line = br.readLine().trim();

				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
					visited[i][j] = false;

					if (map[i][j] == 2) {
						r = i;
						c = j;
					}
				}
			}

			int ans = bfs(r, c);
			sb.append("#").append(t).append(" ").append(ans).append("\n");

		}
		
		System.out.println(sb.toString());
	}

}
