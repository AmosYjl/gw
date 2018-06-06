package com.monetware.ringspider.commons.util;

import com.monetware.ringspider.base.model.BaseUser;
import com.monetware.ringspider.commons.constant.UserConstants;

import javax.servlet.http.HttpSession;

/**
 * @author licc
 * session相关的工具方法
 */
public class SessionUtil {


	public static BaseUser
	getCurrentUser(HttpSession session) {
		BaseUser user = (BaseUser) session.getAttribute(UserConstants.SESSION_USER);
		return user;
	}



}
