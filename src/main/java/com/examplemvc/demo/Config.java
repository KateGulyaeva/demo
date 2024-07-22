package com.examplemvc.demo;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    protected String dbHost = "localhost";
    protected String dbPort = "5432";
    protected String dbUser = "sa";
    protected String dbPass = "1";
    protected String dbName = "postgres";
}
