package com.monetware.ringspider.platform.controller;

import com.monetware.ringspider.base.model.BaseUser;
import com.monetware.ringspider.commons.util.SessionUtil;

import javax.servlet.http.HttpSession;

/**
 * @author  yangjl
 * @desc 公用方法放在此处
 */
public class BaseController {
    /**
     * 获取当前用户
     * @param session
     * @return
     */
    public BaseUser getCurrentUser(HttpSession session){
        return SessionUtil.getCurrentUser(session);
    }
}
