package com.rya.bbs.factory;

import java.util.ResourceBundle;

import com.rya.bbs.service.dao.IUserDao;

/**
 * 负责生产Service的工厂类
 * @author Ryan_yuans
 *
 */
public class ServiceFactory {
	//Service工厂对象
	private static ServiceFactory factory = new ServiceFactory();
	private static ResourceBundle BUNDLE = ResourceBundle.getBundle("com.rya.bbs.properties.service");
	
	//把构造方法私有化
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
