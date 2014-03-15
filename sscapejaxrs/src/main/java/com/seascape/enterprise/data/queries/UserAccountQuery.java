package com.seascape.enterprise.data.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.seascape.enterprise.dao.UserAccountDao;
import com.seascape.enterprise.entity.UserAccount;
import com.seascape.enterprise.utilities.SystemUtils;

public class UserAccountQuery implements UserAccountDao {

	public List findAll(Connection conn) {

		List<UserAccount> list = new ArrayList<UserAccount>();

		try {
			Statement stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM user_account limit 10 ";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long accountId = rs.getLong("account_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String emailAddress = rs.getString("email_address");
				String gender = rs.getString("gender");
				String dob = rs.getString("dob");
				String location = rs.getString("location");
				String contactPhone = rs.getString("contact_phone");
				String tosAgreementFlag = rs.getString("tos_agreement_flag");
				String creationDate = rs.getString("creation_date");
				String verifiedDate = rs.getString("verified_date");
				int age = 0;// (Integer.parseInt(rs.getString("age"))).intValue();
				UserAccount user = new UserAccount(accountId, username,
						password, emailAddress, dob, gender, contactPhone, location,
						tosAgreementFlag, creationDate, verifiedDate);
				list.add(user);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}
	
	public UserAccount findById(Long id, Connection conn) {

		UserAccount user = null;

		try {
			String sql = "SELECT * FROM user_account where account_id=? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Long accountId = rs.getLong("account_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String emailAddress = rs.getString("email_address");
				String gender = rs.getString("gender");
				String dob = rs.getString("dob");
				String location = rs.getString("location");
				String contactPhone = rs.getString("contact_phone");
				String tosAgreementFlag = rs.getString("tos_agreement_flag");
				String creationDate = rs.getString("creation_date");
				String verifiedDate = rs.getString("verified_date");
				int age = 0;// (Integer.parseInt(rs.getString("age"))).intValue();
				user = new UserAccount(accountId, username,
						password, emailAddress, dob, gender, contactPhone, location,
						tosAgreementFlag, creationDate, verifiedDate);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return user;
	}

	public Long createAccountUser(UserAccount user, Connection conn) {
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO xydbprod.user_account( ");
			sql.append("		  username");
			sql.append("		  ,password");
			sql.append("		  ,email_address");
			sql.append("		  ,dob");
			sql.append("		  ,gender");
			sql.append("		  ,creation_date");
			sql.append("		  ,verified_date");
			sql.append("		  ,tos_agreement_flag");
			sql.append("		  ,location");
			sql.append("		  ,contact_phone");
			sql.append("		) VALUES (");
			sql.append("'"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmailAddress()+"','"+user.getDob()+"','"+user.getGender()+"','");
			sql.append(SystemUtils.getEpoch()+"','"+SystemUtils.getEpoch()+"','");
					sql.append(user.getTosAgreementFlag()+"','"+user.getLocation()+"','"+user.getContactPhone()+"') ");
		
			PreparedStatement stmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			int affectedRows = stmt.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
	        }

	        ResultSet generatedKeys = stmt.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            user.setAccountId(generatedKeys.getLong(1));
	        } else {
	            throw new SQLException("Creating user failed, no generated key obtained.");
	        }	

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return user.getAccountId();
	}

	public void updateAccountUser(UserAccount user) {
	}

	public void deleteAccountUser(UserAccount user) {

	}
}
