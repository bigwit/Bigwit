package com.bigwit.services.config;

import java.util.logging.Logger;

public class BigwitConfig {

	private static Logger log = Logger.getLogger(BigwitConfig.class.getName());

	private static final String DEFAULT_VALUE = "default";
	
	/*	DataBase configuration	*/
	private static String DB_HOSTNAME_CONFIG = "default";
	private static String DB_PORT_LISTENER = "5353";
	private static String DB_USER_LOGIN_CONNECTION = DEFAULT_VALUE;
	private static String DB_USER_PASSWORD_CONNECTION = DEFAULT_VALUE;
	private static String DB_NAME_CONNECTION = DEFAULT_VALUE;
	
	public static BigwitConfig createDBConfiguration(String hostName, String port, String login,
			String password, String dbName) {
		DB_HOSTNAME_CONFIG = hostName;
		DB_PORT_LISTENER = port;
		DB_NAME_CONNECTION = dbName;
		DB_USER_LOGIN_CONNECTION = login;
		DB_USER_PASSWORD_CONNECTION = password;
		log.info("DB configuration initialized");
		return getInstance();
	}
	
	public String getDBHostName() {
		return DB_HOSTNAME_CONFIG;
	}
	
	public String getDBPort() {
		return DB_PORT_LISTENER;
	}
	
	public String getDBUserLogin() {
		return DB_USER_LOGIN_CONNECTION;
	}
	
	public String getDBUserPassword() {
		return DB_USER_PASSWORD_CONNECTION;
	}
	
	public String getDBName() {
		return DB_NAME_CONNECTION;
	}
	
	/*	Others configurations TODO here 	*/
	
	/*	Fake Singleton	*/
	private BigwitConfig() {}
	
	private static BigwitConfig instance = null;
	
	public static BigwitConfig getInstance() {
		return instance;
	}
	
	static {
		instance = new BigwitConfig();
	}

}
