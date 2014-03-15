package com.seascape.enterprise.secure.service;

public class Authenticator {

	public static boolean authenticateAccess(String code, String key) {
		
		if ("adroidappu353r9538".equals(code)&&"f671o5MCjqE52vsi97W6L14g54P50u5p".equals(key))
			return true;
		else
			return false;
	}
}
