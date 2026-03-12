import java.util.*;
import java.io.*;

public class ServerAccessLogs {

    public static List<String> getTopActiveUsers(List<List<String>> logs) {
        
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        int max=0;
        
        for(List<String> log : logs) {
        	String name= log.get(0);
        	String status= log.get(1);
        	
        	if(status.equals("LOGIN")) {
        		int count= map.getOrDefault(name, 0)+1;
        		map.put(name,count);
        		max= Math.max( max, count);
        	}
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
        	if(entry.getValue()== max) {
        		list.add(entry.getKey());
        	}
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
		String[][] input = {
	            {"alice","LOGIN","10"},
	            {"bob","LOGIN","20"},
	            {"alice","LOGIN","30"},
	            {"bob","LOGOUT","40"},
	            {"charlie","LOGIN","50"},
	            {"bob","LOGIN","60"}
	        };

	        List<List<String>> logs = new ArrayList<>();

	        for (String[] row : input) {
	            logs.add(Arrays.asList(row));
	        }

	        List<String> result = ServerAccessLogs.getTopActiveUsers(logs);

	        System.out.println(result);
	    }
}
