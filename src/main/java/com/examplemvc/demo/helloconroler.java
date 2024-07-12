package com.examplemvc.demo;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;


@RestController
@RequestMapping("/api")
public class helloconroler extends DatabaseHandler {
   
    @RequestMapping("/json")
    public String jsonFun() throws ClassNotFoundException, SQLException {
        String result = "All surname:";
        DatabaseHandler db = new DatabaseHandler();
        String query = "select * from client";
		Statement statement = db.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			 result += resultSet.getString(2) + ", ";
		}
        return result.substring(0, result.length() - 2);
        
    }
    @RequestMapping("/json/get")
    //@GetMapping("/json/get")
    public String jsonGet(String email, String fio) throws ClassNotFoundException, SQLException {
        String result = "";
        DatabaseHandler db = new DatabaseHandler();
        String query = "insert into client (fio, email) VALUES ('Андровский Андрей Петрович', 'wewscvs@gmail.ru')";
		Statement statement = db.getConnection().createStatement();
		statement.executeUpdate(query);
        ResultSet resultSet = db.SelectAllClient();
		while (resultSet.next()) {
			 result += resultSet.getString(2) + ", ";
		}
        return result.substring(0, result.length() - 2);
        
    }
 
   
    @GetMapping("/data/{fio}")
    @ResponseBody
    public ResultSet getallclient() throws ClassNotFoundException, SQLException {
         
        DatabaseHandler db = new DatabaseHandler();
        String query = "select * from client";
		Statement statement = db.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			String fio = resultSet.getString(2);
			System.out.println(fio);
		}
         
        return resultSet;
    }
    @RequestMapping(value = "/greeting")
    public String helloConroler(@RequestParam(name = "name", required = false) String name, Model model) throws ClassNotFoundException, SQLException {
        model.addAttribute("name", name);
        return  "greeting";
      
    }
    

}

 
