package com.aman.basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


//this singleton pattern is thread safe
enum Downloader{
	INSTANCE;
	private Semaphore semaphore=new Semaphore(3, true);
	
	public void downlaodData(){
		try {
			semaphore.acquire();
			downlaod();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			semaphore.release();
		}
	}
	
	private void downlaod(){
		System.out.println("Downloading the data from the web");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class Semaphores {
	public static void main(String[] args){
		
		ExecutorService executorService =Executors.newCachedThreadPool();
		for(int i=0;i<12;i++){
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Downloader.INSTANCE.downlaodData();
				}
			});
		}
	}

}
