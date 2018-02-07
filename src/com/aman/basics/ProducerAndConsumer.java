package com.aman.basics;

import java.util.ArrayList;
import java.util.List;

class Procesor1{
	private List<Integer> list =new ArrayList<>();
	private final int LIMIT=5;
	private final int BoTTOM=0;
	private int value=0;
	private final Object lock=new Object();
	
	
	
	public void produce()throws InterruptedException{
		synchronized (lock) {
			while(true){
				if(list.size()==LIMIT){
					System.out.println("waiting for removing item from the list");
					lock.wait();
				}else{
					System.out.println("adding:" +value);
					list.add(value);
					value++;
					lock.notify();
				}
				Thread.sleep(500);
			}
		}
		
		}
		
		public void consume()throws InterruptedException{
			synchronized (lock) {
				while(true){
					if(list.size()==BoTTOM){
						System.out.println("waiting for adding items to the list....");
						lock.wait();
					}else{
						System.out.println("removed:" +list.remove(--value));
						lock.notify();
					}
					Thread.sleep(500);
				}
			}
			
		}

}


public class ProducerAndConsumer {
	public static void main(String[] args) {
		Procesor1 procesor = new Procesor1();
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

