package org.ssm.dufy.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.ssm.dufy.mapper.UserMapper;
import org.ssm.dufy.mapper.UsersMapper;
import org.ssm.dufy.pojo.User;
import org.ssm.dufy.pojo.Users;

public class SecondRealm extends AuthenticatingRealm {
	@Autowired
	private UsersMapper u;
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//强转UsernamePasswordToken
		UsernamePasswordToken token2 = (UsernamePasswordToken) token;
		try {
			//获取表单的username
			String username = token2.getUsername();
			//ʹ
			char[] password = token2.getPassword();
			// 从数据库获取这个名字的所有数据
			Users shirousers = u.findone(username);
			//获取名字
			String username2 = shirousers.getUsername();
			//获取密码
			String password2 = shirousers.getPassword();
			//对密码进行加密
			SimpleHash simpleHash = new SimpleHash("SHA1", password2, username2, 1024);
			System.out.println("SHA1加密---"+simpleHash);
			System.out.println("---------------"+username2+"-----"+password2);
			//String org.apache.shiro.realm.CachingRealm.getName()
			//当前对象名org.ssm.dufy.realms.SecondRealm_0
			String realmName = getName();
			System.out.println(realmName+"=---------------------realmName--------------------");
			//加盐ֵ
			ByteSource credentialsSalt = ByteSource.Util.bytes(username2);
			//
			SimpleAuthenticationInfo info =  null;
			info = new SimpleAuthenticationInfo(username2, password2, credentialsSalt, realmName);
			return info;

			
		} catch (Exception e) {
			System.out.println("出现异常");
		}
		
		return null;
	}
	public static void main(String[] args) {
		SimpleHash simpleHash = new SimpleHash("SHA1", "123","test", 1024);
		System.out.println(simpleHash);
		//ed37d4d08e298193f5c2cf6fb6f5b10be6a2d3cd
	}
	
}
