package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.commonfuction;




public class Loginpage {
	
	private WebDriver driver;
    private commonfuction cf;
    ExtentTest logger;
	
	public Loginpage( WebDriver driver, ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
		cf=new commonfuction(driver,logger);
	}

   @FindBy(name="user_name")
   WebElement tb_username;
   @FindBy(name="user_password")
   WebElement tb_userpwd;
   @FindBy(name="Login")
   WebElement btn_userlogin;
  // @FindBy(xpath="//*[contains(text(),'You must specify a valid username and password')]")
	@FindBy(xpath="//*[contains(text(),'You must specify a valid username and password.')]")

   WebElement txterrmsg;
   public void verifyErrorMsg()
	{
		cf.IsElementDisplay(txterrmsg,"Error message validated successfully");
	}

   public void login(String userid,String pwd)
   {
	   setUserid(userid);
	   setPassword(pwd);
	   clickLogin();
   }
   
	public void setUserid(String userid)
	{
		cf.EnterValue(tb_username, userid,userid+"entered successfully into User Name field");
	}
	
	public void setPassword(String pwd)
	{
		cf.EnterValue(tb_userpwd, pwd,pwd+"entered successfully into Password field");
	}
	
	public void clickLogin()
	{
		
		cf.ClickElement(btn_userlogin,"Login button clicked successfully");
	}
	
   
   }

	
