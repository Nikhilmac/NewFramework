package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class casethree {
	public WebDriver driver;

	@Test
	public void f() {
		String beforename = driver.getTitle();
		System.out.println(beforename + " = Title Name Before Login");
		String beforeurl = driver.getCurrentUrl();
		System.out.println(beforeurl + "= URL Before Login");
		driver.findElement(By.id("EnterpriseId")).sendKeys("maco");
		driver.findElement(By.id("UserId")).sendKeys("ziperpdemo");
		driver.findElement(By.id("Password")).sendKeys("123");
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("txtCompanySearch")).sendKeys("Demo Company");
		driver.findElement(By.xpath("//td/label[text()='Demo Company']")).click();
		String aftername = driver.getTitle();
		System.out.println(aftername + " = Title Name After Login");
		String afterurl = driver.getCurrentUrl();
		System.out.println(afterurl + "= URL After Login");

	}

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Chrome 80.3987.106\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://pro.ziperp.net/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
