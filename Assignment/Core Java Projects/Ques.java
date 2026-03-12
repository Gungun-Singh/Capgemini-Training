import java.util.*;

public class Ques {

	//					QUES 1
	
	
    public static void checkStrings(String[] a, String[] b) {
    	
    	
    	for(int i=0;i<a.length;i++) {
    		Set<Character> set = new HashSet<>();
    		
    		for(char c: a[i].toCharArray()) {
    			set.add(c);
    		}
    		
    		boolean found =false;
    		
    		
    		for(char c : b[i].toCharArray()) {
    			if(set.contains(c)) {
    				found = true;
    				break;
    			}
    		}
    		
    		if(found) {
    			System.out.print("YES");
    		}
    		else {
    			System.out.print("NO");
    		}
    	}
    	
    }

    public static void main(String[] args) {

        String[] a = {"ab","cd","ef"};
        String[] b = {"af","ee","ef"};

        checkStrings(a,b);

    }
	
	
	
	
	//				QUES 2
	
	
	
	 public static int findShortestSubstring(String s) {

	        Set<Character> set = new HashSet<>();
	        int left =0;
	        int max =0;
	        
	        for(int r=0;r<s.length();r++) {
	        	char ch = s.charAt(r);
	        	
	        	while(set.contains(ch)) {
	        	set.remove(s.charAt(left));
	        	left++;
	        	}
	        	set.add(ch);
	        	max = Math.max(max, r-left+1);
	        }
	        return s.length()-max;
	        
	    }

	    public static void main(String[] args) {

	        String s = "abcbbck";

	        System.out.println(findShortestSubstring(s));

	    }
}
