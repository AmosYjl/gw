package com.monetware.ringspider.commons.dao;

import com.monetware.ringspider.base.dao.BaseInfoLogMapper;
import com.monetware.ringspider.base.model.BaseInfoLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface InfoLogDao extends BaseInfoLogMapper {

    List<BaseInfoLog> getInfoLogsList(HashMap map);
}
