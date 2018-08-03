package com.monetware.ringspider.commons.dao;

import com.monetware.ringspider.base.dao.BaseNewsMapper;
import com.monetware.ringspider.base.model.BaseNews;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface NewsDao extends BaseNewsMapper {

    List<BaseNews> getNewsListPage(HashMap map);

    List<BaseNews> getNewsList();
}
