package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	public static WebDriver startApplication(WebDriver driver, String browsername, String appurl) {

		if (browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.firefox.driver", "./Drivers/chromedriver.exe");
			driver = new FirefoxDriver();

		} else if (browsername.equals("IE")) {
			System.setProperty("webdriver.IE.driver", "./Drivers/chromedriver.exe");
			driver = new InternetExplorerDriver();

		} else {

			System.out.println("Doesnot support any browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(appurl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public static void quitebrowser(WebDriver driver) {
		driver.quit();
	}
}
