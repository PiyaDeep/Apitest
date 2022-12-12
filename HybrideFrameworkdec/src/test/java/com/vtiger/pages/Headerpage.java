package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.commonfuction;

public class Headerpage {
	public WebDriver driver;
	public commonfuction cr;
	 ExtentTest logger;
	public Headerpage( WebDriver driver,ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
		cr=new commonfuction(driver,logger);
	}
	  @FindBy(linkText="Home")
	   WebElement lnk_Home;
	   @FindBy(linkText="Calendar")
	   WebElement lnk_Calendar;
	   @FindBy(linkText="Activities")
	   WebElement lnk_Activities;
	   @FindBy(linkText="New Lead")
	   WebElement lnk_NewLeads;
	   
	   @FindBy(linkText="Accounts")
	   WebElement lnk_Accounts;
	   @FindBy(linkText="Contacts")
	   WebElement lnk_Contacts;
	   @FindBy(linkText="Potentials")
	   WebElement lnk_Potentials;
	   @FindBy(linkText="Products")
	   WebElement lnk_Products;
	   @FindBy(linkText="Logout")
	   WebElement lnk_Logout;
	   public void clickNewLead()
	   {
			cr.ClickElement(lnk_NewLeads,"NewLead  link clicked successfully");
		  
		 
	   }
	   public void clickAccount()
	   {
			cr.ClickElement(lnk_Accounts,"Account  link clicked successfully");
		  
		 
	   }
	   public void Varifylogout()
	   {
			cr.IsElementDisplay(lnk_Logout,"Logout link displayed successfully");
		 //return lnk_Logout.isDisplayed();  
	   }
	   public void clicklogout()
	   {
			cr.ClickElement(lnk_Logout,"Logout link clicked successfully");
		   //lnk_Logout.click();
	   }
	   
}
