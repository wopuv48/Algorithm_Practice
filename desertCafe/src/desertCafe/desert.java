package desertCafe;
import java.util.Scanner;

public class desert {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int[][] map = new int[20][20];
	static boolean[] isVisit = new boolean[101];
	static int result;
	
	static void visitClear() {
		for(int i = 0; i < 101; i++)
			isVisit[i] = false;
	}
  
	static void init() {
		visitClear();
		result = -1;
	}
	
	static void solve() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				for(int a = 1; a<N; a++) {
					for(int b = 1; b<N; b++) {
						if(j+a <= N - 1  
							&& i+a+b <= N - 1 
							&& j-b >= 0
							&& (a+b) *2 > result) {
							
							visitClear();
							boolean isAble = true;
							int curi = i, curj = j;
						
							for(int n=0; n<a; n++) {
								curi++; curj++;
								
								if(!isVisit[map[curi][curj]]) {
									isVisit[map[curi][curj]] = true;
								}
								else
								{
									isAble = false;
									break;
								}
							}
							
							if(!isAble) continue;
							
							for(int n=0; n<b; n++) {
								curi++; curj--;
								
								if(!isVisit[map[curi][curj]]) {
									isVisit[map[curi][curj]] = true;
								}
								else
								{
									isAble = false;
									break;
								}
							}
							
							if(!isAble) continue;
							
							for(int n=0; n<a; n++) {
								curi--; curj--;
								
								if(!isVisit[map[curi][curj]]) {
									isVisit[map[curi][curj]] = true;
								}
								else
								{
									isAble = false;
									break;
								}
							}
							
							if(!isAble) continue;
							
							for(int n=0; n<b; n++) {
								curi--; curj++;
								
								if(!isVisit[map[curi][curj]]) {
									isVisit[map[curi][curj]] = true;
								}
								else
								{
									isAble = false;
									break;
								}
							}
							
							if(!isAble) continue;
							
							result = 2*(a+b);
						
						}
						
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		int test_case;
		test_case = sc.nextInt();
		for(int tc=1; tc<=test_case; tc++) {
			
			init();
			
			N = sc.nextInt();
			for(int i = 0; i<N; i++)
				for(int j = 0; j<N; j++)
					map[i][j] = sc.nextInt();
			
			solve();
			
			System.out.println("#"+tc+" "+result);
		}
		
	}

}
