package com.guru99.commonLibs;

import org.openqa.selenium.WebElement;

public class UserInteractions {
	
	public String getText(WebElement element) throws Exception{
		
		return element.getText();
	}
	
	public void clickElement(WebElement element) throws Exception{
		element.click();
	}
	
	public String getAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	
	public String getCssValue(WebElement element, String csspropertyName) {
		return element.getCssValue(csspropertyName);
	}
	
	public boolean isElementEnabled(WebElement element) throws Exception {
		return element.isEnabled();
	}
	
	public boolean isElementVisible(WebElement element) throws Exception {
		return element.isDisplayed();
	}
	
	public boolean isElementSelected(WebElement element) throws Exception {
		return element.isSelected();
	}
	
	public void setText(WebElement element,String textToWrite){
		element.sendKeys(textToWrite);
	}
	
	public void clearText(WebElement element,String textToWrite){
		element.clear();
	}
}
