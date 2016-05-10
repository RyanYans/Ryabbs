package com.rya.bbs.service;

import com.rya.bbs.userbean.UserBean;


/**
 * �ṩ�û�����ӿ�
 * @author Ryan_yuans
 *
 */
public interface IUserService {
	/**
	 * �����û����������ȡ�û�����
	 * @param username
	 * @param password
	 * @return
	 */
	UserBean findUser(String username,String password);
	
	/**
	 * �����û�����ȡ�û����ж��û��Ƿ����
	 * @param name
	 * @return
	 */
	UserBean findUserByName(String username);
	
	/**
	 * �����û�ע����Ϣ
	 * @param user
	 * @return
	 */
	int saveUser(UserBean user);
}