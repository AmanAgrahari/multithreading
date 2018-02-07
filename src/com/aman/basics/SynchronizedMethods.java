package com.aman.basics;

public class SynchronizedMethods {

	private static int count1=0;
	private static int count2=0;
	/*
	 *  if we use this synchronixe with a method this means that
	 *  whenever a given thread calls this method
	 *  public synchronized static void add(){
			count1++;	
		}
	 *  the other thread cant call  
	 *  public synchronized static void addAgain(){
			count2++;	
	}
	* because we have used the class intrinsic lock
	* So java will say let the add() method operation is done 
	* then only the other thread of adddAgain() method will be called
	* This is the disadvantage 
	* 
	* both methods are independent then also we cant use the different threads to compute
	* because of intrinsic lock i.e lockon the same class
	* 
	*/
	public synchronized static void add(){
			count1++;	
	}
	public synchronized static void addAgain(){
			count2++;	
	}

	public static void compute(){
		for(int i=0;i<100;i++){
			add();
			addAgain();
		}
		
	}

	public static void main(String []args)
	{
		Thread t1= new Thread(new Runnable() {
			@Override
			public void run() {
			compute();
			}
		});
		
		Thread t2= new Thread(new Runnable() {
			
			@Override
			public void run() {
			compute();
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
		System.out.println("Count1="+ count1 + "--Count2=" +count2);
	}
}
