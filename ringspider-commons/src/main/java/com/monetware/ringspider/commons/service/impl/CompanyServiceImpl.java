package com.monetware.ringspider.commons.service.impl;

import com.monetware.ringspider.base.model.BaseCompany;
import com.monetware.ringspider.base.model.BaseMessage;
import com.monetware.ringspider.commons.dao.CompanyDao;
import com.monetware.ringspider.commons.dao.MessageDao;
import com.monetware.ringspider.commons.service.inter.CompanyService;
import com.monetware.ringspider.commons.service.inter.MessageService;
import com.monetware.ringspider.commons.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public JsonResult saveMessage(BaseCompany message) {
        if(message.getId() == null || message.getId() == 0){
            companyDao.insertSelective(message);
        }else {
            companyDao.updateByPrimaryKeySelective(message);
        }
        return new JsonResult(true);
    }

    @Override
    public BaseCompany getMessageById(int id) {
        return companyDao.getMessageById(id);
    }
}
