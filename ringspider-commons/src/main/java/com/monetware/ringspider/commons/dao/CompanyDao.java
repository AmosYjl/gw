package com.monetware.ringspider.commons.dao;

import com.monetware.ringspider.base.dao.BaseCompanyMapper;
import com.monetware.ringspider.base.dao.BaseMessageMapper;
import com.monetware.ringspider.base.model.BaseCompany;
import com.monetware.ringspider.base.model.BaseMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CompanyDao extends BaseCompanyMapper {

    List<BaseCompany> getMessageList(HashMap map);
    BaseCompany getMessageById(int id);
}
