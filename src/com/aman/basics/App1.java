package com.aman.basics;

class Runner12 extends Thread{
@Override
public void run() {
	// TODO Auto-generated method stub
	for(int i=0;i<10;i++){
		System.out.println("Runner1:"+i);
	}
}
}

class Runner21 extends Thread{
@Override
public void run() {
	// TODO Auto-generated method stub
	for(int i=0;i<10;i++){
		System.out.println("Runner2:"+i);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}



public class App1 {
	public static void main(String[] args) {
	
		
	Runner12 t1 = new Runner12();
	Runner21 t2 = new Runner21();
	
	t1.start();
	t2.start();
	try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Finished the task");
	}

}
