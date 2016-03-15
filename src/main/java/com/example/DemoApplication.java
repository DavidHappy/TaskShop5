package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import java.sql.*;

@SpringBootApplication
public class DemoApplication
{
	public static void main(String[] args)
	{
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
	}


//	@Autowired
//	private DataSource dataSource;
//
//	@PostConstruct
//	public void myRealMainMethod() throws SQLException {
//		Statement stmt = dataSource.getConnection().createStatement();
//		stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
//		stmt.executeUpdate("CREATE TABLE ticks (tick timestamp)");
//		stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
//		ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
//		while (rs.next()) {
//			System.out.println("Read from DB: " + rs.getTimestamp("tick"));
//		}
//	}
}
