import java.util.*;
public class BrowserHistory {
	
	Stack<String> backs;
	Stack<String> next;
	String curr;
	
	
   public BrowserHistory(String homepage) {
   	backs = new Stack<>();
   	next = new Stack<>();
   	curr= homepage;
   }

   public void visit(String url) {
   	backs.push(curr);
   	curr= url;
   	next.clear();
   }

   public String back(int steps) {
   	while(steps>0 && !backs.isEmpty()) {
   		next.push(curr);
   		curr = backs.pop();
   		steps--;
   	}
   	return curr;
   }

   public String forward(int steps) {
   	while(steps>0 && !next.isEmpty()) {
   		backs.push(curr);
   		curr= next.pop();
   		steps--;
   	}
   	return curr;
   }

   public static void main(String[] args) {

       BrowserHistory browser = new BrowserHistory("leetcode.com");

       browser.visit("google.com");
       browser.visit("facebook.com");
       browser.visit("youtube.com");

       System.out.println(browser.back(1));
       System.out.println(browser.back(1));

       System.out.println(browser.forward(1));

       browser.visit("linkedin.com");

       System.out.println(browser.forward(2));

       System.out.println(browser.back(2));
       System.out.println(browser.back(7));

   }
}



//					FreqStack


public class BrowserHistory {

int maxf;
HashMap<Integer, Integer> freq;
HashMap<Integer, Stack<Integer>> map;

    public BrowserHistory() {
maxf = 0;
freq = new HashMap<>();
map = new HashMap<>();
    }
    

    public void push(int val) {
    	int f = freq.getOrDefault(val, 0)+1;
    	freq.put(val, f);
    	
    	if(f>maxf) {
    		maxf = f;
    	}
    	
    	
    }

    public int pop() {

        return 0;
    }

    public static void main(String[] args) {

    	BrowserHistory fs = new BrowserHistory();

        fs.push(5);
        fs.push(7);
        fs.push(5);
        fs.push(7);
        fs.push(4);
        fs.push(5);

        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());

    }
}
