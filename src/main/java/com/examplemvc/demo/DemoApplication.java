package com.examplemvc.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication extends DatabaseHandler {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SpringApplication.run(DemoApplication.class, args);
	}

}
