package com.payroll.database;

public class DatabaseFactoryImpl extends DatabaseFactory {

	public DatabaseFactoryImpl() {
		DB_FACTORY_INSTANCE = this;
	}

	@Override
	public Database getDatabase() {
		if (database == null) {
			database = new PayrollDatabase();
		}
		return database;
	}

}
