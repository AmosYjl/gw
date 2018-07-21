package com.monetware.ringspider.commons.service.impl;





import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monetware.ringspider.base.model.BaseSetting;
import com.monetware.ringspider.commons.dao.SettingDao;
import com.monetware.ringspider.commons.service.inter.SettingService;
import com.monetware.ringspider.commons.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
public class SettingServiceImpl implements SettingService {
    @Autowired
    private SettingDao settingDao;

    @Override
    public JsonResult getSettingListPage(int page, int showCount, String keyWord) {
        PageHelper.startPage(page,showCount);
        HashMap paramMap = new HashMap();
        paramMap.put("keyWord",keyWord);
        List<BaseSetting> settingList = settingDao.getSettingList(paramMap);
        PageInfo pageInfo = new PageInfo(settingList);
        return new JsonResult(true,pageInfo);
    }

    @Override
    public JsonResult saveSetting(BaseSetting setting) {
        if(setting.getId()==null || setting.getId() == 0){
            settingDao.insertSelective(setting);
        }else{
            settingDao.updateByPrimaryKeySelective(setting);
        }
        return new JsonResult(true);
    }

    @Override
    public BaseSetting getSettingById(int id) {
        return settingDao.selectByPrimaryKey(id);
    }

    @Override
    public BaseSetting getSettingByName(String name) {
        HashMap paramMap = new HashMap();
        paramMap.put("name",name);
        return settingDao.getSettingByName(paramMap);
    }

    @Override
    public BaseSetting getLogoSetting() {
        HashMap paramMap = new HashMap();
        paramMap.put("type",3);
        List<BaseSetting> settings = settingDao.getSettingList(paramMap);
        if(settings.size()>0){
            return settings.get(0);
        }
        return null;
    }

    @Override
    public List<BaseSetting> getPictureSettings() {
        HashMap paramMap = new HashMap();
        paramMap.put("type",1);
        return settingDao.getSettingList(paramMap);
    }

    @Override
    public BaseSetting getFirstArticleSettings() {
        HashMap paramMap = new HashMap();
        paramMap.put("type",2);
        List<BaseSetting> settings = settingDao.getSettingList(paramMap);
        if(settings.size()>0){
            return settings.get(0);
        }
        return null;
    }

    @Override
    public BaseSetting getSecondArticleSettings() {
        HashMap paramMap = new HashMap();
        paramMap.put("type",4);
        List<BaseSetting> settings = settingDao.getSettingList(paramMap);
        if(settings.size()>0){
            return settings.get(0);
        }
        return null;
    }

    @Override
    public BaseSetting getThreeArticleSettings() {
        HashMap paramMap = new HashMap();
        paramMap.put("type",5);
        List<BaseSetting> settings = settingDao.getSettingList(paramMap);
        if(settings.size()>0){
            return settings.get(0);
        }
        return null;
    }

    @Override
    public BaseSetting getFourArticleSettings() {
        HashMap paramMap = new HashMap();
        paramMap.put("type",6);
        List<BaseSetting> settings = settingDao.getSettingList(paramMap);
        if(settings.size()>0){
            return settings.get(0);
        }
        return null;
    }

    @Override
    public BaseSetting getFiveArticleSettings() {
        HashMap paramMap = new HashMap();
        paramMap.put("type",7);
        List<BaseSetting> settings = settingDao.getSettingList(paramMap);
        if(settings.size()>0){
            return settings.get(0);
        }
        return null;
    }

    @Override
    public BaseSetting getSixArticleSettings() {
        HashMap paramMap = new HashMap();
        paramMap.put("type",8);
        List<BaseSetting> settings = settingDao.getSettingList(paramMap);
        if(settings.size()>0){
            return settings.get(0);
        }
        return null;
    }

    @Override
    public BaseSetting getSevenArticleSettings() {
        HashMap paramMap = new HashMap();
        paramMap.put("type",9);
        List<BaseSetting> settings = settingDao.getSettingList(paramMap);
        if(settings.size()>0){
            return settings.get(0);
        }
        return null;
    }


}
