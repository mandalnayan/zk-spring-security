package com.iispl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Messagebox;

public class DBConnection {
	private static Connection con = null;
    private static final String USER = "root";
    private static final String PASSWORD = "root123";
    private static final String URL = "jdbc:mysql://localhost:3306/iispl";

    private DBConnection() { }
	
	public static Connection getConnection() {
        System.out.println("Entering connection..!");
        try {        	
            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(URL, USER, PASSWORD);
             
                System.out.println("Database connected successfully..!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("\nError..." + e.getMessage());
        }
        return con;
    }
	
	
}
