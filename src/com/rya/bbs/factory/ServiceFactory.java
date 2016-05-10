package com.rya.bbs.factory;

import java.util.ResourceBundle;

import com.rya.bbs.service.dao.IUserDao;

/**
 * ��������Service�Ĺ�����
 * @author Ryan_yuans
 *
 */
public class ServiceFactory {
	//Service��������
	private static ServiceFactory factory = new ServiceFactory();
	private static ResourceBundle BUNDLE = ResourceBundle.getBundle("com.rya.bbs.properties.service");
	
	//�ѹ��췽��˽�л�
	private ServiceFactory(){
		
	}
	
	public static ServiceFactory newInstance() {
		return factory;
	}


	public Object getService(String clazz){
		Object service = null;
		
		String classPath = BUNDLE.getString(clazz);
		try {
			service = (Object)Class.forName(classPath).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return service;
	}
	
}
