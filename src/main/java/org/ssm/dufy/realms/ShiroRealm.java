package org.ssm.dufy.realms;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.ssm.dufy.mapper.UserMapper;
import org.ssm.dufy.pojo.User;

public class ShiroRealm extends  AuthorizingRealm{
	@Autowired
	private UserMapper u;
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//将token强转为UsernamePasswordToken
		UsernamePasswordToken token2 = (UsernamePasswordToken) token;
		try {
			//获取页面的用户名使用了MD5加密
			String username = token2.getUsername();
			//使用了MD5加密 在配置文件写了用MD5 加密次数
			char[] password = token2.getPassword();
			//获取数据库的用户名
			User shirouser = u.shirouser(username);
			//得到名字
			String username2 = shirouser.getUsername();
			//得到密码
			String password2 = shirouser.getPassword();
			//将得到的密码使用MD5加密 username2 在数据库里的名字的唯一 这四个参数的意思 ();
			//               [ˈælɡəˌrɪðəm]
			//					算法名称		对他加密      加盐值   叠加次数 
			//new SimpleHash(algorithmName, source,    salt,  hashIterations);
			SimpleHash simpleHash = new SimpleHash("MD5", password2, username2, 1024);
			
			System.out.println("后MD5加密的密码---"+simpleHash);
			System.out.println("---------------"+username2+"-----"+password2);
			//String org.apache.shiro.realm.CachingRealm.getName()
			// 获取当前对象的name
			String realmName = getName();
			//盐值
			ByteSource credentialsSalt = ByteSource.Util.bytes(username2);
			//验证用户名和密码是否一致
			SimpleAuthenticationInfo info =  null;
			info = new SimpleAuthenticationInfo(username2, simpleHash, credentialsSalt, realmName);
			return info;

			
		} catch (Exception e) {
			System.out.println("数据库里没有这个名字");
		}
		
		return null;
	}
	//授权要使用的方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection Principal) {
		System.out.println("授权要使用的方法");
		//从PrincipalCollection中获取登录用户信息
		Object primaryPrincipal = Principal.getPrimaryPrincipal();
		System.out.println(primaryPrincipal+"000000000------------000000");
		//利用登录的用户信息来获取当前用户的角色或权限（可能需要查询数据库）
		/*User shirouser = u.shirouser(username);*/
		Set<String> roles = new HashSet<>();
		roles.add("小明");
		roles.add((String) primaryPrincipal);
		//创建SimpleAuthorizationInfo,并设置reles属性，
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		//返回SimpleAuthorizationInfo 对象，
		return info;
	}
public static void main(String[] args) {
	String a = "MD5";
	Object w = "111";
	Object sal = null;
	int f = 1024;
	SimpleHash simpleHash = new SimpleHash(a, w, sal, f);
	System.out.println(simpleHash);
}

}
