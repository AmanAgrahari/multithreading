package com.aman.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


class FirstWorker2 implements Runnable{

	private ConcurrentMap<String, Integer> map;
	
	public FirstWorker2(ConcurrentMap<String, Integer> map) {
	this.map=map;
	}
	@Override
	public void run() {
	try {
		map.put("B", 1);
		map.put("H", 2);
		Thread.sleep(1000);
		map.put("F", 3);
		map.put("A", 4);
		Thread.sleep(1000);
		map.put("E", 5);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		
	}
	
}



class SecondWorker2 implements Runnable{

	private ConcurrentMap<String, Integer> map;
	
	public SecondWorker2(ConcurrentMap<String, Integer> map) {
	this.map=map;
	}
	@Override
	public void run() {
	try {
		Thread.sleep(5000);
		System.out.println(map.get("A"));
		Thread.sleep(5000);
		System.out.println(map.get("E"));
		System.out.println(map.get("C"));
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		
	}
	
}
public class ConcurrentMapsBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
		new Thread(new FirstWorker2(map)).start();
		new Thread(new SecondWorker2(map)).start();
		List<String> list =new ArrayList<>();
		List<String> list2= Collections.synchronizedList(list);
	}

}
