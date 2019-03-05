package algotest1;

import java.util.Arrays;
import java.util.Scanner;

public class test1 {
	static String test_num = "123";
	static int[] test_num_array = new int[test_num.length()];
	static int test_count = 1;
	static int temp = 0;
	static boolean[] check = new boolean[test_num.length()];

	static void sort() {
		
		
		for(int i=0; i<test_num.length(); i++) {
			test_num_array[i] = test_num.charAt(i) - '0';
		}
		
		for(int i = 0; i < test_count; i++) {
			for(int j = 1; j < test_num_array.length; j++) {
				if(test_num_array[i] < test_num_array[j]) {
					for(int k = j-1; k >= 0; k--) {
						if(check[k] == true)
						check[k] = false;
					else
						check[j] = true;
					}
					
					if(check[j] == true)
					temp = test_num_array[i];
				
					test_num_array[i] = test_num_array[j];
					
					test_num_array[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		int test_case;
//		test_case = sc.nextInt();
		sort();	
		System.out.println(Arrays.toString(test_num_array));
	}
}
