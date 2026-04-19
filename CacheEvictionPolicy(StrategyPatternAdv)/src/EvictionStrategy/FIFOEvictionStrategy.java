package EvictionStrategy;

import java.util.LinkedHashSet;


public class FIFOEvictionStrategy<K> implements IEvectionStrategy<K>{
	
	private final LinkedHashSet<K> fifoQueue = new LinkedHashSet<>();

	@Override
	public void keyAccessed(K key) {
		//If it's already in the queue (a read/update), we do absolutely NOTHING
		if(!fifoQueue.contains(key)) {
			fifoQueue.add(key);
		} 
		
	}

	@Override
	public K evict() {
		if(fifoQueue.isEmpty()){
            return null;
        }
		K oldestKey=fifoQueue.iterator().next();
		fifoQueue.remove(oldestKey);
		return oldestKey;
	}

}
