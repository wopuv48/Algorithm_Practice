package makedecline;

import java.util.Scanner;

public class makedecline {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	static int ret;
	
	static void solve() {
		int i, j;
		int count = 0;
	
		for(i=0; i<N; ++i) {
			count = 1;
			for(j=0; j<N-1; ++j) {
				if(map[i][j] == map[i][j+1]) {
					count++;
					
				}
				else if(map[i][j] + 1 == map[i][j+1] && count >= M) {
					count = 1;
				}
				else if(map[i][j] - 1 == map[i][j+1] && count >= 0) {
					count = (1 - M);
				}
				else break;
			}
			if(j == (N-1) && count >= 0) {
				ret++;
			}
		}
		
		for(i=0; i<N; ++i) {
			count = 1;
			for(j=0; j<N-1; ++j) {
				if(map[j][i] == map[j+1][i]) {
					count++;
					
				}
				else if(map[j][i] + 1 == map[j+1][i] && count >= M) {
					count = 1;
				}
				else if(map[j][i] - 1 == map[j+1][i] && count >= 0) {
					count = (1 - M);
				}
				else break;
			}
			if(j == (N-1) && count >= 0) {
				ret++;
			}
		}
				
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][N];
		
		for(int i=0; i<N; ++i)
			for(int j=0; j<N; ++j)
				map[i][j] = sc.nextInt();
		solve();
		System.out.println(ret);	
	}
}
