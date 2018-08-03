package com.monetware.ringspider.platform.controller;

import com.monetware.ringspider.base.model.*;
import com.monetware.ringspider.commons.service.inter.*;
import com.monetware.ringspider.commons.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
	private ProductService productService;
    @Autowired
	NewsService newsService;
    @Autowired
	MessageService messageService;
    @Autowired
	CompanyService companyService;
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
	@RequestMapping("/getProductsByCat")
	public String product(HttpSession session,String catName,Model model) {

		//调用service
		JsonResult result=productService.getProductListByCat(catName);
		model.addAttribute("result",result);
		return "qt/product";
	}
	@RequestMapping("/about_us")
	public String aboutUs(HttpSession session,Model model) {
		//获取session
		return "qt/about_us";
	}
	@RequestMapping("/concat_us")
	public String concatUs(HttpSession session,Model model) {
		//从数据库中获取到公司的基本信息
		BaseCompany company=companyService.getMessageById(1);
		//将数据压栈
		model.addAttribute("company",company);
		return "qt/concat_us";
	}
	//concat_us 页面提交留言
	@RequestMapping("/submmit_message")
	public String submmit(BaseMessage message,Model model){
		//将接收到的对象存入数据库中，message表
	   JsonResult result=	messageService.saveMessage(message);

		//返回true时页面跳出弹框显示提交成功
		return "qt/success";
	}
	@RequestMapping("/news")
	public String news(HttpSession session,Model model) {
		//获取session

		List<BaseNews> list=newsService.getNewsList();
		model.addAttribute("list",list);
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


