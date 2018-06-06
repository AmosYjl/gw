package com.monetware.ringspider.commons.dao;

import com.monetware.ringspider.base.dao.BaseUserMapper;
import com.monetware.ringspider.base.model.BaseUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserDao extends BaseUserMapper {
    /**
     * 根据用户名称和密码获取相关用户
     * @param map
     * @return
     */
    BaseUser loadUserByUserNameAndPassword(HashMap map);

    /**
     * 根据用户名称和电话号码获取相关用户
     * @param map
     * @return
     */
    BaseUser getUserByUserNameAndTel(HashMap map);

    List<BaseUser> getUserList(HashMap map);

}
