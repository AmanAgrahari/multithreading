package com.aman.basics;

class Procesor{
	public void produce()throws InterruptedException{
		synchronized (this) {
			System.out.println("we are in the producer method");
			/*
			 * this wait method is called only in the synchronized block 
			 * and it hands over the control of the lock that is synchronized
			 * block is locked on
			 * what is this lock??
			 * this is the lock basically on the intrinsic class
			*/
			wait(10000);
			System.out.println("Again producer method...");
		}	
		}
		
		public void consume()throws InterruptedException{
		Thread.sleep(1000);
		synchronized (this) {
			System.out.println("consumer method ....");
			notify();
			/*
			 * it is a waiting thread that it can wake up
			 * 
			 */
			
			Thread.sleep(3000);
		}
		}

}


public class WaitAndNotify {
	public static void main(String[] args) {
		Procesor procesor = new Procesor();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					procesor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					procesor.consume();
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
