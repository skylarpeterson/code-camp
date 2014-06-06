/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/
package assign1;

import java.util.*;

public class Taboo<T> {
	
	private HashMap<T, HashSet<T>> rulesMap;
	
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		HashMap<T, HashSet<T>> rulesMap = new HashMap<T, HashSet<T>>();		
		Iterator<T> it = rules.iterator();
		T prev = it.next();
		while(it.hasNext()){
			if(prev == null){
				prev = it.next();
			} else {
				T curr = it.next();
				if(rulesMap.containsKey(prev)){
					HashSet<T> currSet = rulesMap.get(prev);
					if(!currSet.contains(curr)) {
						if(curr != null) currSet.add(curr);
						rulesMap.put(prev, currSet);
					}
				} else {
					HashSet<T> newSet = new HashSet<T>();
					if(curr != null) newSet.add(curr);
					rulesMap.put(prev, newSet);
				}
				prev = curr;
			}
		}
		this.rulesMap = rulesMap;
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		if (rulesMap.containsKey(elem)) {
			HashSet<T> set = rulesMap.get(elem);
			return set;
		}
		else return Collections.emptySet();
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		int i = 0;
		while(i < list.size() - 1){
			T curr = list.get(i);
			T next = list.get(i+1);
			if(rulesMap.containsKey(curr)){
				HashSet<T> keySet = rulesMap.get(curr);
				if(keySet.contains(next)) list.remove(i+1);
				else i++;
			} else {
				i++;
			}
		}
	}
}
