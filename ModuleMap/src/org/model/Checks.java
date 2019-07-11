package org.model;

public class Checks {
	public static boolean checkNULL(String Attribute) {
		if(Attribute==null){
			return true;
		}
		return false;
	}
	//when illeagal returns true
	public static boolean checkEmpty(String EventName) {
		if(EventName.equals("")){
			return true;
		}
		return false;
	}
}
