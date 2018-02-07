package com.aman.basics;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker1{

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void producer()throws InterruptedException{
	lock.lock();
	System.out.println("Producer method");
	condition.await();
	System.out.println("Producer again...");
	lock.unlock();
	}
	
	public void consumer()throws InterruptedException{
		lock.lock();
		System.out.println("Consumer method");
		condition.signal();
		lock.unlock();
	
	}
	
	
}
public class ProducerAndConsumerWithLock {
	public static void main(String[] args) {
		Worker1 worker1=new Worker1();
		Thread t1= new Thread(new  Runnable() {
			
			@Override
			public void run() {
				try {
					worker1.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2= new Thread(new  Runnable() {
			
			@Override
			public void run() {
				try {
					worker1.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}


	

}
