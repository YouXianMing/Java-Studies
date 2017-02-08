package application;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

	public static void main(String args[]) {

		// collection_type_01();
		// collection_type_02();
		// collection_type_03();
		// collection_type_04();
		// collection_type_05();
		// collection_type_06();
	}

	/**
	 * 创建静态数组,数组为线性结构(给定一个连续的存储空间)
	 */
	public static void collection_type_01() {

		// 初始化了存储空间,但并没有实例对象
		Dog[] dogs = new Dog[10];

		for (int i = 0; i < dogs.length; i++) {

			System.out.println(dogs[i]);
		}
		
		for (int i = 0; i < dogs.length; i++) {

			dogs[i] = new Dog(String.format("dog - %d", i));
			System.out.println(dogs[i].getName());
		}
		
		System.out.println(dogs.getClass().getName());
	}

	/**
	 * 创建动态数组ArrayList,内部采用数组作为数据结构
	 */
	public static void collection_type_02() {

		// 初始化数组对象
		ArrayList<Dog> dogs = new ArrayList<Dog>();

		for (int i = 0; i < 10; i++) {

			dogs.add(new Dog(String.format("dog - %d", i)));
		}

		for (int i = 0; i < dogs.size(); i++) {

			System.out.println(dogs.get(i).getName());
		}

		// 对数组对象进行排序,数组对象需要实现接口 Comparable
		Collections.sort(dogs);

		for (int i = 0; i < dogs.size(); i++) {

			System.out.println(dogs.get(i).getName());
		}
		
		System.out.println(dogs.getClass().getName());
	}

	/**
	 * 创建动态数组LinkedList,内部采用链表作为数据结构
	 */
	public static void collection_type_03() {

		// 初始化数组对象
		LinkedList<Dog> dogs = new LinkedList<Dog>();

		for (int i = 0; i < 10; i++) {

			dogs.add(new Dog(String.format("dog - %d", i)));
		}

		for (int i = 0; i < dogs.size(); i++) {

			System.out.println(dogs.get(i).getName());
		}

		// 对数组对象进行排序,数组对象需要实现接口 Comparable
		Collections.sort(dogs);

		for (int i = 0; i < dogs.size(); i++) {

			System.out.println(dogs.get(i).getName());
		}
	}

	/**
	 * 多态数组
	 */
	public static void collection_type_04() {

		// 初始化数组对象
		// List<Dog> dogs = new LinkedList<Dog>();
		List<Dog> dogs = new ArrayList<Dog>();

		System.out.println(dogs);
	}

	/**
	 * HashSet(散列表作为数据结构) + TreeSet(二叉搜索树作为数据结构)
	 */
	public static void collection_type_05() {

		// HashSet
		{
			Set<String> stooges = new HashSet<String>();
			stooges.add("B");
			stooges.add("A");
			stooges.add("C");
			stooges.add("A");
			System.out.println(stooges);
		}

		// TreeSet
		{
			Set<String> stooges = new TreeSet<String>();
			stooges.add("B");
			stooges.add("A");
			stooges.add("C");
			stooges.add("A");
			System.out.println(stooges);
		}
	}

	/**
	 * HashMap(散列表作为数据结构) + TreeMap(二叉搜索树作为数据结构)
	 */
	public static void collection_type_06() {

		// HashMap
		{
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", "YouXianMing");
			map.put("age", "18");
			System.out.println(map);
		}

		// TreeMap
		{
			Map<String, String> map = new TreeMap<String, String>();
			map.put("name", "YouXianMing");
			map.put("age", "18");
			System.out.println(map);
		}
	}
}

class Dog implements Comparable<Dog> {

	private String name = null;

	public Dog(String name) {

		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	@Override
	public int compareTo(Dog o) {

		return o.getName().compareTo(this.name);
	}
}
