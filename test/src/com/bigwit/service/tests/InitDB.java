package com.bigwit.service.tests;

public class InitDB implements IRunTest {

	@Override
	public void runTest() {
		// connect to database and create all necessary data
	}

	@Override
	public String name() {
		return InitDB.class.getName();
	}
	
}
