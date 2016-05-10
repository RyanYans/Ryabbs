package com.rya.bbs.service.impl;

import com.rya.bbs.factory.DaoFactory;
import com.rya.bbs.service.IUserService;
import com.rya.bbs.service.dao.IUserDao;
import com.rya.bbs.service.dao.impl.UserDaoImpl;
import com.rya.bbs.userbean.UserBean;

public class UserServiceImpl implements IUserService {

//	private IUserDao udao = new UserDaoImpl();	//��������ʵ����
//	private IUserDao dao = DaoFactory.newInstance().getUserDao();	//��������Dao�ķ�����ͨ��
	private IUserDao udao= (IUserDao)DaoFactory.newInstance().getDao("USERDAO");
	
	public UserBean findUser(String username, String password) {
		return udao.selectUser(username,password);
	}

	public UserBean findUserByName(String username) {
		return udao.selectUserByName(username);
	}

	public int saveUser(UserBean user) {
		return udao.addUser(user);
	}

}
