package makebridge;

import java.util.Scanner;

public class makebridge {
	static final int MAX = 100;

	static int count = 0;
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int[] MapRow = new int[N];
	static int[] MapCol = new int[N];

	static int solve(int number) {
		
		if(number == count - 1) {
			return count;
		} else {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
//					MapRow[number] = i;
//					MapCol[number] = j; 
					visited[i][j] = true;
					map[i][j] = 7;
					solve(number + 1);
				}
			}
		}
		}
		
		return count;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			N = sc.nextInt();
			if (0 <= N && N <= 100) {
				map = new int[N][N];
				visited = new boolean[N][N];

				for (int i = 0; i < N; ++i) {
					for (int j = 0; j < N; ++j) {
						map[i][j] = sc.nextInt();
						
						if(map[i][j] == 1) {
							count++;
						}
					}
				}
				break;
			} else
				System.out.println("100이하의 정수로 입력!");
		}
		
		solve(0);
		for (int i = 0; i < N; ++i) { 
			System.out.println(" ");
			for (int j = 0; j < N; ++j) {
		System.out.print(map[i][j]);
			}
		}
	}

}
