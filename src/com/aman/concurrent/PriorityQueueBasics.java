package com.aman.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.PriorityBlockingQueue;


class FirstWorker1 implements Runnable{

	private BlockingQueue<Person> blockingQueue;
	 public FirstWorker1(BlockingQueue<Person> blockingQueue) {
	this.blockingQueue=blockingQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*try {
			blockingQueue.put("B");
			blockingQueue.put("H");
			blockingQueue.put("F");
			Thread.sleep(1000);
			blockingQueue.put("A");
			Thread.sleep(1000);
			blockingQueue.put("E");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			blockingQueue.put(new Person(12,"Adam"));
			blockingQueue.put(new Person(45,"joe"));
			blockingQueue.put(new Person(78,"Daniel"));
			Thread.sleep(1000);
			blockingQueue.put(new Person(32,"noel"));
			Thread.sleep(1000);
			blockingQueue.put(new Person(34,"kevin"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}



class SecondWorker1 implements Runnable{

	private BlockingQueue<Person> blockingQueue;
	
	 public SecondWorker1(BlockingQueue<Person> blockingQueue) {
	this.blockingQueue=blockingQueue;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class Person implements Comparable<Person>{
	
	private int age;
	private String name;
	public Person(int age,String name){
		this.age=age;
		this.name=name;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.getName());
	}

	@Override
	public String toString() {
		return name +"-"+age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
public class PriorityQueueBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BlockingQueue<String> queue = new PriorityBlockingQueue<>();
		BlockingQueue<Person> queue = new PriorityBlockingQueue<>();
		new Thread(new FirstWorker1(queue)).start();
		new Thread(new SecondWorker1(queue)).start();
	}

}
