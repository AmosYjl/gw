package com.monetware.ringspider.commons.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monetware.ringspider.base.model.BaseUser;
import com.monetware.ringspider.commons.constant.UserConstants;
import com.monetware.ringspider.commons.dao.UserDao;
import com.monetware.ringspider.commons.service.inter.FileService;
import com.monetware.ringspider.commons.service.inter.UserService;
import com.monetware.ringspider.commons.util.JsonResult;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements  UserService {

    @Value("${uploaded.dir}")
    private String uploadedDir;

    @Autowired
    private UserDao userDao;
    @Autowired
    private FileService fileService;

    @Override
    public JsonResult userLoginValidate(String username, String password, HttpSession session) {
        HashMap map = new HashMap();
        map.put("username", username);
        map.put("password", password);
        BaseUser user = userDao.loadUserByUserNameAndPassword(map);
        if (user == null) {
            return new JsonResult(false, "登录失败，请检查账号密码");
        } else {
            session.setAttribute(UserConstants.SESSION_USER, user);
            return new JsonResult(true, "登录成功！");
        }

    }

    @Override
    public JsonResult saveUser(BaseUser user) {
        int rows = 0;
        if (user.getId() == null || user.getId() == 0) {
            rows = userDao.insertSelective(user);
        } else {
            rows = userDao.updateByPrimaryKeySelective(user);
        }
        if (rows >= 0) {
            return new JsonResult(true, "保存成功!");
        }
        return null;
    }



    @Override
    public BaseUser getUserById(int id) {
        BaseUser baseUser = userDao.selectByPrimaryKey(id);
        return baseUser;
    }

    @Override
    public int updatePassword(int id, String oldPassword, String newPassword) {
        BaseUser user = userDao.selectByPrimaryKey( id);
        if (!user.getPassword().equals(oldPassword)) {
            return 0;
        }
        BaseUser user2 = new BaseUser();
        user2.setId(id);
        user2.setPassword(newPassword);
        return userDao.updateByPrimaryKeySelective(user2);
    }

    @Override
    public JsonResult getUserListPage(int page, int showCount, String keyWord) {
        HashMap paramMap = new HashMap();
        paramMap.put("keyWord",keyWord);
        PageHelper.startPage(page,showCount);
        List<BaseUser> userList = userDao.getUserList(paramMap);
        PageInfo pageInfo = new PageInfo(userList);
        return new JsonResult(true,pageInfo);
    }


}
