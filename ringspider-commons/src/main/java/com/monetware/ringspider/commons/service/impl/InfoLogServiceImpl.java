package com.monetware.ringspider.commons.service.impl;

import com.monetware.ringspider.base.model.BaseInfoLog;
import com.monetware.ringspider.base.model.BaseUser;
import com.monetware.ringspider.commons.constant.UserConstants;
import com.monetware.ringspider.commons.dao.InfoLogDao;
import com.monetware.ringspider.commons.dao.UserDao;
import com.monetware.ringspider.commons.service.inter.FileService;
import com.monetware.ringspider.commons.service.inter.InfoLogService;
import com.monetware.ringspider.commons.service.inter.UserService;
import com.monetware.ringspider.commons.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service
public class InfoLogServiceImpl implements InfoLogService {

    @Autowired
    private InfoLogDao infoLogDao;

    @Override
    public JsonResult saveInfoLog(BaseInfoLog log) {
        infoLogDao.insertSelective(log);
        return new JsonResult(true);
    }

    @Override
    public HashMap getInfoLog() {
        return null;
    }
}
