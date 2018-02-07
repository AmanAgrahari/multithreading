package com.aman.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class Procesor2 implements Callable<String>{

	private int id;
	
	public Procesor2(int id) {
	
		this.id=id;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String call() throws Exception {
		// note this call method throws an exception but the run method doesnt throws the exception
		Thread.sleep(1000);
		return "Id: "+id;
	}
	
}
public class CallableAndFuture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService=Executors.newFixedThreadPool(2);
		
		List<Future<String>> list =new ArrayList<Future<String>>();
		
		//5 task 
		for(int i=0;i<5;i++){
			Future<String>future =executorService.submit(new Procesor2(i+1));
			list.add(future);
		}
		for(Future<String>future:list){
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		executorService.shutdown();
		
	}

}
