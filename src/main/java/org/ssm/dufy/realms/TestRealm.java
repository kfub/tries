package org.ssm.dufy.realms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.ssm.dufy.mapper.UsersMapper;
import org.ssm.dufy.pojo.Users;

public class TestRealm extends AuthorizingRealm {
	
	  @Autowired 
	  private UsersMapper users;
	  //认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token){
		UsernamePasswordToken token2 = (UsernamePasswordToken) token;
		String username = token2.getUsername();
		Users usersname= users.findone(username);
		//加盐值
		ByteSource bytes = ByteSource.Util.bytes(usersname.getPassword_salt());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,usersname.getPassword(),bytes,getName());
		String string = info.toString();
		System.out.println(string+"--------------------ddddddddddddddddddddddd");
		return info;
	}
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		System.out.println("进入授权方法-----------------------解放军防控方面来看来看看");
		//页面传入的username
		Object primaryPrincipal = principal.getPrimaryPrincipal();
		System.out.println(primaryPrincipal);
		//从数据库查询所有进行匹配 存入set
		Set<String> roles = new HashSet<>();
		List<Users> findAll = users.findAll();
		for (Users users : findAll) {
			if(users.getUsername().equals(primaryPrincipal)) {
			roles.add(users.getUsername());
			}
		}
		//将角色返回如果有这个角色的权限的页面就能点开
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		//获取当前登录角色
		Set<String> roles2 = info.getRoles();
		for (String string : roles2) {
			System.out.println("role2--------------------"+string);
		}
		return info;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		SimpleHash simpleHash = new SimpleHash("MD5", "123","admin", 1024);
		System.out.println(simpleHash);
		//5d15b589d37c26571370e4e6c1f1b2a1
		//f826bba46f080a565bf74522416d5b95
	}
	


}
