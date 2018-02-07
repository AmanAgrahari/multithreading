package com.aman.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements Runnable{
	private int id;
	private CountDownLatch countDownLatch;
	private Random random;
	public Worker(int id,CountDownLatch countDownLatch){
		this.id =id;
		this.countDownLatch =countDownLatch;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		doWork();
	countDownLatch.countDown();
	}
	private void doWork(){
		System.out.println("thread with id "+ this.id + " starts working....");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}

public class LatchBasics {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService =Executors.newSingleThreadExecutor();
		CountDownLatch latch = new CountDownLatch(5);
		//5 task
		for(int i=0;i<5;i++)
			executorService.execute(new Worker(i+1,latch));
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//the main thread is going to be blocked until all the 5 threads are executed
		System.out.println("All the visits are done");
		executorService.shutdown();
	}

}
