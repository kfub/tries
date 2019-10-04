package org.ssm.dufy.web;

import javax.servlet.http.Cookie;

public class Cookieutil {
	
	public static Cookie findCookie(Cookie[] cookies,String name){
		
		
		
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.equals(name)){
					return cookie;
				}
			}
		}
		return null;
	}
}
