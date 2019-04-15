package algotest1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bingha {
	static int N, M;
	static int[][] map;
	static int[][] temp;
	static int[][] visi;
	
	static boolean[][] visited;
	static boolean checker = false;
	static int count = 0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int ans = 0;
	static class Node {
		int a,b;
		Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	static void checkBoard(int x, int y) {
		visi[x][y] = 1;
			
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx < 0 || nx > N-1 || ny < 0 || ny > M-1 || visi[nx][ny] == 1) continue;
				if(visi[nx][ny] == 0 && map[nx][ny] != 0) {
					checkBoard(nx, ny);
				} 
			}
			
	}
	
	static void bfs(int x, int y) {
		int a = x;
		int b = y;
			do {
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(a, b));
			visited[a][b] = true;

			while(!q.isEmpty()) {
				Node p = q.poll();
				int currx = p.a;
				int curry = p.b;
				int zCount = 0;

				if(map[currx][curry] != 0) {
					for(int i=0; i<4; i++) {
						if(currx + dx[i] < 0 || curry + dy[i] < 0 || currx + dx[i] > N-1 || curry + dy[i] > M-1) continue;
						if(map[currx + dx[i]][curry + dy[i]] == 0) {
							zCount++;
						}
					}
						temp[currx][curry] = map[currx][curry]-zCount;
						if(temp[currx][curry] < 0) temp[currx][curry] = 0;
					}
				


				for(int i=0; i<4; i++) {
					int curx = currx + dx[i];
					int cury = curry + dy[i];
					if(curx < 0 || curx > N-1 || cury < 0 || cury > M-1) continue;
					if(visited[curx][cury]) continue;
					q.add(new Node(curx, cury));
					visited[curx][cury] = true;
				}
			}

			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					map[i][j] = temp[i][j];
					visited[i][j] = false;
				}
			}
			
			ans = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] != 0 && visi[i][j] == 0) {
						checkBoard(i, j);
						ans++;
					} 
				}
			}	
			
//			for(int i=0; i<N; i++) {
//				System.out.println("");
//				for(int j=0; j<M; j++) {
//					System.out.print(map[i][j] +" ");
//				}
//			}
			
			clearVisi();
			if(isClear()) {
				count = 0; 
				break;
			}
	
			count++;
		}while(ans < 2);
	}
	
	static void clearVisi() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visi[i][j] = 0;
			}
		}
	}
	
	static boolean isAllNumber() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	static boolean isClear() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visi[i][j] != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		temp = new int[N][M];
		visited = new boolean[N][M];
		visi = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		if(isClear() || isAllNumber()) {
			System.out.println(0);
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0 && visi[i][j] == 0) {
					checkBoard(i, j);
					ans++;
				} 
			}
		}
		
		if(ans >= 2) {
			System.out.println(0);
			return;
		}
		
		clearVisi();
		
		ans=0;
		bfs(0,0);
		
		System.out.println(count);
	}

}
