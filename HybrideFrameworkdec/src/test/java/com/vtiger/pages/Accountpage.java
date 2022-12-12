package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class Accountpage extends Headerpage {

	public Accountpage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		PageFactory.initElements(driver, this);
	
	}
	 @FindBy(name="accountname")
	   WebElement tb_accname;
	  @FindBy(name="button")
	   WebElement btn_button;
	 
	  public void setaccountname(String acname)
	   {
		  cr.EnterValue(tb_accname, acname, acname+"has been entered "); 
	   }
	  public void ClickSave()
	  {
		  cr.ClickElement(btn_button, "save button clicked");
	  }
	public void creataccount(String acname) {
		 setaccountname(acname);
		  ClickSave();
		
	}
}
