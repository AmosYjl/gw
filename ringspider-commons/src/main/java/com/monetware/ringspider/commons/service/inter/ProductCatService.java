package com.monetware.ringspider.commons.service.inter;

import com.monetware.ringspider.base.model.BaseNews;
import com.monetware.ringspider.base.model.BaseProductCat;
import com.monetware.ringspider.base.model.BaseUser;
import com.monetware.ringspider.commons.util.JsonResult;

import javax.servlet.http.HttpSession;
import java.util.List;


public interface ProductCatService {

  JsonResult saveProductCat(BaseProductCat cat);

  BaseProductCat getProductCatById(int id);

  JsonResult getProductCatListPage(int page,int showCount,String keyWord);

  List<BaseProductCat> getProductCatList();




}
