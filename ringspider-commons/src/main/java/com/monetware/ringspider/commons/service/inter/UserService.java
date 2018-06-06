package com.monetware.ringspider.commons.service.inter;

import com.monetware.ringspider.base.model.BaseUser;
import com.monetware.ringspider.commons.util.JsonResult;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface UserService {
  /**
   * 用户登陆操作
   * @param username
   * @param password
   * @param session
   * @return
   */
  JsonResult userLoginValidate(String username, String password, HttpSession session);

  /**
   * 保存用户操作
   * @param user
   * @return
   */
  JsonResult saveUser(BaseUser user);

  /**
   * 获取用户信息
   * @param id
   * @return
   */

  BaseUser getUserById(int id);

  /**
   * 密码修改
   * @param id
   * @return
   */
  int updatePassword( int id, String oldPassword, String newPassword);

  /**
   * 获取用户分页列表
   * @param page
   * @param showCount
   * @param keyWord
   * @return
   */
  JsonResult getUserListPage(int page,int showCount,String keyWord);




}
