package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.commonfuction;

public class Homepage extends Headerpage {
	
	

	
	public Homepage( WebDriver driver, ExtentTest logger)
	{
		super(driver,logger);
		PageFactory.initElements(driver, this);
	}

   @FindBy(xpath="//*[text()='My Pipeline']")
   WebElement map_pipeline;
   
   public void verifyPipelineMap()
	{
		
		cr.IsElementDisplay(map_pipeline,"Pipeline graph is displayed successfully");
	}
}
