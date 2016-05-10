package com.rya.bbs.service.dao;

import com.rya.bbs.userbean.UserBean;

/**
 * 数据访问层接口
 * 给User的服务类提供数据访问
 * @author Ryan_yuans
 *
 */
public interface IUserDao {

	/**
	 * 根据用户名和密码查询user表的记录
	 * @param username
	 * @param password
	 * @return
	 */
	UserBean selectUser(String username, String password);

	/**
	 * 根据用户名查询user表记录
	 * @param name
	 * @return
	 */
	UserBean selectUserByName(String username);

	/**
	 * 添加user信息
	 * @param user
	 * @return
	 */
	int addUser(UserBean user);
	 
}
