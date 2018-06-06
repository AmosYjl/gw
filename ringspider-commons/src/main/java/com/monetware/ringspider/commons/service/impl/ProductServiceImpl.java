package com.monetware.ringspider.commons.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monetware.ringspider.base.model.BaseProduct;
import com.monetware.ringspider.base.model.BaseUser;
import com.monetware.ringspider.commons.constant.UserConstants;
import com.monetware.ringspider.commons.dao.ProductDao;
import com.monetware.ringspider.commons.dao.UserDao;
import com.monetware.ringspider.commons.service.inter.FileService;
import com.monetware.ringspider.commons.service.inter.ProductService;
import com.monetware.ringspider.commons.service.inter.UserService;
import com.monetware.ringspider.commons.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

   @Autowired
    private ProductDao productDao;

    @Override
    public JsonResult saveProduct(BaseProduct product) {
        if(product.getId() == 0 || product.getId() == null){
            productDao.insertSelective(product);
        }else{
            productDao.updateByPrimaryKeySelective(product);
        }
        return new JsonResult(true);
    }

    @Override
    public BaseProduct getProductById(int id) {
        return productDao.selectByPrimaryKey(id);
    }

    @Override
    public JsonResult getProductListPage(int page, int showCount, String keyWord) {
        HashMap paramMap = new HashMap();
        paramMap.put("keyWord",keyWord);
        PageHelper.startPage(page,showCount);
        List<BaseProduct> productList = productDao.getProductList(paramMap);
        PageInfo pageInfo = new PageInfo(productList);
        return new JsonResult(true,pageInfo);
    }
}
