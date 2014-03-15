package com.seascape.enterprise.dao;

import java.sql.Connection;
import java.util.List;

public interface CategoryDao {

	public List findAll(Connection conn);
	
}
