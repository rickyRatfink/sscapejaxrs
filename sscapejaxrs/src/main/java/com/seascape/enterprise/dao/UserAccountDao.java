package com.seascape.enterprise.dao;

import java.sql.Connection;
import java.util.List;

import com.seascape.enterprise.entity.UserAccount;

public interface UserAccountDao {

	public List findAll(Connection conn);
	public UserAccount findById(Long id, Connection conn);
	public Long createAccountUser(UserAccount user, Connection conn);
	public void updateAccountUser(UserAccount user);
	public void deleteAccountUser(UserAccount user);
	
}
