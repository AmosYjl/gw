package com.monetware.ringspider.commons.service.inter;




import com.monetware.ringspider.base.model.BaseSetting;
import com.monetware.ringspider.commons.util.JsonResult;

import javax.servlet.http.HttpSession;
import java.util.List;

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

  /**
   * 获取LOGO
   * @return
   */
  BaseSetting getLogoSetting();

  /**
   * 获取轮播图列表
   * @return
   */
  List<BaseSetting> getPictureSettings();

  /**
   * 获取广告1
   * @return
   */
  BaseSetting getFirstArticleSettings();

  /**
   * 获取广告位2
   * @return
   */
  BaseSetting getSecondArticleSettings();

  /**
   * 获取广告位3
   * @return
   */
  BaseSetting getThreeArticleSettings();

  /**
   * 获取广告位4
   * @return
   */
  BaseSetting getFourArticleSettings();

  /**
   * 获取广告位5
   * @return
   */
  BaseSetting getFiveArticleSettings();

  /**
   * 获取广告位6
   * @return
   */
  BaseSetting getSixArticleSettings();

  /**
   * 获取广告位7
   * @return
   */
  BaseSetting getSevenArticleSettings();







}
