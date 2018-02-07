package com.aman.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;


class DelayedWorker implements Delayed{

	private long duration;
	private String message;
	
	public DelayedWorker(long duration,String message) {
	this.duration=System.currentTimeMillis()+duration;
	this.message=message;
	}
	
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override //items are sorted according to the delayed parameters
	public int compareTo(Delayed otherDelayed) {
		// TODO Auto-generated method stub
		if(this.duration<(((DelayedWorker) otherDelayed).getDuration())){
		return -1;
		}
		if(this.duration>(((DelayedWorker) otherDelayed).getDuration())){
			return +1;
			}
		return 0;
	}
	
	//how much time u have to wait if u had to get the item from the delayed queue
	@Override
	public long getDelay(TimeUnit unit) {
		
		return unit.convert(duration-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
	}
	
	@Override
	public String toString(){
		return this.message;
	}

	
}

public class DelayedQueueBasics {
	public static void main(String[] args) {
	
		BlockingQueue<DelayedWorker> queue = new DelayQueue<>();
		try {
			queue.put(new DelayedWorker(1000,"this is the first message"));
			queue.put(new DelayedWorker(10000,"this is the second message"));
			queue.put(new DelayedWorker(4000,"this is the third message"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!queue.isEmpty()){
			try {
				System.out.println(queue.take());
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println("good");
	}
}
