package my.util;

import java.util.ResourceBundle;

public final class ProgramBundle {
	private static final ResourceBundle rb;
	static{
		rb=ResourceBundle.getBundle("config");
	}
	public static String getString(String key){
		return rb.getString(key);
	}
}