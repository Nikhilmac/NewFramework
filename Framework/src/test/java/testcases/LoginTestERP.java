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

	@Test
	public void loginapp() {

		Loginpage loginpage = PageFactory.initElements(driver, Loginpage.class);

		loginpage.loginToErp(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1), "13",
				excel.getStringData("Login", 0, 3));

//	 loginpage.loginToErp("maco", "ZiperpDemo", "123", "Demo Company");

		String aftername = driver.getTitle();
		System.out.println(aftername + " = Title Name After Login");
		String afterurl = driver.getCurrentUrl();
		System.out.println(afterurl + "= URL After Login");
	}

}
