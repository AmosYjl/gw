package com.monetware.ringspider.commons.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monetware.ringspider.base.model.BaseNews;
import com.monetware.ringspider.base.model.BaseUser;
import com.monetware.ringspider.commons.constant.UserConstants;
import com.monetware.ringspider.commons.dao.NewsDao;
import com.monetware.ringspider.commons.dao.UserDao;
import com.monetware.ringspider.commons.service.inter.FileService;
import com.monetware.ringspider.commons.service.inter.NewsService;
import com.monetware.ringspider.commons.service.inter.UserService;
import com.monetware.ringspider.commons.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;


    @Override
    public JsonResult saveNews(BaseNews news) {
        if(news.getId() == null || news.getId() == 0){
            newsDao.insertSelective(news);
        }else{
            newsDao.updateByPrimaryKeySelective(news);
        }
        return new JsonResult(true);
    }

    @Override
    public BaseNews getNewsById(int id) {
        return newsDao.selectByPrimaryKey(id);
    }

    @Override
    public JsonResult getNewsListPage(int page, int showCount) {
        PageHelper.startPage(page,showCount);
        List<BaseNews> newsList = newsDao.getNewsListPage(new HashMap());
        PageInfo pageInfo = new PageInfo(newsList);
        return new JsonResult(true,pageInfo);
    }
}
