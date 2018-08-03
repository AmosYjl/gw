package com.monetware.ringspider.commons.dao;


import com.monetware.ringspider.base.dao.BaseProductMapper;
import com.monetware.ringspider.base.model.BaseProduct;
import com.monetware.ringspider.commons.util.JsonResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ProductDao extends BaseProductMapper {
   /* BaseProduct getProductById(int id);
    JsonResult saveProduct(BaseProduct product);*/
    JsonResult getProductListPage(int page, int showCount, String keyWord);
    List<BaseProduct> getProductList(HashMap paramMap);

    List<BaseProduct> getProductListByCat(String catName);
}
