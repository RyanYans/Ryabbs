package com.rya.bbs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * ���ݿ����ӵĹ�����
 * 1.��ȡ����
 * 2.�ͷ���Դ
 * 
 * @author Ryan_yuans
 *
 */
public class JdbcUtil {
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("com.rya.bbs.properties.dbconfig");
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static{
			//ʹ��JdbcUtil.class.getClassLoder ��ȡprop��Ϣ
		/*try {
			InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("com/rya/bbs/propertise/dbConfig.properties");
			Properties prop = new Properties();
			prop.load(in);
			
			driver=prop.getProperty("DRIVER");
			url = prop.getProperty("URL");
			// ...
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		
		driver = BUNDLE.getString("DRIVER");
		url = BUNDLE.getString("URL");
		user = BUNDLE.getString("USER");
		password = BUNDLE.getString("PASSWORD");
		
	}
	
	/**
	 * ��ȡ���ݿ�����
	 */
	public static Connection getConnection() throws Exception{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
	}
	
	/**
	 * �ͷ���Դ
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public static void release(ResultSet rs, Statement st, Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

