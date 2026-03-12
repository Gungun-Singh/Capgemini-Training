
public class loops {
	public static void main(String[] args) {
		
		//FOR LOOP
		for(int i=1;i<=10;i++) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		//WHILE LOOP
		int age = 12;
		while(age>6) {
			System.out.println(age);
			age--;
		}
		
		//DO-WHILE
		int flags = 20;
		do {
			System.out.print("flag");
			flags++;
		}while(flags>25);
		
		
		
		
		System.out.println();
		
		//SUM OF DIGITS
		int num= 54638;
		int n=0;
		
		while(num>0){
			n += num%10;
			num = num/10;
		}
		System.out.println(n);
		
		
		
		//PALINDROME
		int number=34143;
		int val= 34143;
		int rev=0;

		while(val>0) {
			int dig =val%10;
			rev= rev*10 +dig;
			val= val/10;
		}
		
		if(number == rev) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
	}
}
