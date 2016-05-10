package com.rya.bbs.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import com.rya.bbs.service.IUserService;
import com.rya.bbs.service.impl.UserServiceImpl;
import com.rya.bbs.userbean.UserBean;

public class IUserServiceTest {

	/**
	 * junit µ¥Ôª²âÊÔ
	 */
	
	private IUserService service = new UserServiceImpl();
	
	@Test
	public void testFindUser() {
		UserBean user = service.findUser("rya", "zxzx0769");
		System.out.println(user);
		assertEquals("1234@gmail.com", user.getEmail());
	}

	@Test
	public void testFindUserByName() {
		UserBean user = service.findUserByName("rya");
		
		assertEquals("1234@gmail.com", user.getEmail());
	}

	@Test
	public void testSaveUser() {
		UserBean user = new UserBean("rya","zxzx0769",new Date(),"1234@gmail.com");
		
		int res = service.saveUser(user);
		
		assertEquals(1, res);
	}

}
