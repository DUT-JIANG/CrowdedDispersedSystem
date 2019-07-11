package org.model.SchemeMake;

import java.util.concurrent.Semaphore;

public class SchemeMake extends Thread{
	String origin;
	String destination;
	String mode;
	final Semaphore semDB = new Semaphore(100);
	public SchemeMake(
			String origin,
			String destination,
			String mode) {
		this.origin=origin;
		this.destination=destination;
		this.mode=mode;
	}
	@Override
	public void run() {
		if(mode.equals("地址模式")) {
			
		}
	}
}
