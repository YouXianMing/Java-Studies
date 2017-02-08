package application;

import java.util.*;

public class DataStructure {

	public static <K, V> Map<K, V> HashMap() {

		Map<K, V> map = new HashMap<K, V>();

		return map;
	}

	public static <K, V> Map<K, V> TreeMap() {

		Map<K, V> map = new TreeMap<K, V>();

		return map;
	}

	public static <E> Set<E> HashSet() {

		Set<E> set = new HashSet<E>();

		return set;
	}

	public static <E> Set<E> TreeSet() {

		Set<E> set = new TreeSet<E>();

		return set;
	}

	public static <E> List<E> ArrayList() {

		List<E> list = new ArrayList<E>();

		return list;
	}

	public static <E> List<E> LinkedList() {

		List<E> list = new LinkedList<E>();

		return list;
	}
	
	public static <T extends Comparable<T>> void SortList(List<T> list) {

		Collections.sort(list);
	}
	
	public static <T> void ShuffleList(List<T> list) {
		
		Collections.shuffle(list);
	}
	
	public static <T> void ShuffleList(List<T> list, long seed) {
		
		Collections.shuffle(list, new Random(seed));
	}
}
