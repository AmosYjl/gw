package com.monetware.ringspider.commons.service.inter;

import com.monetware.ringspider.base.model.BaseInfoLog;
import com.monetware.ringspider.base.model.BaseUser;
import com.monetware.ringspider.commons.util.JsonResult;

import javax.servlet.http.HttpSession;
import java.util.HashMap;


public interface InfoLogService {

  JsonResult saveInfoLog(BaseInfoLog log);

  HashMap getInfoLog();




}
