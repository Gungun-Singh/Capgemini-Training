import java.util.*;

class AnalyticsTracker {

    private int K;

    private Queue<String> queue;

    private Map<String, Integer> map;

    private int total;

    
    public AnalyticsTracker(int K) {
        this.K = K;
        this.queue = new LinkedList<>();
        this.map= new HashMap<>();
        this.total =0;       
        
    }

    
    public void registerAction(String action) {
    	
    	queue.add(action);
    	total++;
    	
    	
    		int count = map.getOrDefault(action, 0)+1;
    		map.put(action, count);
    	
    	if(queue.size()==K) {
    		queue.clear();
    	}
    }

    
    public int getPendingCount() {
       
        return queue.size();
    }

   
    public int getTotalLoggedActions() {
       
        return total;
    }

    
    public List<String> getMostFrequentActions() {
        
    	
    	ArrayList<String> list = new ArrayList<>();
    	
    	if(map.isEmpty()) return list;
    	
    	int max=0;
    	for(int val: map.values()) {
    		if(val>max) {
    			max= Math.max(val, max);
    		}
    		
    		for(String key: map.keySet()) {
    			if(map.get(key)== max) {
    				list.add(key);
    			}
    		}
    	}
    	Collections.sort(list);
        return list;
    }
}
