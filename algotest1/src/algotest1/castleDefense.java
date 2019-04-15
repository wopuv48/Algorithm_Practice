package algotest1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class castleDefense {
	static int[][] map;
	static boolean[][] visited;
	static int N,M;
	static int distance;
	//궁수 배치 먼저
	//배치후에 
	
	static class Node {
		int a,b;
		Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	static class Sol implements Comparable<Sol> {
		int a,b;
		Sol(int a, int b) {
			this.a = a;
			this.b = b;
		}
	
		public int compareTo(Sol target) {
			if(this.a > target.a) return -1;
			else if(this.a < target.a) return 1;
			else return 0;
		}
	}
	
	static void solve(int map[][], int r1, int c1, int r2, int c2, int r3, int c3 ) {
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		M = sc.nextInt();
//		distance = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
//		
//		for(int i=0; i<N+1; i++) {
//			for(int j=0; j<M; j++) {
//				if(i == N) {
//					map[i][j] = 0;
//				} else {
//				map[i][j] = sc.nextInt();
//				}
//			}
//		}
		
		ArrayList<Sol> arr = new ArrayList<>();

		arr.add(new Sol(7, 8));
		arr.add(new Sol(3, 4));
		arr.add(new Sol(5, 6));
	
	
		
		Collections.sort(arr);
		
		System.out.println(arr.get(0).a + "/"+arr.get(0).b);
//		for(int i=0; i<M-2; i++) {
//			map[N][i] = 9;
//			for(int j=i+1; j<M-1; j++) {
//				map[N][j] = 9;
//				for(int k=j+1; j<M; j++) {
//					map[N][k] = 9;
//					solve(map, N, i, N, j, N, k);
//					map[N][k] = 0;
//				}
//				map[N][j] = 0;
//			}
//			map[N][i] = 9;
//		}
	}

}
