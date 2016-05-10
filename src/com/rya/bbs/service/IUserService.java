package com.rya.bbs.service;

import com.rya.bbs.userbean.UserBean;


/**
 * 提供用户服务接口
 * @author Ryan_yuans
 *
 */
public interface IUserService {
	/**
	 * 根据用户名和密码获取用户对象
	 * @param username
	 * @param password
	 * @return
	 */
	UserBean findUser(String username,String password);
	
	/**
	 * 根据用户名获取用户，判断用户是否存在
	 * @param name
	 * @return
	 */
	UserBean findUserByName(String username);
	
	/**
	 * 保存用户注册信息
	 * @param user
	 * @return
	 */
	int saveUser(UserBean user);
}