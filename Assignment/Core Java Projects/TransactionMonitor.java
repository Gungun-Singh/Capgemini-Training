import java.util.*;
import java.io.*;

public class TransactionMonitor {

    public static List<String> getTopSpenders(List<List<String>> logs) {
        // Write your code here
        ArrayList<String> list = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        int max=0;
        
        for(List<String> log: logs) {
        	String name= log.get(0);
        	String tran = log.get(1);
        	
        	int money = map.getOrDefault(name,0)+Integer.parseInt(tran);
        	map.put(name,money);
        	max= Math.max(max, money);	
        }
        
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
        	if(entry.getValue()== max) {
        		list.add(entry.getKey());
        	}
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<List<String>> logs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            logs.add(Arrays.asList(parts));
        }

        List<String> result = getTopSpenders(logs);

        for (String user : result) {
            System.out.println(user);
        }

        sc.close();
    }
}
