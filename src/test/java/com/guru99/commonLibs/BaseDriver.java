package com.guru99.commonLibs;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseDriver {
	
	private WebDriver driver;
	private int pageloadTimeout;
	private int elementDetectionTimeout;
	
	private String currentWorkingDirectory;
	
	
	public BaseDriver(String browserType) throws Exception {
		
		pageloadTimeout=60;
		elementDetectionTimeout =10;
		currentWorkingDirectory = System.getProperty("user.dir");
		System.out.println(currentWorkingDirectory);
		
		if(browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", currentWorkingDirectory+"/drivers/chromedriver.exe");
		    driver= new ChromeDriver();
		  
		}
		else if(browserType.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", currentWorkingDirectory+"/drivers/MicrosoftWebDriver.exe");
		    driver= new EdgeDriver();
		 }
		else {
			throw new Exception("Invalid Browser Type");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setPageloadTimeout(int pageloadTimeout) {
		this.pageloadTimeout =pageloadTimeout;
	}
	
	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout =elementDetectionTimeout;
	}
	
	public void navigateToFirstUrl(String url) throws Exception{
		driver.manage().timeouts().pageLoadTimeout(pageloadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		url=url.trim();
		driver.get(url);
	}
	
	public String getTitle() throws Exception {
		String title= driver.getTitle();
		return title;
	}
	
	public String getCurrentUrl() throws Exception{
		return driver.getCurrentUrl();
	}
	
	public String getPageSource() throws Exception{
		return driver.getPageSource();
	}
	
	public void navigateForward() throws Exception{
		 driver.navigate().forward();
	}
	
	public void navigateBackWard() throws Exception{
		 driver.navigate().back();
	}
	
	public void refresh() throws Exception{
		driver.navigate().refresh();
	}
	
	public void closeBrowser() throws Exception{
		if(driver!=null) {
			driver.quit();
		}
	}
		
}
