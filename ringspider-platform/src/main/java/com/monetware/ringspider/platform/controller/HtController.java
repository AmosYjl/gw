package com.monetware.ringspider.platform.controller;

import com.monetware.ringspider.base.model.*;
import com.monetware.ringspider.commons.service.inter.*;
import com.monetware.ringspider.commons.util.JsonResult;
import com.monetware.ringspider.commons.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("admin")
public class HtController {

    @Autowired
    private ProductCatService productCatService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private SettingService settingService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private InfoLogService infoLogService;
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "uploadFile",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult uploadFile(MultipartFile file){
        if(file!=null&&!file.isEmpty()){
            //获取文件名
            String[] suffix = file.getOriginalFilename().split("[.]");
            String fileName = UUID.randomUUID() + suffix[1];
            //复制上传的文件到服务器目录下面
            boolean uploadImageFlag = fileService.saveSingleFile(file,"",fileName);
            if (!uploadImageFlag){
                return new JsonResult(false,"上传失败");
            }else{
                return new JsonResult(true,fileName);
            }

        }else{
            return new JsonResult(false,"请检查上传文件！");
        }
    }


    @RequestMapping("/login")
    public String index(){
        return "ht/login";
    }

    @RequestMapping(value = "doLogin",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doLogin(String username,String password,HttpSession session){
        return userService.userLoginValidate(username,password,session);
    }

    @RequestMapping("/home")
    public String home(){
        return "ht/index";
    }

    /**
     * 商品分类列表
     * @return
     */
    @RequestMapping("product_cat/list")
    public String productCatList(){
        return "ht/product_cat_list";
    }

    /**
     * 获取商品分类分页列表
     * @param page
     * @param showCount
     * @param keyWord
     * @return
     */
    @RequestMapping(value = "getProductCatListPage",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getProductCatListPage(int page,int showCount,String keyWord){
        return productCatService.getProductCatListPage(page,showCount,keyWord);
    }

    /**
     * 商品分类详情页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("product_cat/detail")
    public String productCatDetail(int id,Model model){
        if(id!=0){
            BaseProductCat productCat = productCatService.getProductCatById(id);
            model.addAttribute("productCat",productCat);

        }else{
            model.addAttribute("productCat",new BaseProductCat());
        }
        return "ht/product_cat_detail";
    }

    /**
     * 保存商品分类
     * @param productCat
     * @return
     */
    @RequestMapping(value = "saveProductCat",method = RequestMethod.POST)
    @ResponseBody
    public  JsonResult saveProductCat(BaseProductCat productCat){
        return productCatService.saveProductCat(productCat);
    }

    /**
     * 商品列表
     * @return
     */
    @RequestMapping("product/list")
    public String productList(){
        return "ht/product_list";
    }
    @RequestMapping(value = "getProductListPage",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getProductListPage(int page,int showCount,String keyWord){
        return productService.getProductListPage(page,showCount,keyWord);
    }

    /**
     * 商品详情页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("product/detail")
    public String productDetail(int id,Model model){
        if(id!=0){
            BaseProduct product = productService.getProductById(id);
            model.addAttribute("product",product);

        }else{
            model.addAttribute("product",new BaseProduct());
        }
        return "ht/product_detail";
    }

    @RequestMapping(value = "saveProduct",method = RequestMethod.POST)
    @ResponseBody
    public  JsonResult saveProduct(BaseProduct product){
        return productService.saveProduct(product);
    }

    @RequestMapping("user/list")
    public String userList(){
        return "ht/user_list";
    }
    @ResponseBody
    @RequestMapping(value = "getUserListPage",method = RequestMethod.POST)
    public JsonResult getUserListPage(int page,int showCount,String keyWord){
        return userService.getUserListPage(page,showCount,keyWord);
    }
    @RequestMapping("user/detail")
    public String userDetail(int id,Model model){
        if(id!=0){
            BaseUser user = userService.getUserById(id);
            model.addAttribute("user",user);
        }else{
            model.addAttribute("user",new BaseUser());
        }
        return "ht/user_detail";
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @RequestMapping(value = "saveUser",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveUser(BaseUser user){
        return userService.saveUser(user);
    }

    //=======

    /**
     * 系统设置列表
     * @return
     */
    @RequestMapping("setting/list")
    public String settingList(){
        return "ht/setting_list";
    }

    /**
     * 获取系统设置分页列表
     * @param page
     * @param showCount
     * @param keyWord
     * @return
     */
    @RequestMapping(value = "getSettingListPage",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getSettingListPage(int page,int showCount,String keyWord){
        return settingService.getSettingListPage(page,showCount,keyWord);
    }

    @RequestMapping("setting/detail")
    public String settingDetail(int id,Model model){
        if(id!=0){
            BaseSetting setting = settingService.getSettingById(id);
            model.addAttribute("setting",setting);
        }else{
            model.addAttribute("setting",new BaseSetting());
        }
        return "ht/setting_detail";
    }
    /**
     * 保存设置
     * @param setting
     * @return
     */
    @RequestMapping(value = "saveSetting",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveSetting(BaseSetting setting){
        return settingService.saveSetting(setting);
    }

    @RequestMapping("news/list")
    public String newsList(){
        return "ht/news_list";
    }
    @RequestMapping("news/detail")
    public String newsDetail(int id,Model model){
        if(id!=0){
            BaseNews news = newsService.getNewsById(id);
            model.addAttribute("news",news);
        }else{
            BaseNews news = new BaseNews();
            model.addAttribute("news",news);
        }
        return "ht/news_detail";
    }
    @RequestMapping("saveNews")
    @ResponseBody
    public JsonResult saveNews(BaseNews news){
        return newsService.saveNews(news);
    }



}
