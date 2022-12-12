package com.vtiger.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;


public class commonfuction {

	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest logger;

	public   commonfuction(WebDriver driver, ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
		wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	
	public void EnterValue(WebElement elm,String value, String details)
	{
		try {
			
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.clear();
			elm.sendKeys(value);
			logger.pass(details);
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");
	
		}
	}
	
	public void SelectDropdownValue(WebElement elm,String value,String details)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(elm));
		Select s=new Select(elm);
		s.selectByVisibleText(value);
		logger.pass(details);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");

		}
	}
	

	public void ClickElement(WebElement elm,String details)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.click();
			logger.pass(details);
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");

		}
	}
	
	
	public void IsElementDisplay(WebElement elm,String details)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.isDisplayed();
			logger.pass(details);

		
			
		} catch (Exception e)
		{
			
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");

		}
	}
	
	//common function for APT Testing
	public void VarifyStatusLine(WebElement exp,String act)
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
	public void WriteRequestRsponceinReport(WebElement req,String res)
	{
		logger.info("Request"+req);
		logger.info("Response"+res);
		
	}
	
	
		public String getscreenshot() 
		{
			DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
			Date d = new Date();
			String str = f.format(d);
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/screenshots/image"+str+".png";
			//Move image file to new destination
			File DestFile=new File(path);
			//Copy file at destination
			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return path;
			
		}
	}


	

