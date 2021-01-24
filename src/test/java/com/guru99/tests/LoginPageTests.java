package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.guru99.Page.LoginPage;
import com.guru99.Utils.TestDataSource;
import com.guru99.commonLibs.BaseDriver;

public class LoginPageTests{
	
	BaseDriver baseDriver;
	
	String url= "http://demo.guru99.com/v4";
	
	LoginPage loginPage;

	@Parameters("browserType") 
	@BeforeMethod
	public void setup(String browserType) throws Exception {
		baseDriver= new BaseDriver(browserType);
		
		baseDriver.navigateToFirstUrl(url);
		
		loginPage = new LoginPage(baseDriver.getDriver());

  }
	
	@Test(dataProvider="getDataFromDatabase", dataProviderClass=TestDataSource.class)
	public void verifyLogin(String username, String password) throws Exception{
				
		loginPage.LoginToApplication(username, password);
		
		Thread.sleep(3000);
		
		String actualTitle = baseDriver.getTitle();
		
		String expectedTitle ="Guru99 Bank Manager HomePage";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
	 }
	
	@AfterMethod
	public void cleanUp() throws Exception {
		baseDriver.closeBrowser();
		}
}