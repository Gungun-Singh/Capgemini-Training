import java.util.*;

class ActionTracker {

    
    private int K;
    ArrayList<String> queue;
    int totalb;
    ArrayList<String> last;

    public ActionTracker(int K) {
        
    	this.queue= new ArrayList<>();
    	this.last = new ArrayList<>();
    	this.K = K;
    	this.totalb = 0;
    }

    public void registerAction(String action) {
    	
    	queue.add(action);
    	if(queue.size()== K) {
    		last = new ArrayList<>(queue);
    		totalb++;
    		queue.clear();
    	}
    }

    public int getPendingCount() {
        return queue.size();
    }

    public int getTotalSentBatches() {
        return totalb;
    }

    public List<String> getLastBatch() {
        return new ArrayList<>(last);
    }
}
