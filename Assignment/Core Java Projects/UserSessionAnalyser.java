import java.util.*;
import java.io.*;

public class UserSessionAnalyser {

    public static List<String> getCurrentlyLoggedInUsers(List<List<String>> logs) {
        
        // Write your code here
    	
    	HashSet<String> set = new HashSet<>();
    	int count =0;
    	
    	for(List<String> log: logs) {
    		String name= log.get(0);
    		String status = log.get(1);
    		
    		if(status.equals("LOGIN")) {
    			set.add(name);
    		}
    		if(status.equals("LOGOUT")) {
    			set.remove(name);
    		}
    		
    	}
    	 List<String> res= new ArrayList<>(set);
    	 Collections.sort(res);	
        return res;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<List<String>> logs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            logs.add(Arrays.asList(parts));
        }

        List<String> result = getCurrentlyLoggedInUsers(logs);

        for (String user : result) {
            System.out.println(user);
        }

        sc.close();
    }
}
