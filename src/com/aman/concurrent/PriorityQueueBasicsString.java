package com.aman.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.PriorityBlockingQueue;


class FirstWorker12 implements Runnable{

	private BlockingQueue<String> blockingQueue;
	public FirstWorker12(BlockingQueue<String> blockingQueue) {
	this.blockingQueue=blockingQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
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
		}
		
	}
	
}



class SecondWorker12 implements Runnable{

	private BlockingQueue<String> blockingQueue;
	
	 public SecondWorker12(BlockingQueue<String> blockingQueue) {
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


public class PriorityQueueBasicsString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<String> queue = new PriorityBlockingQueue<>();
		new Thread(new FirstWorker12(queue)).start();
		new Thread(new SecondWorker12(queue)).start();
	}

}
