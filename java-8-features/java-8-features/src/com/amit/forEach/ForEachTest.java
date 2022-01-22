package com.amit.forEach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ForEachTest {

	public static void main(String[] args) {
		ForEachTest test= new ForEachTest();
		test.iterateOverList();
		test.iterateOverSet();
		test.iterateOverMap();
	}
	
	private void iterateOverList()
	{
		System.out.println("============= Iterating over list ===============");
		List<String> list= new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		// One way to iterate over list
		list.forEach(System.out::println);
		// Another way to iterate
		list.forEach(s->System.out.println(s));
	}
	
	private void iterateOverSet()
	{
		System.out.println("============= Iterating over set ===============");
		Set<String> set= new HashSet<String>();
		set.add("one");
		set.add("two");
		set.add("three");
		set.add("four");
		// One way to iterate over set
		set.forEach(System.out::println);
		// Another way to iterate
		set.forEach(s->System.out.println(s));
	}
	
	private void iterateOverMap()
	{
		System.out.println("============= Iterating over map ===============");
		Map<Integer, String> map= new HashMap<Integer, String>();
		map.put(1, "first");
		map.put(2, "second");
		map.put(3, "third");
		map.put(4, "fourth");
		// One way to iterate
		map.forEach((key, value) -> System.out.println("key: "+ key+", value: "+ value));
		// Another way to iterate
		map.entrySet().forEach(entry-> {
			System.out.print("key: "+entry.getKey()+"\t");
			System.out.println("value: "+ entry.getValue());
		});
	}
}