package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class Leadpage extends  Headerpage {

	public Leadpage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		PageFactory.initElements(driver, this);
	}
	   @FindBy(name="firstname")
	   WebElement tb_firstname;
	   @FindBy(name="lastname")
	   WebElement tb_lastname;
	   @FindBy(name="company")
	   WebElement tb_company;
	   @FindBy(name="button")
	   WebElement btn_button;
	   
	   public void creadlead(String fname,String lname,String cmpy)
	   {
		   setfirstname(fname);
		   setlastname(lname);
		   setcompany(cmpy);
		   ClickSave();
		   
		   
	   }
	   public void setfirstname(String fname)
	   {
		  cr.EnterValue(tb_firstname, fname, fname+"has been entered "); 
	   }
	   public void setlastname(String lname)
	   {
		  cr.EnterValue(tb_lastname, lname, lname+"has been entered "); 
	   }
	   public void setcompany(String cmpy)
	   {
		  cr.EnterValue(tb_company, cmpy, cmpy+"has been entered "); 
	   } 
	   public void ClickSave()
	   {
		  cr.ClickElement(btn_button, "save button clicked");
	   }
	  
	 
	   
	   
}
