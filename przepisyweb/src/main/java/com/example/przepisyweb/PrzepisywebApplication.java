package com.example.przepisyweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class PrzepisywebApplication {


	public static void main(String[] args) throws SQLException{
		SpringApplication.run(PrzepisywebApplication.class, args);

//		DatabaseConnetion mysqlConnect = new DatabaseConnetion();
//
//		String sql = "SELECT * FROM `user`";
//		try {
//			PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
//			statement.execute();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			mysqlConnect.disconnect();
//		}
}
}
