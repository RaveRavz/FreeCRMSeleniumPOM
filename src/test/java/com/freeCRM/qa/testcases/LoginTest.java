package com.freeCRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freeCRM.qa.base.TestBase;
import com.freeCRM.qa.pages.HomePage;
import com.freeCRM.qa.pages.LoginPage;

public class LoginTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	//@Test(priority = 1, retryAnalyzer = RetryAnalyzer.RetryAnalyzer.class)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Softwar");
	}

	@Test(priority = 2)
	public void loginPageLogoTest() {
		boolean isLoginLogo = loginPage.validateLoginPageLogo();
		Assert.assertTrue(isLoginLogo);
	}

	@Test(priority = 3)
	public void loginCheckTest() {
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
