package com.monetware.ringspider.commons.service.inter;

import com.monetware.ringspider.base.model.BaseCompany;
import com.monetware.ringspider.base.model.BaseMessage;
import com.monetware.ringspider.commons.util.JsonResult;

import java.util.List;


public interface CompanyService {

  JsonResult saveMessage(BaseCompany message);

  BaseCompany getMessageById(int id);





}
