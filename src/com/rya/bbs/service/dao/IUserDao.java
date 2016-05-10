package com.rya.bbs.service.dao;

import com.rya.bbs.userbean.UserBean;

/**
 * ���ݷ��ʲ�ӿ�
 * ��User�ķ������ṩ���ݷ���
 * @author Ryan_yuans
 *
 */
public interface IUserDao {

	/**
	 * �����û����������ѯuser��ļ�¼
	 * @param username
	 * @param password
	 * @return
	 */
	UserBean selectUser(String username, String password);

	/**
	 * �����û�����ѯuser���¼
	 * @param name
	 * @return
	 */
	UserBean selectUserByName(String username);

	/**
	 * ���user��Ϣ
	 * @param user
	 * @return
	 */
	int addUser(UserBean user);
	 
}
