package EvictionStrategy;

public interface IEvectionStrategy<K>{
	/**
     * Called every time a key is read or written in the cache.
     * This allows the strategy to update its internal tracking (like a Linked List).
     */
	void keyAccessed(K key);
	
	/**
     * Called when the cache is full.
     * @return The key that should be removed from the cache.
     */
	K evict();
}
