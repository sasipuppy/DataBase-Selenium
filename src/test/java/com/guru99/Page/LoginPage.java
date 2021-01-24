package com.guru99.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.commonLibs.UserInteractions;

public class LoginPage {
	
	@FindBy(name="uid")
	public WebElement userId;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[2]/td[2]/input")
	public WebElement userPassword;
	
	@FindBy(name="btnLogin")
	public WebElement loginButton;
	
	UserInteractions interactions = new UserInteractions(); 
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void LoginToApplication(String sUsername, String sPassword) throws Exception {
		interactions.setText(userId, sUsername);
		interactions.setText(userPassword, sPassword);
		interactions.clickElement(loginButton);
	}

}
