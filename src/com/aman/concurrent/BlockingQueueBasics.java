package com.aman.concurrent;

import java.rmi.server.SocketSecurityException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class FirstWorker implements Runnable{

	private BlockingQueue<Integer> blockingQueue;
	public FirstWorker( BlockingQueue<Integer> blockingQueue) {
		// TODO Auto-generated constructor stub
	this.blockingQueue =blockingQueue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int counter =0;
		while(true){
			try {
				blockingQueue.put(counter);
				System.out.println("Pitting items to the queue..."+counter);
				counter++;
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
class SecondWorker implements Runnable{

	private BlockingQueue<Integer> blockingQueue;
	public SecondWorker( BlockingQueue<Integer> blockingQueue) {
		// TODO Auto-generated constructor stub
	this.blockingQueue =blockingQueue;
	}
	@Override
	public void run() {
		while(true){
			try {
			int number=	blockingQueue.take();
				System.out.println("Taking items from the queue..."+number);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
public class BlockingQueueBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
		FirstWorker firstWorker =new FirstWorker(queue);
		SecondWorker secondWorker =new SecondWorker(queue);
		new Thread(firstWorker).start();
		new Thread(secondWorker).start();

	}

}
