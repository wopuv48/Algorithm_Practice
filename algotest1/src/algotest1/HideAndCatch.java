package algotest1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndCatch {
	static int F; //제일높은층
	static int S; //시작층
	static int G; //가야할층
	static int U; //위로갈수있는층
	static int D; //아래로갈수있는층
	static int[] dx = {-1, 1};
	static boolean[] visited = new boolean[1000001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		dx[0] *= D;
		dx[1] *= U;
		
		if(S >= G) {
			System.out.println("use the stairs");
			return;
		}
		
		System.out.println(bfs(S));
		
	}
	
	static class Node {
		int a;
		int b;
		
		Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	static int bfs(int s) {
		Queue<Node> q = new LinkedList<>();
		visited[s] = true;
		q.add(new Node(0,s));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int a = node.a;
			int b = node.b;
			
			if(b == G) {
				return a;
			}
			
			for(int i=0; i<2; i++) {
				int next = b+dx[i];
				
				if(next>0 && next<1000001) {
					if(!visited[next]) {
						q.add(new Node(a+1, next));
						visited[next] = true;
					}
				}
			}
		}
		return 0;
	}
}
