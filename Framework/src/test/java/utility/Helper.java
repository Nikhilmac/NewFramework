package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	// ScreenShots,Alerts,Frames,Windows,Sync Issues,JavaScript Executor

	public static void captureScreenShots(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("./ScreenShots/" + getCurrentDateTime() + ".png"));
			System.out.println("ScreenShots Captured Successfully");
		} catch (IOException e) {
			System.out.println("Unable to Handle ScreenShots >>" + e.getMessage());
		}

	}

	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate = new Date();
		return customFormat.format(currentdate);
	}
}
