package com.vtiger.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.pages.Homepage;
import com.vtiger.pages.Loginpage;
import com.vtiger.tests.Basetest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Logintest extends Basetest {
	
	
	
	
	@Test
	public void TC01_InvalidLogin()
	{
		String TCName = "T01_Invalidlogin";
		logger = extent.createTest(TCName);
		Loginpage lp = new Loginpage(driver,logger);
		lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password"));
		lp.verifyErrorMsg();
		extent.flush();
	}
	
	@Test
	public void T02_validlogin()
	{	
		String TCName = "T02_validlogin";
		logger = extent.createTest(TCName);
		Loginpage lp = new Loginpage(driver,logger);
		lp.login(TestData.get(TCName).get("Userid"),TestData.get(TCName).get("Password"));
		Homepage hp = new Homepage(driver,logger);		
		hp.clicklogout();
		extent.flush();
		
	}

}
