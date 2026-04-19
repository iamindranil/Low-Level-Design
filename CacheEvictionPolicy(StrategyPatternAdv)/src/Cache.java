import java.util.Map;

import EvictionStrategy.IEvectionStrategy;

public class Cache<K,V> {
	int capacity;
	Map<K, V> storageMap;
	IEvectionStrategy<K> evectionStrategy;
	
	public Cache(int capacity,Map<K, V> storageMap,IEvectionStrategy<K> evectionStrategy){
		this.capacity=capacity;
		this.storageMap=storageMap;
		this.evectionStrategy=evectionStrategy;
	}
	
	public V get(K key) {
		if(!storageMap.containsKey(key))return null;
		evectionStrategy.keyAccessed(key);
		return storageMap.get(key);
	}
	
	public void put(K key, V value) {
		if(storageMap.size()==capacity) {
			K leastRecentlyUsed = evectionStrategy.evict();	
			if(leastRecentlyUsed!=null){
				storageMap.remove(leastRecentlyUsed);
			}
		}
		evectionStrategy.keyAccessed(key);
		storageMap.put(key, value);
	}
	
}
