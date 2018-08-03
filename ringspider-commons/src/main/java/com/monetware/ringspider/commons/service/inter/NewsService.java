package com.monetware.ringspider.commons.service.inter;

import com.monetware.ringspider.base.model.BaseNews;
import com.monetware.ringspider.base.model.BaseUser;
import com.monetware.ringspider.commons.util.JsonResult;

import javax.servlet.http.HttpSession;
import java.util.List;


public interface NewsService {

  JsonResult saveNews(BaseNews news);

  BaseNews getNewsById(int id);

  JsonResult getNewsListPage(int page,int showCount);

    List<BaseNews> getNewsList();
}
