package org.ssm.dufy.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.crypto.hash.Md2Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssm.dufy.mapper.UsersMapper;
import org.ssm.dufy.pojo.Users;
import org.ssm.dufy.service.ShiroService;


@Controller
public class ShiroController {
//	@Autowired
//	private ShiroService shiroService;
//	@RequestMapping("testShiroAnnotation")
//	public String testshiro( HttpSession session) {
//		session.setAttribute("key", "value23");
//		shiroService.testMethod();
//		
//		
//		
//		return "redirect:/list.jsp";
//	}
	@Autowired
	private UsersMapper u;
	@RequestMapping("login/test")
	public String a(String username,String password,HttpServletRequest request) {
		System.out.println(username+password);
		Subject subject = SecurityUtils.getSubject();
		if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // rememberme
            token.setRememberMe(true);
            try {
				subject.login(token);
			}catch ( UnknownAccountException uae ) {
				System.out.println("账户不存在------"+uae.getMessage());
                    //账户不存在的操作
                } catch ( IncorrectCredentialsException ice ) {
                	System.out.println("密码|名字不正确------"+ice.getMessage());
                    //密码不正确
                } catch ( LockedAccountException lae ) {
                	System.out.println("用户被锁定------"+lae.getMessage());
                    //用户被锁定了
                } catch ( AuthenticationException ae ) {
                	System.out.println("登录失败-----"+ae.getMessage());
                    //无法判断的情形
                }

        }
		return "redirect:/list.jsp";
	}
	//注册
	@RequestMapping("regsiter")
	@RequiresRoles("admin")
	public String registers(Users users) {
		SimpleHash simpleHash = new SimpleHash("MD5", users.getPassword(), users.getPassword_salt(), 1024);
		String string = simpleHash.toString();
		users.setPassword(string);
		u.addUsers(users);
		return "redirect:/list.jsp";
	}
}
