package com.monetware.ringspider.commons.service.inter;

import com.monetware.ringspider.base.model.BaseProduct;
import com.monetware.ringspider.base.model.BaseProductCat;
import com.monetware.ringspider.base.model.BaseUser;
import com.monetware.ringspider.commons.util.JsonResult;

import javax.servlet.http.HttpSession;

public interface ProductService {
  JsonResult saveProduct(BaseProduct product);

  BaseProduct getProductById(int id);

  /**
   * 获取商品分页列表
   * @param page
   * @param showCount
   * @param keyWord
   * @return
   */
  JsonResult getProductListPage(int page,int showCount,String keyWord);




}
