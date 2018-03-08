package com.freeCRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freeCRM.qa.base.TestBase;
import com.freeCRM.qa.pages.ContactsPage;
import com.freeCRM.qa.pages.DealsPage;
import com.freeCRM.qa.pages.HomePage;
import com.freeCRM.qa.pages.LoginPage;
import com.freeCRM.qa.pages.TasksPage;
import com.freeCRM.qa.util.TestUtils;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtils;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtils = new TestUtils();
		contactsPage = new ContactsPage();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyhomePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "Home Page Title not matched");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		testUtils.switchToFrameMainPanel();
		Assert.assertTrue(homePage.validateCorrectUserNameLabel());
	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		testUtils.switchToFrameMainPanel();
		contactsPage = homePage.clickOnContactsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
