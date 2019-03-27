package algotest1;

import java.util.Scanner;

public class testfortest {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int cnt;
	static int[] dy = {1, 0, 1};
	static int[] dx = {0, 1, 1};
	
	static void dfs(int y, int x, int type) {
		if(y==N-1&&x==N-1) {
			System.out.println("도착");
			cnt++;
			return;
		}
		
		int[] Dir = getDir(type);
		
		for(int i=0; i<Dir.length; ++i) {
			int ny = y + dy[Dir[i]];
			int nx = x + dx[Dir[i]];
			
			if(ny<0 || ny>N-1 || nx<0 || nx>N-1 || map[ny][nx] != 0) continue;
			
			if(Dir[i] == 2 && (map[y][x+1]!=0||map[y+1][x]!=0)) continue;
			
			dfs(ny, nx, Dir[i]);
		}
	}
	
	static int[] getDir(int type) {
		if(type == 0) {
			int[] ret = {0,2};
			return ret;
		}
		if(type == 1) {
			int[] ret = {1,2};
			return ret;
		}
		if(type == 2) {
			int[] ret = {0,1,2};
			return ret;
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				map[i][j] = sc.nextInt();
			}
		}
		
		cnt = 0;
		dfs(0, 1, 1);
		System.out.println(cnt);
	}

}
