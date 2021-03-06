package com.monetware.ringspider.commons.dao;

import com.monetware.ringspider.base.dao.BaseProductCatMapper;
import com.monetware.ringspider.base.dao.BaseProductMapper;
import com.monetware.ringspider.base.model.BaseProductCat;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface ProductCatDao extends BaseProductCatMapper {

    List<BaseProductCat> getProductCatList(HashMap map);
}
