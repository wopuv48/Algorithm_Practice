package algotest1;
//    O	P	Q	R	S	T	U	V	W	X	Y	Z
//	  L	K	J	I	H	G	F	E	D	C	B	A
public class test1231 {
	 static int plussum = 0;
	    static int multisum = 1;
	    static int maxPobi = 0;
	    static int maxCrong = 0;

	    static void plusPobi(int num) {
	        while(num!= 0){
	            plussum += num%10;
	            num /= 10;
	            
	        }
	       maxPobi = Math.max(maxPobi, plussum);
	       System.out.println(maxPobi);
	       
	    }
	    static void multiplyPobi(int num) {
	    	
	        while(num!= 0){
	            multisum *= num%10;
	            num /= 10;
	        }
	       maxPobi = Math.max(maxPobi, multisum);
	       System.out.println(maxPobi);
	    }
	    
	    static void plusCrong(int num) {
	        while(num!= 0){
	            plussum += num%10;
	            num /= 10;
	        }
	       maxCrong = Math.max(maxCrong, plussum);
	       System.out.println(maxCrong);

	    }
	    
	    static void multiplyCrong(int num) {
	        while(num!= 0){
	            multisum *= num%10;
	            num /= 10;
	        }
	        maxCrong = Math.max(maxCrong, multisum);
		       System.out.println(maxCrong);

	    }
	public static void main(String[] args) {
		
		    int[] pobi = {97,98};
		    int[] crong = {197,198};

		   
		        int answer = 0;
		        //포비가 이기면 1
		        //크롱이 이기면 2
		        //무승부는 0
		        //예외사항은 -1
		        //일단 각자리의 합, 각자리의 곱을 알아야함.
		        if(pobi[0]+1 != pobi[1] || crong[0]+1 != crong[1])
		            answer = -1;
		        
		        int a = pobi[0];
		        int b = pobi[1];
		        
		        plusPobi(a);
		        multiplyPobi(a);
		        plusPobi(b);
		        multiplyPobi(b);
		       
		        
		        int aTwo = crong[0];
		        int bTwo = crong[1];
		        
		        plussum = 0;
		        multisum = 1;
		        
		        plusCrong(aTwo);
		        multiplyCrong(aTwo);
		        plusCrong(bTwo);
		        multiplyCrong(bTwo);
		        
		        if(maxPobi < maxCrong) {
		            answer = 2;
		        } else if(maxPobi > maxCrong) {
		            answer = 1;
		        } else 
		            answer = 0;
		        
		        System.out.println(answer);
		        
		    }
	}

