package com.seascape.enterprise.data.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.seascape.enterprise.dao.AccountVerificationDao;
import com.seascape.enterprise.entity.UserAccount;
import com.seascape.enterprise.utilities.SystemUtils;

public class AccountVerificationQuery implements AccountVerificationDao {

	public Long generateAccountVerification(UserAccount user, Connection conn) {
		
		Long key=null;
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO xydbprod.account_verification( ");
			sql.append(" account_id");
			sql.append(",code");
			sql.append(",sent_date");
			sql.append(") VALUES (");
			sql.append("'"+user.getAccountId()+"','"+SystemUtils.generateSecureRandomCode()+"','"+SystemUtils.getEpoch()+"') ");
			
			PreparedStatement stmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			int affectedRows = stmt.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLException("Creating accountVerification failed, no rows affected.");
	        }

	        ResultSet generatedKeys = stmt.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            key=generatedKeys.getLong(1);
	        } else {
	            throw new SQLException("Creating accountVerification failed, no generated key obtained.");
	        }	

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return key;
	}

	
}
