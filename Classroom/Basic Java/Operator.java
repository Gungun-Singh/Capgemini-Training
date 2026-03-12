
public class Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	   //arithmetic
		int a= 10, b=3;
	System.out.println(a + b);

	//logical
		  int c= 20;
		System.out.println(c>18 && c<80);
		
		//relational
		int p= 10, q= 20;
	  System.out.println(p<q);

	  //assignment
		int x= 5;
		  x += 7;
	   System.out.println(x);
	   
	   //bitwise
	   int m= 5,n= 2;
	   System.out.println(m& n);

	 //ternary
	   int num= 5;
	  System.out.println(num>0?"pos":"neg");


	  //QUESTION
	  //USING TERNARY OPERATOR, FIND THE GREATEST NUMBER AMONG 3 NUMBERS
	  
	  int a1 = 12;
	  int a2= 7;
	  int a3= 15;
	  
	  int ans =(a1>a2)?(a1>a3?a1:a3):(a2>a3?a2:a3);
	  System.out.println(ans);
	  
	  
	  // no 0, update no. using last digit
	  int dig = 124;
	  System.out.println(dig/10);
	  
	  
	  //if
	  int age = 16;
	  if(age>18) {
		  System.out.println("adult");
	  }
	  
	  //if-else
	  int age1 = 25;
	  if(age1>18) {
		  System.out.println("is an adult");
	  }else {
		  System.out.println("is not an adult");
	  }
	  
	  //else-if ladder
	  
	  int age2 = 30;
	  
	  if(age2 == 18) {
		  System.out.println("U are 18");
	  }
	  else if(age2<18) {
		  System.out.println("U are under 18");
	  }
	  else {
		  System.out.println("U are over 18");
	  }
	  
	  
	  
	}
}
