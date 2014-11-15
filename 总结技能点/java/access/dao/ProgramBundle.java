package dao;

import java.util.ResourceBundle;

public final class ProgramBundle {
	private ProgramBundle(){}
	private static final ResourceBundle rb;
	static{
		rb=ResourceBundle.getBundle("program");
	}
	public static String get(String key){
		return rb.getString(key);
	}
}