package com.freeCRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freeCRM.qa.base.TestBase;
import com.freeCRM.qa.pages.ContactsPage;
import com.freeCRM.qa.pages.HomePage;
import com.freeCRM.qa.pages.LoginPage;
import com.freeCRM.qa.util.TestUtils;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtils;
	ContactsPage contactsPage;
	
	String sheetName ="contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtils = new TestUtils();
		contactsPage = new ContactsPage();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testUtils.switchToFrameMainPanel();
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.validateContactsLabel());
	}

	
	@Test(priority = 2)
	public void selectContactsTest() {
		contactsPage.selectContactsByName("Tom Tom");
	}
	
	@DataProvider
	public Object[][] getCRMContactsData() {
		Object data[][] = TestUtils.getTestData(sheetName);
		return data;
	}

	@Test(priority = 3, dataProvider = "getCRMContactsData")
	public void validateNewContact(String title, String fname, String lname, String comp) {
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Bat", "Man", "Gotham");
		contactsPage.createNewContact(title, fname, lname, comp);
		}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
