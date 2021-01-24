package com.guru99.Utils;

import java.sql.SQLException;

import org.testng.annotations.DataProvider;

public class TestDataSource {
	
	//@DataProvider
	public Object[][] getData(){
		
		Object[][] data= new Object[3][2];
		
		data[0][0]="mngr303742";
		data[0][1]="pydApav";
		data[1][0]="mngr303742";
		data[1][1]="pydApav";
		data[2][0]="mngr303742";
		data[2][1]="pydApav";
		
		return data;
	}

	@DataProvider
	public Object[][] getDataFromDatabase() throws SQLException{
		
		Object[][] data;
		
		DatabaseUtils databaseUtils= new DatabaseUtils();
		
		String server = "localhost";
		int portNumber = 3306;
		String database= "Guru99TestData";
		String username="root";
		String password="Qwerpoiu123";
		databaseUtils.openConnection(server, portNumber, database, username, password);	
		String sqlQuery= "select * from users";
		data= databaseUtils.executeSqlSelectQuery(sqlQuery);
		databaseUtils.closeConnection();
		return data;
	}
}
