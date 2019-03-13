package algotest1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class AlphabetPermutation {
	static Character[] strArr;
	static String[] ans;
	static int selectNum;
	static int maxNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		selectNum = sc.nextInt();
		maxNum = sc.nextInt();
		strArr = new Character[maxNum];
		String str = "";

		sc.nextLine();


		str += sc.nextLine();
		str = str.replaceAll(" ", "");

		for(int i=0; i<str.length(); ++i) {
			strArr[i] = str.charAt(i);
		}

		Arrays.sort(strArr); //Arrays.sort로 정렬
		backTracking(0,0,0,0,"");
		sc.close();
	}

	static void backTracking(int index, int cnt, int mo, int ja, String s) {
		if(cnt == selectNum) {
			if(mo>=1 && ja>=2)
				System.out.println(s);
			return;
		}

		if(index == maxNum) return;

		if(strArr[index] == 'a' || strArr[index] == 'e' || strArr[index] == 'i' || strArr[index] == 'o' || strArr[index] == 'u')
			backTracking(index+1, cnt+1, mo+1, ja, s+strArr[index]);

		else backTracking(index+1, cnt+1, mo, ja+1, s+strArr[index]);

		backTracking(index+1, cnt, mo, ja, s);
	}
}
