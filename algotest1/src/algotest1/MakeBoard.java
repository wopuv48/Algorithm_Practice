package algotest1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MakeBoard {
	static final int N = 10;
	static int[][] map;
	static boolean[][] visited;
	static final int five = 5, four = 4, three = 3, two = 2, one = 1;
	static int fiveCount = 5, fourCount = 5, threeCount = 5, twoCount = 5, oneCount = 5;
	
	static boolean[][] isFive = new boolean[N][N];
	static boolean[][] isFour = new boolean[N][N];
	static boolean[][] isThree = new boolean[N][N];
	static boolean[][] isTwo = new boolean[N][N];
	static boolean[][] isOne = new boolean[N][N];
	static boolean updated = false;
	static int ans = 0;

	static class Node {
		int a;
		int b;
		Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	static boolean checkTheBoard(int a, int b, int number) {
		int currx = a, curry = b;
		boolean[][] visited = new boolean[N][N];
		
		for(int i=0; i<number; i++) {	
			for(int j=0; j<number; j++) {
				int tempOne = i + currx;
				int tempTwo = j + curry;
				
				if(tempOne > N-1 || tempTwo > N-1 || map[tempOne][tempTwo] == 0) return false;
				visited[tempOne][tempTwo] = true;
			}
		}

		return true;
	}
	
	static void solveTwo(int currx, int curry) {
		if(checkTheBoard(currx, curry, five)) {
			isFive[currx][curry] = true;
		} else if(checkTheBoard(currx, curry, four)) {
			isFour[currx][curry] = true;
		} else if(checkTheBoard(currx, curry, three)) {
			isThree[currx][curry] = true;
		} else if(checkTheBoard(currx, curry, two)) {
			isTwo[currx][curry] = true;
		} else if(checkTheBoard(currx, curry, one)) {
			isOne[currx][curry] = true;
		}
	}
	
	static void remove(int i, int j, int number) {
		for(int a=0; a<number; a++) {
			for(int b=0; b<number; b++) {
				int temx = i + a;
				int temy = j + b;
				map[temx][temy] = 0;
			}
		}
	}
	static void solve(int x, int y) {
		do {
			int a = x; int b = y;
			Queue<Node> myqueue = new LinkedList<Node>();
			myqueue.add(new Node(a, b));
			while(!myqueue.isEmpty()) {
				Node node = myqueue.poll();
				int currx = node.a;
				int curry = node.b;
				solveTwo(currx, curry);
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						int tempOne = i + currx;
						int tempTwo = j + curry;

						if(tempOne > N-1 || tempTwo > N-1) continue;
						if(map[tempOne][tempTwo] == 0 || visited[tempOne][tempTwo]) continue;
						visited[tempOne][tempTwo] = true;
						myqueue.add(new Node(tempOne, tempTwo));
					}
				}
			}
			
			updated = false;
			solveThree();
			a = 0;
			b = 0;
		
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					visited[i][j] = false;
					isOne[i][j] = false;
					isTwo[i][j] = false;
					isThree[i][j] = false;
					isFour[i][j] = false;
					isFive[i][j] = false;
				}
			}
			
		}while(updated);
	}
	
	static void solveThree() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(isFive[i][j] == true && fiveCount != 0) {
					remove(i,j,five);
					updated = true;
					ans++;
					fiveCount--;
					return;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(isFour[i][j] == true && fourCount != 0) {
					remove(i,j,four);
					updated = true;
					ans++;
					fourCount--;
					return;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(isThree[i][j] == true && threeCount != 0) {
					remove(i,j,three);
					updated = true;
					ans++;
					threeCount--;
					return;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(isTwo[i][j] == true && twoCount != 0) {
					remove(i,j,two);
					updated = true;
					ans++;
					twoCount--;
					return;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(isOne[i][j] == true) {
					remove(i,j,one);
					updated = true;
					ans++;
					oneCount--;
					if(oneCount < 0) {
						ans = -1;
					}
					return;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[N][N];
		visited = new boolean[N][N];

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		solve(0, 0);
		System.out.println(ans);
	}

}
