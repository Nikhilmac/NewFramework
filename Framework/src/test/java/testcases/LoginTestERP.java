package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pages.BaseClass;
import com.pages.Loginpage;

import utility.BrowserFactory;
import utility.ExcelDataProvider;

public class LoginTestERP extends BaseClass {
	// WebDriver driver;

	@Test(priority = 1)
	public void loginapp() {

		logger = report.createTest("Login to ZipERP");

		Loginpage loginpage = PageFactory.initElements(driver, Loginpage.class);
		logger.info("Starting Application");

		loginpage.loginToErp(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1), "123",
				excel.getStringData("Login", 0, 3));
		logger.pass("Login Pass");

//	 loginpage.loginToErp("maco", "ZiperpDemo", "123", "Demo Company");

		String aftername = driver.getTitle();
		System.out.println(aftername + " = Title Name After Login");
		String afterurl = driver.getCurrentUrl();
		System.out.println(afterurl + "= URL After Login");
	}

	@Test(priority = 2)
	public void loginapp1() {

		logger = report.createTest("Login to ZipERP");

		logger.fail("Login Failed");

	}

}
