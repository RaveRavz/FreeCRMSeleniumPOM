package com.freeCRM.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freeCRM.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR:
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement SignUp;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement LoginPageLogo;

	// Initializing the Page Objects:
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// Actions - Features:

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLoginPageLogo() {
		return LoginPageLogo.isDisplayed();
	}

	public HomePage Login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		// Thread.sleep(2000);
		loginbtn.sendKeys(Keys.RETURN);
		return new HomePage();
	}

}
