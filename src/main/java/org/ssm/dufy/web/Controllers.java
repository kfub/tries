package org.ssm.dufy.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.ssm.dufy.pojo.QueryVo;
import org.ssm.dufy.pojo.User;
import org.ssm.dufy.service.UserService;


/**
 * 绠�鍗曠殑crud
 * @author yoho
 *
 */
@Controller()
public class Controllers {
	@Resource
	private UserService u;
	@Resource
	private User user;
	 
	
	/**
	 * 
	 * @param model
	 * @return 杩斿洖鍒�/trier/src/main/webapp/WEB-INF/jsp/index.jsp鏂囦欢
	 */
	@RequestMapping(value="a1dd")
	public String selectAlls(Model model){
		List<User> findAll = u.findAll();
		
		model.addAttribute("user", findAll);
		
		return "index";
		
	}
	@RequestMapping(value="a1")
	public String selectAll(Model model){
		List<User> findAll = u.findAll();
		model.addAttribute("user", findAll);
		return "index";
		
	}
	@ResponseBody
	@RequestMapping("/deletes")
	public void deleteUser(int id){
		
		u.deleteUser(id);
	}
	
	@RequestMapping("/update")
	public String updateone(int id,Model model){
		User user = u.updateone(id);
		model.addAttribute("user", user);
		return "update";
	}
	
	@Transactional
	@RequestMapping("/updateing")
	public String updateing(User us){
		
		 u.updateing(us);
		 
		return "redirect:/a1";
	}
	
	
	@RequestMapping(value={"add","adds"})
	public String adduser(User us ,String register){
		System.out.println(register);
		if(us.getUsername()==null) {
		return "add";
		}else if(register=="注册") {
			return "redirect:/";
		}
		u.add(us);
		return "redirect:/a1";
	}
	 @ResponseBody
	@RequestMapping("/batchDel")
	public String dels(@RequestParam(value = "vals[]")  Integer[]  vals){
		u.batchdelete(vals);
		return "redirect:/a1";
	}
	 @ResponseBody
	 @RequestMapping(value="findlike")
	 public ModelAndView findlike(QueryVo vo,String str ){
		 System.out.println(str);
		 user.setUsername(str);
		 vo.setUser(user);
		 
		 System.out.println(vo.getUser()+"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		//System.out.println(vo.getUser().getUsername());
		 
		 //List<User> findlike = u.findlike(vo);
	
		 ModelAndView model = new ModelAndView();
		 model.addObject("user", vo);
		 model.setViewName("index");
		 
		 return model;
	 }
}
