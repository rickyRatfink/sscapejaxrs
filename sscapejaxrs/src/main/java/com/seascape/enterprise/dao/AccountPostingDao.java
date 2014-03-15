package com.seascape.enterprise.dao;

import java.sql.Connection;
import java.util.List;

import com.seascape.enterprise.entity.AccountPosting;

public interface AccountPostingDao {
	
	public List findAll(Connection conn);
	public AccountPosting create(AccountPosting post, Connection conn);
	public List search(AccountPosting searchObj, Connection conn);
	public void delete(Long key, Connection conn);
	public void update(Long key, Connection conn);

}
