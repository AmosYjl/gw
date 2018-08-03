package com.monetware.ringspider.commons.service.impl;

import com.monetware.ringspider.base.model.BaseMessage;
import com.monetware.ringspider.base.model.BaseUser;
import com.monetware.ringspider.commons.constant.UserConstants;
import com.monetware.ringspider.commons.dao.MessageDao;
import com.monetware.ringspider.commons.dao.UserDao;
import com.monetware.ringspider.commons.service.inter.FileService;
import com.monetware.ringspider.commons.service.inter.MessageService;
import com.monetware.ringspider.commons.service.inter.UserService;
import com.monetware.ringspider.commons.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public JsonResult saveMessage(BaseMessage message) {
        if(message.getId() == null || message.getId() == 0){
            messageDao.save(message);
        }else {
            messageDao.updateByPrimaryKeySelective(message);
        }
        return new JsonResult(true);
    }

    @Override
    public BaseMessage getMessageById(int id) {
        return messageDao.selectByPrimaryKey(id);
    }
}
