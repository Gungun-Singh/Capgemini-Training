import java.util.*;
					 							// QUES NO.1
public class Array {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Size1:");
		int n1 = sc.nextInt();
		
		int[] arr1 = new int[n1];
		
	    System.out.println("First arr elements:");
       for (int i = 0; i < n1; i++) {
           arr1[i] = sc.nextInt();
       }
       
		
		System.out.println("Size2:");
		int n2 = sc.nextInt();
		int[] arr2 = new int[n2];
		
	    System.out.println("Second arr elements:");
       for (int i = 0; i < n2; i++) {
           arr2[i] = sc.nextInt();
       }
		
       Array obj = new Array();
       System.out.println(obj.same(arr1, arr2));
	}
	
	
	public boolean same(int[] arr1,int[] arr2){	
	if(arr1.length != arr2.length) {
		return false;
		}
	
	for (int i =0;i< arr1.length;i++) {
       if (arr1[i] !=arr2[i]) {
           return false;
       }
	}
	
		return true;
	
}
}


													//QUES NO. 2
public class Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size:");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		System.out.println("Enter arr elements");
		for (int i = 0;i < n; i++){
         arr[i] = sc.nextInt();
     }
		 Array obj = new Array();
		 arr = obj.rev(arr);
		 
		 for (int i=0;i< n;i++) {
	            System.out.print(arr[i]+" ");
	        }
}
	public int[] rev(int[] arr){
		int i =0, j =arr.length-1;

       while (i < j) {
           int temp = arr[i];
           arr[i] = arr[j];
           arr[j] = temp;
           i++;
           j--;
       }
       return arr;
	}

}


										//	QUES NO. 3

class Array{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size:");
		  int n = sc.nextInt();
		
			int[] arr = new int[n];
		
		System.out.println("Enter arr elements");
		  for (int i = 0;i < n; i++){
         arr[i] = sc.nextInt();
               }
		
	System.out.println("Enter target");
		int tar = sc.nextInt();
		
       for(int i=0;i<n-1; i +=2){
           if(arr[i]+arr[i+1] == tar){
               System.out.println(arr[i]+","+arr[i+1]);
           }
       }

		
}
}



//							QUES 5

	class Array{
		public static void main(String[] args) { 
			String s ="capgemini";
			char[] ch =s.toCharArray();
			
			     for(int i=0;i<ch.length;i++) {
			int count= 0;	
			if(ch[i]=='0') {
				continue;
				
				for (int j=i+1;j<ch.length;j++) {
	                if (ch[i]==ch[j]){
	                    count++;
	                    ch[j] ='0';
			}
	                
			}
				
				System.out.println(ch[i]+" "+count);
				
		}
	}
		
			     //	QUES 6
class Array{
	public static void main(String[] args) {
		String s1 = "cat";
		String s2 ="tac";
		
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		boolean ans= Arrays.equals(ch1, ch2);
		
		System.out.println(ans);
	}
}
		
	
//		QUES 7
class Array{
	  public static void main(String[] args) {
	        String s="mynameisgungun";

	        for(int i=0;i<s.length();i++) {
	            for (int j=i+1;j<s.length();j++){
	                if (s.charAt(i)== s.charAt(j)) {
	                    System.out.println(s.charAt(i));
	                    	return;   
	                }
	            }
	        }

	        System.out.println("No rep");
}
}


//			QUES 8
class Array{
	public static void main(String[] args) {
		int[] arr = [6,2,9,4,10,3];
		
		int lar= Integer.MIN_VALUE;
		int seclar = Integer.MIN_VALUE;
		
					for(int i=0;i<arr.length;i++) {
			if(arr[i]> lar) {
				seclar = lar;
				lar= arr[i];
			}
			else if(arr[i]> seclar && arr[i] != lar){
				seclar = arr[i];  }
		}
		if(seclar == Integer.MIN_VALUE) {
			System.out.println("No sec lar");
		}
		else {
			System.out.println(seclar);
		}
	}
}


class Array{
	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);

      char[][] board = {
          {'_','_','_'},
          {'_','_','_'},
          {'_','_','_'}
      };

      char player = 'X';
      int moves = 0;

      while (true) {

          // PRINT BOARD
          System.out.println();

          for (int i = 0; i < 3; i++) {
              for (int j = 0; j < 3; j++) {
                  System.out.print(board[i][j] + " ");
              }
              System.out.println();
          }

          System.out.println("\nPlayer " + player + " enter row and column (1-3):");

          int r = sc.nextInt() - 1;
          int c = sc.nextInt() - 1;

          // VALIDATION
          if (r < 0 || r > 2 || c < 0 || c > 2) {
              System.out.println("Invalid position!");
              continue;
          }

          // CHECK EMPTY
          if (board[r][c] != '_') {
              System.out.println("Already occupied!");
              continue;
          }

          board[r][c] = player;
          moves++;

          // WIN CHECK
          if (
              board[r][0]==player && board[r][1]==player && board[r][2]==player ||
              board[0][c]==player && board[1][c]==player && board[2][c]==player ||

              board[0][0]==player && board[1][1]==player && board[2][2]==player ||
              board[0][2]==player && board[1][1]==player && board[2][0]==player
          ) {
              System.out.println("\nPlayer "+player+" WINS!");
              break;
          }

          if (moves==9){
              System.out.println("\nDRAW!");
              break;
          }

          // SWITCH PLAYER
          if (player == 'X')
              player = 'O';
          else
              player = 'X';
      }

      sc.close();
		
	}
}

