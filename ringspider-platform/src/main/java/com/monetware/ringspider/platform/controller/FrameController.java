package com.monetware.ringspider.platform.controller;

import com.monetware.ringspider.base.model.BaseProductCat;
import com.monetware.ringspider.base.model.BaseSetting;
import com.monetware.ringspider.commons.service.inter.ProductCatService;
import com.monetware.ringspider.commons.service.inter.SettingService;
import com.monetware.ringspider.commons.service.inter.UserService;
import com.monetware.ringspider.commons.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.List;


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
	@Autowired
	private ProductCatService productCatService;
	@Autowired
	private SettingService settingService;


	/**
	 * 系统入口-
	 * @param session
	 * @return
	 */
	@RequestMapping("/")
	public String index(HttpSession session,Model model) {
		List<BaseProductCat> productCatList = productCatService.getProductCatList();
		BaseSetting logoSetting = settingService.getLogoSetting();
		List<BaseSetting> pictures = settingService.getPictureSettings();//获取轮播图列表
		BaseSetting first = settingService.getFirstArticleSettings();//获取广告1
		BaseSetting second = settingService.getSecondArticleSettings();//获取广告2
		BaseSetting third = settingService.getThreeArticleSettings();//获取广告3
		BaseSetting four = settingService.getFourArticleSettings();//获取广告4
		BaseSetting five = settingService.getFiveArticleSettings();//获取广告5
		BaseSetting six = settingService.getSixArticleSettings();//获取广告6
		BaseSetting seven = settingService.getSevenArticleSettings();//获取广告7
		model.addAttribute("cats",productCatList);
		model.addAttribute("logoSetting",logoSetting);
		model.addAttribute("pictures",pictures);
		model.addAttribute("first",first);
		model.addAttribute("second",second);
		model.addAttribute("third",third);
		model.addAttribute("four",four);
		model.addAttribute("five",five);
		model.addAttribute("six",six);
		model.addAttribute("seven",seven);
		//获取session
		return "home";
	}
	@RequestMapping("/product")
	public String product(HttpSession session,Model model) {
		//获取session
		return "qt/product";
	}
	@RequestMapping("/about_us")
	public String aboutUs(HttpSession session,Model model) {
		//获取session
		return "qt/about_us";
	}
	@RequestMapping("/concat_us")
	public String concatUs(HttpSession session,Model model) {
		//获取session
		return "qt/concat_us";
	}
	@RequestMapping("/news")
	public String news(HttpSession session,Model model) {
		//获取session
		return "qt/news";
	}
	//support
	@RequestMapping("/support")
	public String support(HttpSession session,Model model) {
		//获取session
		return "qt/support";
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


