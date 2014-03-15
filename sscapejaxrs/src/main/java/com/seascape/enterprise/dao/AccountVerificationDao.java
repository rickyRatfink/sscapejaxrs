package com.seascape.enterprise.dao;

import java.sql.Connection;

import com.seascape.enterprise.entity.UserAccount;

public interface AccountVerificationDao {

	public Long generateAccountVerification(UserAccount user, Connection conn);
}
