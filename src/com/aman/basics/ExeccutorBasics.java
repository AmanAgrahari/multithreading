package com.aman.basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



class worker3 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			System.out.println(i);
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
}
public class ExeccutorBasics {

public static void main(String []args)
{
	//ExecutorService executorService=Executors.newFixedThreadPool(3);
	//ExecutorService executorService=Executors.newSingleThreadExecutor();
	ExecutorService executorService=Executors.newCachedThreadPool();
	
	// 5 tasks with 5 workers and we have exactly 5 threads
	for(int i=0;i<5;i++){
		executorService.submit(new worker3());
	}
}

}
