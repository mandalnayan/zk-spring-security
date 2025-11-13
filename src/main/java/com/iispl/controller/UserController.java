package com.iispl.controller;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

import com.iispl.dao.UserDAO;
import com.iispl.model.User;

public class UserController extends SelectorComposer<Window>{

	@Listen("onClick=#fetchUserData")
	public void getUser() {
		User user = UserDAO.getUserByUsername("aaa@");
		System.out.println("User:: " + user);
		alert("User: " + user.getEmail() + " Pass: " + user.getPassword());
	}
}
