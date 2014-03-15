package com.seascape.enterprise.data.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seascape.enterprise.dao.AccountPostingDao;
import com.seascape.enterprise.entity.AccountPosting;
import com.seascape.enterprise.utilities.SystemUtils;

public class AccountPostingQuery implements AccountPostingDao {

	public List findAll(Connection conn) {

		List<AccountPosting> list = new ArrayList<AccountPosting>();
 
		try {
			Statement stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM account_posting ";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long postingId = rs.getLong("posting_id");
				Long accountId = rs.getLong("account_id");
				Long categoryId= rs.getLong("category_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String location = rs.getString("location");
				String postDate = rs.getString("post_date");
				Long primaryPhotoId = rs.getLong("primary_photo_id");
				String activeFlag = rs.getString("active_flag");
				
				AccountPosting post = new AccountPosting(postingId, accountId, categoryId, title, description, location, postDate, primaryPhotoId, activeFlag);
				list.add(post);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}
	
	public AccountPosting findById(Long id, Connection conn) {

		AccountPosting post = null;

		try {
			String sql = "SELECT * FROM account_posting where posting_id=? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Long postingId = rs.getLong("posting_id");
				Long accountId = rs.getLong("account_id");
				Long categoryId= rs.getLong("category_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String location = rs.getString("location");
				String postDate = rs.getString("post_date");
				Long primaryPhotoId = rs.getLong("primary_photo_id");
				String activeFlag = rs.getString("active_flag");
				
				post = new AccountPosting(postingId, accountId, categoryId, title, description, location, postDate, primaryPhotoId, activeFlag);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return post;
	}

	public AccountPosting create(AccountPosting post, Connection conn) {
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO xydbprod.account_posting( ");
			sql.append("		  account_id");
			sql.append("		  ,category_id");
			sql.append("		  ,title");
			sql.append("		  ,description");
			sql.append("		  ,location");
			sql.append("		  ,post_date");
			sql.append("		  ,primary_photo_id");
			sql.append("		  ,active_flag");
			sql.append("		) VALUES (");
			sql.append(post.getAccountId()+","+post.getCategoryId()+",'"+post.getTitle()+"','"+post.getDescription()+"','"+post.getLocation()+"','");
			sql.append(SystemUtils.getEpoch()+"',"+post.getPrimaryPhotoId()+",'Yes') ");
				
			PreparedStatement stmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			int affectedRows = stmt.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLException("Creating posting failed, no rows affected.");
	        }

	        ResultSet generatedKeys = stmt.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            post.setAccountId(generatedKeys.getLong(1));
	        } else {
	            throw new SQLException("Creating posting failed, no generated key obtained.");
	        }	

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return post;
	}

	public List search(AccountPosting post, Connection conn) {
		return new ArrayList();
	}
	
	public void update(Long key,Connection conn) {
	}

	public void delete(Long key,Connection conn) {

	}
}
