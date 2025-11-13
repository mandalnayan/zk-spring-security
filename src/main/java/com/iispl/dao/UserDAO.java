package com.iispl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.zkoss.zhtml.Pre;
import org.zkoss.zk.ui.util.Clients;

import com.iispl.db.DBConnection;
import com.iispl.model.User;

public class UserDAO {

	public static User getUserByUsername(String userName) {
		System.out.println("\nEntering user Dao...");
		try(Connection con = DBConnection.getConnection();) {
			System.out.println("\nInside User Dao");
			PreparedStatement pstmt = con.prepareStatement("Select * from User where email = ?");
			pstmt.setString(1, userName);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				System.out.println("USER: n" + user);
				return user;
			}
			System.out.println("\nExit from User Dao...");
			
		}catch(SQLException ex) {
			System.out.println("\nError..." + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	
	}
}
