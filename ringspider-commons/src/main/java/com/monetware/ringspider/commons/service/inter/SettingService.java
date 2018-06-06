package com.monetware.ringspider.commons.service.inter;




import com.monetware.ringspider.base.model.BaseSetting;
import com.monetware.ringspider.commons.util.JsonResult;

import javax.servlet.http.HttpSession;

/**
 * @author  huqiang
 * @desc 用户模块接口
 */

public interface SettingService {

  JsonResult getSettingListPage(int page,int showCount,String keyWord);


  /**
   * 保存设置
   * @param setting
   * @return
   */
  JsonResult saveSetting(BaseSetting setting);


  /**
   * 获取设置信息
   * @param id
   * @return
   */

  BaseSetting getSettingById(int id);

  BaseSetting getSettingByName(String name);







}
