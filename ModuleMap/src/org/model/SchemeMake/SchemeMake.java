package org.model.SchemeMake;

import java.util.concurrent.Semaphore;

import org.model.SchemeMake.EncodingApi.EncodingRequest;
import org.model.SchemeMake.EncodingApi.EncodingReturn;
import org.model.SchemeMake.Units.point;

public class SchemeMake extends Thread{
	String origin;
	String destination;
	String mode;
	final static Semaphore semDB = new Semaphore(100);
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
			origin=new EncodingReturn(EncodingRequest.SendRequest(origin)).getLocation().toString2();
			destination=new EncodingReturn(EncodingRequest.SendRequest(destination)).getLocation().toString2();
		}
		float lng = Float.parseFloat(origin.substring(0,origin.indexOf(',')));
		float lat = Float.parseFloat(origin.substring(origin.indexOf(',')+1,origin.length()));
		float lng2 = Float.parseFloat(destination.substring(0,destination.indexOf(',')));
		float lat2 = Float.parseFloat(destination.substring(destination.indexOf(',')+1,destination.length()));
		point src = new point(lng,lat);
		point dst = new point(lng2,lat2);
		SchemeMake.semDB.acquireUninterruptibly();
		SchemeMake.semDB.release();
		
	}
}
