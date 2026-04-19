package EvictionStrategy;

import java.util.LinkedHashSet;

public class LRUEvictionStrategy<K> implements IEvectionStrategy<K>{
	// LinkedHashSet maintains insertion/access order perfectly for LRU
    private final LinkedHashSet<K> keyTracker = new LinkedHashSet<>();

	@Override
	public void keyAccessed(K key) {
		if(keyTracker.contains(key))keyTracker.remove(key);
		keyTracker.add(key);
	}

	@Override
	public K evict() {
		if(keyTracker.isEmpty())return null;
		K leastRecentlyUsed=keyTracker.iterator().next();
		keyTracker.remove(leastRecentlyUsed);
		return leastRecentlyUsed;
	}
	
}
