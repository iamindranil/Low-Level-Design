package EvictionStrategy;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.function.Function;

public class LFUEvictionStrategy<K>implements IEvectionStrategy<K>{
	private final Map<K,Integer>counts=new HashMap<>();//key vs freq
	private final Map<Integer,LinkedHashSet<K>>listsMap=new HashMap<Integer,LinkedHashSet<K>>();//freq vs Keys
	private int minFreq=Integer.MAX_VALUE;
	

	@Override
	public void keyAccessed(K key) {
		if(!counts.containsKey(key)){
			counts.put(key,1);
			minFreq=1;
//			listsMap.computeIfAbsent(1,e->new LinkedHashSet<>()).add(key);
			listsMap.computeIfAbsent(1,new Function<Integer,LinkedHashSet<K>>(){
				@Override
				public LinkedHashSet<K> apply(Integer t) {
					return new LinkedHashSet<K>();
				}
				
			}).add(key);
			
		}else{
			int oldFreq=counts.get(key);
			counts.put(key,oldFreq+1);
			listsMap.computeIfAbsent(oldFreq+1,e->new LinkedHashSet<>()).add(key);
			//remove key from oldFreq map
			listsMap.get(oldFreq).remove(key);
			//update minFreq
			if(listsMap.get(minFreq).isEmpty()){
				minFreq=counts.get(key);
			}
		}
	}


	@Override
	public K evict() {
		if(minFreq==-1||!listsMap.get(minFreq).isEmpty())return null;
		K keyToBeRemoved=listsMap.get(minFreq).iterator().next();
		listsMap.get(minFreq).remove(keyToBeRemoved);
		counts.remove(keyToBeRemoved);
		return keyToBeRemoved;
	}

}
