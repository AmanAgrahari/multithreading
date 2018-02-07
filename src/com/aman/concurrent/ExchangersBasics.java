package com.aman.concurrent;

import java.util.concurrent.Exchanger;



class FirstThread implements Runnable{

	private int counter;
	private Exchanger<Integer> exchanger;
	
	public FirstThread(Exchanger<Integer> exchanger){
		this.exchanger=exchanger;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			counter = counter+1;
			System.out.println("Firstthread increment the counter:" + counter);
			try {
				counter=exchanger.exchange(counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
class SecondThread implements Runnable{

	private int counter;
	private Exchanger<Integer> exchanger;
	
	public SecondThread(Exchanger<Integer> exchanger){
		this.exchanger=exchanger;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			counter = counter-1;
			System.out.println("Secondthread increment the counter:" + counter);
			try {
				counter=exchanger.exchange(counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}	
}
public class ExchangersBasics {

	public ExchangersBasics() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exchanger<Integer> exchanger =new Exchanger<Integer>();
		new Thread(new FirstThread(exchanger)).start();
		new Thread(new SecondThread(exchanger)).start();

	}

}
