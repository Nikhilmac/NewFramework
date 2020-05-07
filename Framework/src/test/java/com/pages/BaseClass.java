package com.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.BrowserFactory;
import utility.ConfigDataProvider;
import utility.ExcelDataProvider;
import utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {

		Reporter.log("Settings up reports and test is getting ready", true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/ZipERP" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Settings Done test can be started", true);

	}

	@BeforeClass
	public void setUp() {
		Reporter.log("Trying to start browser and getting application ready ", true);

		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		Reporter.log("Browser and application is up ", true);

	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitebrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			// Helper.captureScreenShots(driver);
			try {
				logger.fail("Test Failed",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
			} catch (IOException e) {
				System.out.println("Unable to handle Failed ScreenShots>>" + e.getMessage());
			}
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			try {
				logger.pass("Test Success",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
			} catch (IOException e) {
				System.out.println("Unable to handle Success ScreenShots>>" + e.getMessage());

			}

		}

		report.flush();

	}

}
