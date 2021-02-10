package seleniumautomation.com.stepDefinitions;

//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seleniumautomation.com.pageObject.Account;
import seleniumautomation.com.pageObject.CreateAccount;
import seleniumautomation.com.pageObject.CreateAccountForm;
import seleniumautomation.com.pageObject.Homepage;
import seleniumautomation.com.utils.EmailsGenerator;


public class CreateAccountFormTest {

	private WebDriver driver;
	private Homepage homepage;
	private CreateAccount createAccount;
	private CreateAccountForm createAccountForm;
	private Account account;

	@BeforeClass	
	@Given ("Accessing the application")
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\MyDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		homepage = new Homepage(driver);
		createAccount = new CreateAccount(driver);
		createAccountForm = new CreateAccountForm(driver);
		account = new Account(driver);

		String baseUrl = "http://automationpractice.com/index.php";
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@When ("I register my data")
	@Test(priority = 1)
	public void authenticationPage() {
		homepage.getSignInBtn().click();

		Assert.assertTrue(createAccount.getCreateAccountForm().isDisplayed());
		Assert.assertTrue(createAccount.getCreatAccountEmailField().isDisplayed());
		Assert.assertTrue(createAccount.getCreateAccountBtn().isDisplayed());
	}

	
	@Then ("I should be successful in registering a user")
	@Test(priority = 2)
	public void createAccountSuccessfully() {
		
		createAccount.setCreateAccountEmailField(EmailsGenerator.getNextEmail());
		
		createAccount.getCreateAccountBtn().click();
		createAccountForm.setCustomerFirstNameField("Rafael");
		createAccountForm.setCustomerLastNameField("Pereira");
		createAccountForm.setCustomerPasswordField("abcdef123");
		createAccountForm.selectCustomerDateOfBirthDay("6");
		createAccountForm.selectCustomerDateOfBirthMonth("12");
		createAccountForm.selectCustomerDateOfBirthYear("1982");
		createAccountForm.setAddressField("Av. Central, 1200 apt.708");
		createAccountForm.setCityField("Curitiba");
		createAccountForm.selectState("7");
		createAccountForm.setPostalCodeField("21000");
		createAccountForm.setHomePhoneField("055123456");
		createAccountForm.setMobilePhoneField("5189779");
		createAccountForm.setAddressAliasField("Rua Lateral, 200 casa");
		createAccountForm.getRegisterBtn().click();

		Assert.assertTrue(createAccountForm.successfullyCreatedAccount().isDisplayed());
		
	}
	
	@And ("The page should be finished")
	@AfterClass
	public void closeAll() {
		account.getAccountLogout().click();
		driver.quit();
	}

}
