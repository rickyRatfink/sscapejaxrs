package com.seascape.enterprise.data.queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seascape.enterprise.dao.CategoryDao;
import com.seascape.enterprise.entity.Category;

public class CategoryQuery implements CategoryDao {

	public List findAll(Connection conn) {

		List<Category> list = new ArrayList<Category>();
 
		try {
			Statement stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM category ";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long categoryId = rs.getLong("category_id");
				String title = rs.getString("title");
				Category category = new Category(categoryId, title);				
				list.add(category);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}
	
}
