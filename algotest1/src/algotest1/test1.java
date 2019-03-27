package algotest1;

import java.util.Scanner;

public class test1 {
	static Character[][] map;
	static boolean[] visited;
	static int N, M;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};
	static int ans = 0;
	
	static void solve(int x, int y, int cnt) {
		
		ans = Math.max(ans, cnt);
		
		visited[map[x][y]] = true;
		
		for(int i=0; i<4; ++i) {
			int nr = x + dr[i], nc = y + dc[i];
			
			
			if(nr < 0 || nr > N-1 || nc < 0 || nc > M-1) continue;
			
			if(visited[map[nr][nc]]) continue;
		
			solve(nr, nc, cnt+1);
		}
		
		--cnt;
		visited[map[x][y]] = false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new Character[N][M];
		visited = new boolean[1000];
		
		String str = null;
		
		
		for(int i=0; i<N; ++i) {
			str = sc.next();
			for(int j=0; j<M; ++j) {
				map[i][j] = str.charAt(j);
				if(j == M-1) str = null;
			}
		}
		solve(0,0,1);
		System.out.println(ans);

	}
}