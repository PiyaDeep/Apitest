package com.vtiger.tests;

import org.testng.annotations.Test;

import com.vtiger.pages.Accountpage;
import com.vtiger.pages.Leadpage;
import com.vtiger.pages.Loginpage;

public class E2E extends Basetest{
	@Test
	public void TC03_creatLeadAndAccount()
	{
		String TCName = "TC03_creatLeadAndAccount";
		logger = extent.createTest(TCName);
		Loginpage lp = new Loginpage(driver,logger);
		lp.login(TestData.get(TCName).get("Userid"),TestData.get(TCName).get("Password"));
		//lp.login(TestData.get(TCName).get("Userid"),TestData.get(TCName).get("Password"));
		lp.verifyErrorMsg();
		Leadpage lpage=new Leadpage(driver,logger);
	    lpage.clickNewLead();
		lpage.creadlead(TestData.get(TCName).get("FirstName"),TestData.get(TCName).get("LastName"),TestData.get(TCName).get("Company"));
		Accountpage ac=new Accountpage(driver,logger);
		ac.clickAccount();
		ac.creataccount(TestData.get(TCName).get("AccountName"));
		ac.clicklogout();
		extent.flush();
	}

}
