package org.ssm.dufy.web;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Testcotrollercookiesession {
	
	@RequestMapping("/cookies")
	public String cook( HttpSession session,HttpServletRequest request,HttpServletResponse response){
		Cookie cookie = new Cookie("name1", "zhangsan1");
		response.addCookie(cookie);
		Cookie cookie1 = new Cookie("name2", "zhangsan2");
		response.addCookie(cookie1);
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie c : cookies) {
				if(c.getName().equals("name1")){
					System.out.println("ff");
					c.setMaxAge(5);
				}
				String cookieName = c.getName();

				String cookieValue = c.getValue();

				System.out.println(cookieName + " = "+ cookieValue);

			}

		}
		return "cookie";
	}
	@RequestMapping("/cookies1")
	public String cook2(Model model, String username1,String password2, HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println(username1+password2);
		if("admin".equals(username1) && "123".equals(password2)){
			//获取cookie last-name --- >
			Cookie [] cookies = request.getCookies();
			
			//从数组里面找出我们想要的cookie
			Cookie cookie = Cookieutil.findCookie(cookies, "last");
			
			//是第一次登录，没有cookie
			if(cookie == null){
				
				Cookie c = new Cookie("last", System.currentTimeMillis()+"");
				c.setMaxAge(60*60); //一个小时
				response.addCookie(c);
				model.addAttribute("las", username1);
				
				
			}else{
				/*//1. 去以前的cookie第二次登录，有cookie
				long lastVisitTime = Long.parseLong(cookie.getValue());
				
				//2. 输出到界面，
				response.getWriter().write("欢迎您, "+username1 +",上次来访时间是："+new Date(lastVisitTime));*/
				model.addAttribute("lastw",cookie.getValue());
				System.out.println(cookie.getValue());
				//3. 重置登录的时间
				cookie.setValue(System.currentTimeMillis()+"");
				response.addCookie(cookie);
				return "/WEB-INF/login2.jsp";
			}
		}else{
			response.getWriter().write("登陆失败 ");
		}
		return "cookie";
	}
}
