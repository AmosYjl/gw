package com.monetware.ringspider.commons.dao;


import com.monetware.ringspider.base.dao.BaseProductMapper;
import com.monetware.ringspider.base.model.BaseProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface ProductDao extends BaseProductMapper {

    List<BaseProduct> getProductList(HashMap map);
}
