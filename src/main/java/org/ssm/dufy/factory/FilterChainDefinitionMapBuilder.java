package org.ssm.dufy.factory;

import java.util.LinkedHashMap;

import com.google.inject.spi.LinkedKeyBinding;

public class FilterChainDefinitionMapBuilder {
	public LinkedHashMap<String, String> filterChainDefinitionMap(){
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		/* /login.jsp = anon
	                /login = anon
	                /logout = logout
	            
	                
	                /user.jsp = roles[С��]
	                /admin.jsp = roles[admin] 
	                
	                # everything else requires authentication:
	                */
		///** = authc fdsfsfsfasf
		linkedHashMap.put("/login", "anon");
		linkedHashMap.put("/logout", "logout");
		linkedHashMap.put("/user.jsp", "roles[user]");
		linkedHashMap.put("/admin.jsp", "authc,roles[admin]");
		linkedHashMap.put("/**","authc");
		return linkedHashMap;
		
	}
}
