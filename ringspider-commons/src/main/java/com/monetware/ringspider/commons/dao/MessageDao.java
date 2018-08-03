package com.monetware.ringspider.commons.dao;

import com.monetware.ringspider.base.dao.BaseMessageMapper;
import com.monetware.ringspider.base.model.BaseMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MessageDao extends BaseMessageMapper {

    List<BaseMessage> getMessageList(HashMap map);

    void save(BaseMessage message);
}
