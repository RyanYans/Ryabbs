package com.rya.bbs.factory;

import java.util.ResourceBundle;

import com.rya.bbs.service.dao.IUserDao;

/**
 * 负责生产Dao的工厂类
 * @author Ryan_yuans
 *
 */
public class DaoFactory {
	//Dao工厂对象
	private static DaoFactory factory = new DaoFactory();
	private static ResourceBundle BUNDLE = ResourceBundle.getBundle("com.rya.bbs.properties.dao");
	
	//把构造方法私有化
	private DaoFactory(){
		
	}
	
	public static DaoFactory newInstance() {
		return factory;
	}

	public IUserDao getUserDao(){ 
		IUserDao dao = null;
		
		//获取资源文件中指定名称的值；
		String daoPath = BUNDLE.getString("USERDAO");
		
		//使用字节码文件获取实例化对象
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
