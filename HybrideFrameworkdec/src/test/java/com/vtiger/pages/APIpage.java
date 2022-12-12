package com.vtiger.pages;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.commonfuction;
import com.vtiger.tests.Basetest;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest. Matchers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIpage extends  Basetest {
	
    ExtentTest logger;
	
	public APIpage(  ExtentTest logger)
	{
		
		this.logger=logger;
	
	}
public void VarifyJsonResponce(String exp,String act)
{
	try {
		Assert.assertEquals(act, exp);
		logger.pass("Expected data "+exp+"Matched with actual json data  ");
	} catch (Exception e)
	{
		
		e.printStackTrace();
		logger.fail(e.getMessage());
	}
	
}
  

	public void VarifyStatusLine(String exp,String act)
	{
		try {
			Assert.assertEquals(act, exp);
			logger.pass("Status line "+exp+"Matched with actual status line  ");
		} catch (Exception e)
		{
			
			e.printStackTrace();
			logger.fail(e.getMessage());
		}
	}
	public void WriteRequestRsponceinReport(String req,String res)
	{
		logger.info("Request"+req);
		logger.info("Response"+res);
		
	}
	
   
   }