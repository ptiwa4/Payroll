package com.payroll.database;

public abstract class DatabaseFactory {
	
	public static DatabaseFactory DB_FACTORY_INSTANCE;
	protected Database database;

	public abstract Database getDatabase();
}
