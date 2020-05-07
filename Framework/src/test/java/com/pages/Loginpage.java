package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {
	WebDriver driver;

	public Loginpage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(id = "EnterpriseId")
	WebElement EnterpriseId;
	@FindBy(id = "UserId")
	WebElement uid;
	@FindBy(id = "Password")
	WebElement pass;
	@FindBy(linkText = "Sign In")
	WebElement loginbutton;
	@FindBy(id = "txtCompanySearch")
	WebElement companynames;
	@FindBy(xpath = "//td/label[text()='Demo Company']")
	WebElement companylogin;

	public void loginToErp(String enterpriseid, String userid, String pswrd, String Companyname) {
		EnterpriseId.sendKeys(enterpriseid);
		uid.sendKeys(userid);
		pass.sendKeys(pswrd);
		loginbutton.click();
		companynames.sendKeys(Companyname);
		companylogin.click();
	}
}
