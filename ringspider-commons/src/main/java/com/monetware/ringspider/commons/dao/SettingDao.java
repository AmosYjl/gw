package com.monetware.ringspider.commons.dao;

import com.monetware.ringspider.base.dao.BaseSettingMapper;
import com.monetware.ringspider.base.model.BaseSetting;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface SettingDao extends BaseSettingMapper{

    List<BaseSetting> getSettingList(HashMap map);

    /**
     * 根据Name获取相关设置
     * @param map
     * @return
     */
    BaseSetting getSettingByName(HashMap map);
}
