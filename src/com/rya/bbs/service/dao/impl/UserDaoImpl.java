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
			//��ȡ����
			conn = JdbcUtil.getConnection();
			
			//��ȡִ�е�sql������
			pstm = conn.prepareStatement("select username, password, birthday, email from user where username=? and password=?");
			
			//����ռλ��
			pstm.setString(1, username);
			pstm.setString(2, password);
			
			//ִ��sql���
			rs = pstm.executeQuery();
			
			//�жϽ����
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
			//��ȡ����
			conn = JdbcUtil.getConnection();
			
			//��ȡִ�е�sql������
			pstm = conn.prepareStatement("select username, password, birthday, email from user where username=? ");
			
			//����ռλ��
			pstm.setString(1, username);
			
			//ִ��sql���
			rs = pstm.executeQuery();
			
			//�жϽ����
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
			//��ȡ����
			conn = JdbcUtil.getConnection();
			
			//��ȡִ�е�sql������
			pstm = conn.prepareStatement("insert into user( username, password, birthday, email) values(?,?,?,?)");
			
			//����ռλ��
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPassword());
			
			//ʹ��java.util.Date�ĺ���ֵ������һ��java.sql.Date����
			pstm.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			pstm.setString(4, user.getEmail());
			
			//ִ��sql���
			int res = pstm.executeUpdate();
			
			//���ؽ��
			return res;
			
		}catch (Exception e) {
			throw new RuntimeException("Can not add user..." + e);
		}finally{
			JdbcUtil.release(null, pstm, conn);
		}
	}
}
