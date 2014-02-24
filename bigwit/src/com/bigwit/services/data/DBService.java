package com.bigwit.services.data;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class DBService {
	
	/*
	 * Подхватывать все параметры из конфигов.
	 * Предоставлять весь функционал наружу (для работы с данными)
	 * все что можно запихать в константы
	 */

	public void test() {

		User mike = new User();
		mike.setName("Mike");
		mike.setLastName("Jonson");
		mike.setAge(16);

		Connection connection = null;
		PreparedStatement query = null;

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			System.err.println("Driver not found");
			e1.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5333/postgres", "postgres", "00163325");
			query = connection.prepareStatement("insert into _user (name, lastname, age) values (?, ?, ?)");
			query.setString(1, mike.getName());
			query.setString(2, mike.getLastName());
			query.setInt(3, mike.getAge());
			query.execute();
		}catch(SQLException se){
			System.out.println("Problem with data insert");
		} finally{
			try{
				if(query != null) {query.close();}
				if(connection != null) {connection.close();}
			} catch(SQLException se) {}
		}
	}
	
	public static void main(String[] args) {
		DBService dbs = new DBService();
		dbs.test();
	}

}
