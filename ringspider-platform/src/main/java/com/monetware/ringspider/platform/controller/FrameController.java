package com.monetware.ringspider.platform.controller;

import com.monetware.ringspider.commons.service.inter.UserService;
import com.monetware.ringspider.commons.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;


/**
 * 
 * @author yjl
 *
 */
@Controller
public class FrameController {
	@Value("${uploaded.dir}")
	private String uploadedDir;
	@Autowired
	private UserService userService;


	/**
	 * 系统入口-
	 * @param session
	 * @return
	 */
	@RequestMapping("/")
	public String index(HttpSession session) {
		//获取session
		return "home";
	}
	@RequestMapping("/product")
	public String product(HttpSession session) {
		//获取session
		return "qt/product";
	}
	@RequestMapping("/about_us")
	public String aboutUs(HttpSession session) {
		//获取session
		return "qt/about_us";
	}
	@RequestMapping("/concat_us")
	public String concatUs(HttpSession session) {
		//获取session
		return "qt/concat_us";
	}
	@RequestMapping("/news")
	public String news(HttpSession session) {
		//获取session
		return "qt/news";
	}



	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doLogin(String username, String password, HttpSession session){

			return userService.userLoginValidate(username, password, session);

	}



	/**
	 * 登出页面
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "logout")
	public String loginOut(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}





}


