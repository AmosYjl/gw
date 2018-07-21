package com.monetware.ringspider.commons.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monetware.ringspider.base.model.BaseProductCat;
import com.monetware.ringspider.base.model.BaseUser;
import com.monetware.ringspider.commons.constant.UserConstants;
import com.monetware.ringspider.commons.dao.ProductCatDao;
import com.monetware.ringspider.commons.dao.UserDao;
import com.monetware.ringspider.commons.service.inter.FileService;
import com.monetware.ringspider.commons.service.inter.ProductCatService;
import com.monetware.ringspider.commons.service.inter.UserService;
import com.monetware.ringspider.commons.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


@Service
public class ProductCatServiceImpl implements ProductCatService {


    @Autowired
    private ProductCatDao productCatDao;


    @Override
    public JsonResult saveProductCat(BaseProductCat cat) {
        if( cat.getId() == null || cat.getId() == 0){
            productCatDao.insertSelective(cat);
        }else{
            productCatDao.updateByPrimaryKeySelective(cat);
        }
        return new JsonResult(true);
    }

    @Override
    public BaseProductCat getProductCatById(int id) {
        return productCatDao.selectByPrimaryKey(id);
    }

    @Override
    public JsonResult getProductCatListPage(int page, int showCount, String keyWord) {
        HashMap paramMap = new HashMap();
        paramMap.put("keyWord",keyWord);
        PageHelper.startPage(page, showCount);
        List<BaseProductCat> productCatList = productCatDao.getProductCatList(paramMap);
        PageInfo pageInfo = new PageInfo(productCatList);
        return new JsonResult(true,pageInfo);
    }

    @Override
    public List<BaseProductCat> getProductCatList() {
        HashMap paramMap = new HashMap();

        List<BaseProductCat> productCatList = productCatDao.getProductCatList(paramMap);
        return productCatList;
    }
}
