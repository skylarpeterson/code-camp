package assign1;

import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		int numSameElems = 0;
		HashMap<T, Integer> countsA = buildCounts(a);
		HashMap<T, Integer> countsB = buildCounts(b);
		Set<T> keySet = countsA.keySet();
		for(T key : keySet){
			if(countsA.containsKey(key) && countsB.containsKey(key)){
				if(countsA.get(key) == countsB.get(key)){
					numSameElems++;
				}
			}
		}
		return numSameElems;
	}
	
	private static <T> HashMap<T, Integer> buildCounts(Collection<T> c){
		HashMap<T, Integer> counts = new HashMap<T, Integer>();
		Iterator<T> itC = c.iterator();
		while(itC.hasNext()){
			T curr = itC.next();
			if(counts.containsKey(curr)){
				Integer currCount = (Integer) counts.get(curr);
				currCount++;
				counts.put(curr, currCount);
			} else {
				counts.put(curr, 1);
			}
		}
		return counts;
	}
	
}
