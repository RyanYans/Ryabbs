package com.rya.bbs.factory;

import java.util.ResourceBundle;

import com.rya.bbs.service.dao.IUserDao;

/**
 * ��������Dao�Ĺ�����
 * @author Ryan_yuans
 *
 */
public class DaoFactory {
	//Dao��������
	private static DaoFactory factory = new DaoFactory();
	private static ResourceBundle BUNDLE = ResourceBundle.getBundle("com.rya.bbs.properties.dao");
	
	//�ѹ��췽��˽�л�
	private DaoFactory(){
		
	}
	
	public static DaoFactory newInstance() {
		return factory;
	}

	public IUserDao getUserDao(){ 
		IUserDao dao = null;
		
		//��ȡ��Դ�ļ���ָ�����Ƶ�ֵ��
		String daoPath = BUNDLE.getString("USERDAO");
		
		//ʹ���ֽ����ļ���ȡʵ��������
		try {
			dao = (IUserDao)Class.forName(daoPath).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dao;
	}
	
	public Object getDao(String clazz){
		Object dao = null;
		
		String classPath = BUNDLE.getString(clazz);
		try {
			dao = (Object)Class.forName(classPath).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dao;
	}
	
}
