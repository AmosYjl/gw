package com.monetware.ringspider.commons.service.inter;

import com.monetware.ringspider.base.model.BaseMessage;
import com.monetware.ringspider.base.model.BaseUser;
import com.monetware.ringspider.commons.util.JsonResult;

import javax.servlet.http.HttpSession;


public interface MessageService {

  JsonResult saveMessage(BaseMessage message);

  BaseMessage getMessageById(int id);



}
