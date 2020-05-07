package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Demo {
	WebDriver driver;

	@Test
	public void f() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String name = driver.getTitle();
		System.out.println(name);
		driver.findElement(By.linkText("Registration"));

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Chrome 81\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.way2automation.com/demo.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() {

	}

}
