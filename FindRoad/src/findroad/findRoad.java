package findroad;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int x, y;
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class findRoad {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	static int count;
	static int[] dr = {0, -1, 0, 1};  
	static int[] dc = {1, 0, -1, 0};
	
	static void solve(int x, int y) {
			
		Queue<Node> q = new LinkedList<Node>(); 
		q.add(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node d = q.poll();
			
				for(int i=0; i<4; i++) {
				int nr = d.x + dr[i], nc = d.y + dc[i];
				
				
				if(nr < 0 || nr > N-1 || nc < 0 || nc > M-1) continue;
				
				if(visited[nr][nc] || map[nr][nc] == 0) continue;
				
				
				q.add(new Node(nr, nc));
				
				map[nr][nc] = 	map[d.x][d.y] + 1;
				
				visited[nr][nc] = true;
				
				}	
			}
	}
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int [N][M];
		visited = new boolean [N][M];

		for(int i=0; i<N; ++i) {
			String temp = sc.next();
			for(int j=0; j<M;  ++j) {
				map[i][j] = temp.charAt(j) - 48;
			}
		}
		
		solve(0, 0);
		System.out.println(map[N-1][M-1]);
	}
}
