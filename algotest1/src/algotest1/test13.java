package algotest1;


//돈의 액수 money가 매개변수로 주어질 때, 
//오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇 개로 변환되는지 
//금액이 큰 순서대로 배열에 담아 return 하도록 solution 메서드

import java.util.Scanner;

public class test13 {
	

	public static void main(String[] args) {
		 int i=50000; 
		 int chk=0; 
		 int money=0; 
         int cnt; 

		 Scanner sc = new Scanner(System.in);
		 money = sc.nextInt();
		 int[] answer = new int[9];
		 

		 
			for(int j=0;j<9;j++){ 

				cnt = money/i;  
				
				answer[j] = cnt;

				money = money-(cnt*i);

				if(chk==0){

					i=i/5;

					chk=1;

				}else{       
					if(i==10) {
						i=i/5;
						chk=1;
					}
					i=i/2;

					chk=0;

				}
			}
			
			
			for(int k=0; k<9; k++)
				System.out.print(answer[k]+" ");
	       
	}

}