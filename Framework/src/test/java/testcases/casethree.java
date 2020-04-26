package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class casethree {
	public WebDriver driver;

	@Test
	public void f() {
		String name = driver.getTitle();
		System.out.println(name + " = Title Name");
		String url = driver.getCurrentUrl();
		System.out.println(url + "= URL");

	}

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Chrome 80.3987.106\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
