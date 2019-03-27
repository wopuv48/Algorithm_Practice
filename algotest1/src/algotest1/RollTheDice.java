package algotest1;

import java.util.ArrayList;
import java.util.Scanner;

public class RollTheDice {
	static int N;
	static int M;
	static int K;
	static int[] arrs;
	static int[] ans;
	static int count = 0;
	static int overlap = 0;
	static int sum = 0;
	static int sumTwo = 0;

	static void solve() {
		for(int i=0; i<arrs.length; i++) {
			sumTwo += arrs[i];
			System.out.print(arrs[i]);
			
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		//N은 숫자의 갯수, M은 총 더할 수 있는 갯수, K는 특정한 인덱스의 숫자가 중복 될 수 있는 한계의 수. 
		arrs = new int[N];
		ans = new int[M];

		for(int i=0; i<N; i++) {
			arrs[i] = sc.nextInt();
		}

		do {

			sumTwo = 0;
			solve();

			for(int j=0; j<arrs.length; j++) {
				count = Math.max(count, arrs[j]);
				if(j==arrs.length-1) {
					for(int k=0; k<arrs.length; k++) {
						if(arrs[k] == count) {
							arrs[k] = 0;
							break;
						}
					}
				}
			}
			//arrs안에 있는 최대값을 찾은후, 그 최대값이 있는 인덱스를 arrs에서 삭제.

			for(int k=0; k<M; k++) {
				if(ans[k] == 0 && overlap <	K) {
					ans[k] = count;
					overlap++;
				}
//				System.out.print(ans[k]);
			}
//			System.out.println();
			count = 0;
			overlap = 0;
		} while(sumTwo > 0);

		//최대값을 M번 더해줌.

		for(int o=0; o<ans.length; o++) {
			sum += ans[o];
		}

		System.out.println(sum);



	}

}
