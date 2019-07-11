package org.model.SchemeMake.Units;

public class edge {
	private int ID;
	public void setID(int ID) {
		this.ID=ID;
	}
	private point src;
	private point dst;
	private int rode_type;
	public edge(point src,point dst,int rode_type) {
		this.src=src;
		this.dst=dst;
		this.rode_type=rode_type;
	}
	
}
