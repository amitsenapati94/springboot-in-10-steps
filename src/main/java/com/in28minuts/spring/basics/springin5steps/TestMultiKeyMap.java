package com.in28minuts.spring.basics.springin5steps;

import org.apache.commons.collections4.map.MultiKeyMap;

public class TestMultiKeyMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MultiKeyMap<String, String> map = new MultiKeyMap<String,String>(); // some map implementation.
		map.put( "key1", "key2", "value12");
		map.put("key3", "key4", "key5", "value345");
		 
		//lookup with key1 or key2
		System.out.println(map.get("key1","key2"));
		
		System.out.println(map.get("key3", "key4", "key5"));
		
	

	}

}
