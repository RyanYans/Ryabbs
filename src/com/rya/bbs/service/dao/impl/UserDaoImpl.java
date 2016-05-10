package com.rya.bbs.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rya.bbs.service.dao.IUserDao;
import com.rya.bbs.userbean.UserBean;
import com.rya.bbs.utils.JdbcUtil;

public class UserDaoImpl implements IUserDao {
	
	
	public UserBean selectUser(String username, String password) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		UserBean user = null;
		
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			//获取执行的sql语句对象
			pstm = conn.prepareStatement("select username, password, birthday, email from user where username=? and password=?");
			
			//设置占位符
			pstm.setString(1, username);
			pstm.setString(2, password);
			
			//执行sql语句
			rs = pstm.executeQuery();
			
			//判断结果集
			if(rs.next()){
				user = new UserBean();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setBirthday(rs.getDate("birthday"));
				user.setEmail(rs.getString("email"));
				
			}
			return user;
		}catch (Exception e) {
			throw new RuntimeException("Can not found user...");
		}finally{
			JdbcUtil.release(rs, pstm, conn);
		}
	}

	public UserBean selectUserByName(String username) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		UserBean user = null;
		
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			//获取执行的sql语句对象
			pstm = conn.prepareStatement("select username, password, birthday, email from user where username=? ");
			
			//设置占位符
			pstm.setString(1, username);
			
			//执行sql语句
			rs = pstm.executeQuery();
			
			//判断结果集
			if(rs.next()){
				user = new UserBean();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setBirthday(rs.getDate("birthday"));
				user.setEmail(rs.getString("email"));
				
			}
			return user;
		}catch (Exception e) {
			throw new RuntimeException("Can not found user...");
		}finally{
			JdbcUtil.release(rs, pstm, conn);
		}
	}

	public int addUser(UserBean user) {
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			//获取执行的sql语句对象
			pstm = conn.prepareStatement("insert into user( username, password, birthday, email) values(?,?,?,?)");
			
			//设置占位符
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPassword());
			
			//使用java.util.Date的毫秒值来创建一个java.sql.Date对象
			pstm.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			pstm.setString(4, user.getEmail());
			
			//执行sql语句
			int res = pstm.executeUpdate();
			
			//返回结果
			return res;
			
		}catch (Exception e) {
			throw new RuntimeException("Can not add user..." + e);
		}finally{
			JdbcUtil.release(null, pstm, conn);
		}
	}
}
